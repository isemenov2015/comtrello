package com.trello.ui.pages;

import com.trello.core.Constants;
import com.trello.core.Elem;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import static com.trello.core.BrowserFactory.get;

public class LoginPage {

    private static final String PATH = "login";

    public Elem emailField = new Elem(By.cssSelector("#user"), "Login Field");
    public Elem passwordField = new Elem(By.cssSelector("#password"), "Password Field");
    public Elem loginBtn = new Elem(By.cssSelector("#login"), "Login Button");

    @Step("OPEN PAGE: " + PATH)
    public void open() {
        get(Constants.URL + PATH);
        Assert.assertTrue(isOpened(), "Page 'login' [" + PATH + "] not opened");
    }

    @Step
    public void login(String email, String password) {
        emailField.type(email);
        passwordField.type(password);
        loginBtn.click();
    }

    public boolean isOpened() {
        return loginBtn.isPresent();
    }
}
