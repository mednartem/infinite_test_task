package com.infinite.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class GoogleTest {

    @Test
    void checkResultPage() {
        String searchText = "infinite com";
        String expectedLink = "https://www.infinite.com/";

        Selenide.open("https://google.com");
        Selenide.$("[name=q]").setValue(searchText).submit();
        Selenide.$$("#rso a").first().shouldHave(Condition.attribute("href", expectedLink));
    }
}
