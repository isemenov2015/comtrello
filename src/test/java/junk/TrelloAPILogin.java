package junk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.trello.core.BrowserFactory;
import okhttp3.Cookie;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.trello.core.BrowserFactory.driver;

public class TrelloAPILogin extends BrowserFactory {

    CookieStorage cookieStorage = new CookieStorage();
    OkHttpClient client = new OkHttpClient.Builder().cookieJar(cookieStorage).build();
    Gson gson = new Gson();

    @Test
    public void testCookies() throws IOException {
        client.newCall(new Request.Builder().url("https://trello.com").build()).execute().body().string();
    }

    @Test
    public void loginByApi() throws IOException, InterruptedException {

        FormBody formData = new FormBody.Builder()
                .add("method", "password")
                .add("factors[user]", "sumigoxuci@mailsource.info")
                .add("factors[password]", "werter321")
                .build();
        Request request = new Request.Builder().url("https://trello.com/1/authentication").post(formData).build();
        String response = client.newCall(request).execute().body().string();
        Map<String, String> map = gson.fromJson(response, new TypeToken<Map<String, String>>(){}.getType());
        String code = map.get("code");
        System.out.println("CODE: " + code);

        System.out.println(cookieStorage.cookies);

        //SESSION
        String dsc = cookieStorage.cookies.stream().filter(cookie -> cookie.name().equals("dsc")).findFirst().get().value();
        FormBody sessionFormData = new FormBody.Builder()
                .add("authentication", code)
                .add("dsc", dsc)
                .build();
        Request requestSession = new Request.Builder().url("https://trello.com/1/authorization/session").post(sessionFormData).build();
        response = client.newCall(requestSession).execute().body().string();
        System.out.println(response);

        driver().get("https://trello.com");
        for (Cookie cookie : cookieStorage.cookies) {
            //System.out.println(cookie.name() + ": " + cookie.value());
            org.openqa.selenium.Cookie seleniumCookie = new org.openqa.selenium.Cookie(cookie.name(), cookie.value());
            driver().manage().addCookie(seleniumCookie);
        }
        driver().navigate().refresh();
        Thread.sleep(1000);
    }
}
