package com.infinite.main.pages;

import com.codeborne.selenide.SelenideElement;
import com.infinite.main.dictionary.Engine;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    @Step("I input `{text}` into the search bar and hit Enter using the `{engine}`")
    public SearchPage enterValueToSearchBarAndPressEnter(Engine engine, String text) {
        switch (engine) {
            case GOOGLE -> enterValueToSearchBarAndPressEnter($("[name=q]"), text);
            case YAHOO -> enterValueToSearchBarAndPressEnter($("[name=p]"), text);
            case YANDEX -> enterValueToSearchBarAndPressEnter($("[name=text]"), text);
            default -> throw new IllegalStateException("Unexpected value: " + engine);
        }
        return this;
    }

    private void enterValueToSearchBarAndPressEnter(SelenideElement element, String text) {
        element.setValue(text).pressEnter();
    }
}
