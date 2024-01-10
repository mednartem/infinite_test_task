package com.infinite.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.infinite.main.config.ProjectConfig;
import com.infinite.main.jupiter.WebTest;
import org.junit.jupiter.api.Test;

@WebTest
public class GoogleTest {

    @Test
    void checkResultPage() {
        String searchText = "infinite com";
        String expectedLink = "https://www.infinite.com/";

        Selenide.open(ProjectConfig.app.baseUrl());
        Selenide.$("[name=q]").setValue(searchText).submit();
        Selenide.$$("#rso a").first().shouldHave(Condition.attribute("href", expectedLink));
    }
}
