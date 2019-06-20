package com.trello.ui.pages;

import com.trello.core.Elem;
import org.openqa.selenium.By;

public class BoardsPage {

    private static final String PATH = "isemenov/boards";

    public void open() {

    }

    public  void isOpened() {

    }

    public void openBoard(String urlName) {
        new Elem((By.cssSelector(".board-tile[href='" + urlName + "']")), urlName).click();
    }
}
