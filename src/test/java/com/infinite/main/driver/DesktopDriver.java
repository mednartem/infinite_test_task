package com.infinite.main.driver;

import com.codeborne.selenide.Configuration;
import com.infinite.main.config.ProjectConfig;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesktopDriver {

    public static void configure() {
        Configuration.baseUrl = ProjectConfig.app.baseUrl();
        Configuration.browser = ProjectConfig.browser.name();
        Configuration.browserSize = ProjectConfig.browser.browserSize();
        Configuration.baseUrl = ProjectConfig.app.baseUrl();
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
