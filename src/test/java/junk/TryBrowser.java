package junk;

import com.trello.core.BrowserFactory;
import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Epic")
@Feature("Feature")
@Story("Story")
//@Attachment(value = "Page screenshot", type = "image/png")
public class TryBrowser extends BrowserFactory {

    @Test(groups = {"regression", "emails"})
    public void openClose() {

        driver().get("https://google.com");
    }
}
