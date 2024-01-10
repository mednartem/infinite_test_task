package com.infinite.tests;

import com.infinite.main.config.ProjectConfig;
import com.infinite.main.jupiter.WebTest;
import com.infinite.main.pages.BasePage;
import com.infinite.main.pages.SearchPage;
import org.junit.jupiter.api.Test;

@WebTest
public class GoogleTest {

    private final BasePage basePage = new BasePage();
    private final SearchPage searchPage = new SearchPage();

    @Test
    void checkResultPage() {
        String searchText = "infinite com";
        String expectedLink = "https://www.infinite.com/";

        basePage
                .open(ProjectConfig.app.baseUrl());
        searchPage
                .enterValueToTheSearchBarAndPressEnter(searchText)
                .firstLinkShouldBe(expectedLink);
    }

    @Test
    void failedTest() {
        String searchText = "infinite com";

        basePage
                .open(ProjectConfig.app.baseUrl());
        searchPage
                .enterValueToTheSearchBarAndPressEnter(searchText)
                .firstLinkShouldBe(searchText);
    }
}
