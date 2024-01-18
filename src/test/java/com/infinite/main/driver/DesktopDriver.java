package com.infinite.main.driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.infinite.main.config.ProjectConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesktopDriver {

    public static void configure() {
        Configuration.browser = ProjectConfig.browser.name();
        Configuration.browserSize = ProjectConfig.browser.browserSize();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browserCapabilities = getChromeCapabilities();
    }

    private static DesiredCapabilities getChromeCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");

        return capabilities;
    }
}
