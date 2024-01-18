package com.infinite.main.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.infinite.main.dictionary.Engine;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class ResultPage {
    @Step("Verify that at least one link on the page matches the expected link '{expectedLink}' in the '{engine}' search")
    public ResultPage atLeastOneLinkOnThePageShouldBe(Engine engine, String expectedLink) {
        switch (engine) {
            case GOOGLE -> atLeastOneLinkOnThePageShouldBe($$("#search a"), expectedLink);
            case YAHOO -> atLeastOneLinkOnThePageShouldBe($$("#web a"), expectedLink);
            case YANDEX -> atLeastOneLinkOnThePageShouldBe($$("#search-result a"), expectedLink);
            default -> throw new IllegalStateException("Unexpected value: " + engine);
        }
        return this;
    }

    private void atLeastOneLinkOnThePageShouldBe(ElementsCollection elements, String expectedLink) {
        elements.shouldHave(CollectionCondition.anyMatch(
                "At least one link on the page should be: " + expectedLink,
                el -> el.getAttribute("href").equals(expectedLink)
        ));
    }
}
