package com.infinite.main.pages;

import com.codeborne.selenide.Selenide;

public class BasePage {

    public void open(String url) {
        Selenide.open(url);
    }
}
