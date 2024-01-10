package com.infinite.main.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    private final SelenideElement searchInput = $("[name=q]");

    @Step("I enter value `{text}` to the search bar and press Enter")
    public ResultPage enterValueToTheSearchBarAndPressEnter(String text) {
        searchInput.setValue(text).pressEnter();
        return new ResultPage();
    }
}
