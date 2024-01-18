package com.infinite.tests;

import com.infinite.main.dictionary.Engine;
import com.infinite.main.jupiter.SearchEngine;
import com.infinite.main.jupiter.WebTest;
import com.infinite.main.pages.BasePage;
import com.infinite.main.pages.ResultPage;
import com.infinite.main.pages.SearchPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

@WebTest
public class SearchEngineTest {

    private final BasePage basePage = new BasePage();
    private final SearchPage searchPage = new SearchPage();
    private final ResultPage resultPage = new ResultPage();


    private static List<Arguments> dataForSearchEngine() {
        List<Arguments> argumentsList = new ArrayList<>();

        String textInfiniteCom = "+infinite com";
        String linkInfiniteCom = "https://www.infinite.com/";
        String textSelenide = "+selenide";
        String linkSelenide = "https://selenide.org/";
        String textJunitFour = "+junit 4";
        String linkJunitFour = "https://junit.org/junit4/";

        for (Engine engine : Engine.values()) {
            argumentsList.add(Arguments.of(engine, textInfiniteCom, linkInfiniteCom));
            argumentsList.add(Arguments.of(engine, textSelenide, linkSelenide));
            argumentsList.add(Arguments.of(engine, textJunitFour, linkJunitFour));
        }

        return argumentsList;
    }

    @ParameterizedTest(name = "Search engine: {0}, Input: {1}, Expected Link: {2}")
    @MethodSource("dataForSearchEngine")
    void checkResultPage(Engine engine, String input, String expectedLink) {
        basePage
                .open(engine.getUrl());
        searchPage
                .enterValueToSearchBarAndPressEnter(engine, input);
        resultPage
                .atLeastOneLinkOnThePageShouldBe(engine, expectedLink);
    }

    @Test
    @SearchEngine(engine = Engine.YAHOO)
    @DisplayName("This test should be failed")
    void failedTest(Engine engine) {
        String searchText = "infinite com";

        basePage
                .open(engine.getUrl());
        searchPage
                .enterValueToSearchBarAndPressEnter(engine, searchText);
        resultPage
                .atLeastOneLinkOnThePageShouldBe(engine, searchText);
    }
}
