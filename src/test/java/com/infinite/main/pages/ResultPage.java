package com.infinite.main.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultPage {
    private final ElementsCollection listResults = $$("#search a");

    @Step("I check first link should be `{expectedLink}`")
    public void firstLinkShouldBe(String expectedLink) {
        listResults.first().shouldHave(href(expectedLink));
    }
}
