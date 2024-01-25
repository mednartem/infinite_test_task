package com.infinite.main.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public class BasePage {

    @Step("Open url `{url}`")
    public void open(String url) {
        Selenide.open(url);
    }
}
