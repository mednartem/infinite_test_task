package com.infinite.main.pages;

import com.codeborne.selenide.Selenide;
import com.infinite.main.config.ProjectConfig;

public class BasePage {

    public void open(String url) {
        Selenide.open(url);
    }
}
