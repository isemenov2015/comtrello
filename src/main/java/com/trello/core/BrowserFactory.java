package com.trello.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BrowserFactory {

    private static WebDriver driver;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeTest
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/home/ilyasemenov/Chromedriver/chromedriver");
        driver = new ChromeDriver();
        logger.info("Browser started");
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
        logger.info("Browser closed");
    }

    public static WebDriver driver() {
        return driver;
    }

    public static void get(String url) {
        driver().get(url);
    }

    public static WebDriverWait getWebDriverWait(long timeout){
        return new WebDriverWait(driver(), timeout);
    }

}
