package com.infinite.main.jupiter;

import com.codeborne.selenide.WebDriverRunner;
import com.infinite.main.driver.DesktopDriver;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BrowserExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        DesktopDriver.configure();
    }

    @Override
    public void afterEach(ExtensionContext context) {
        if (WebDriverRunner.hasWebDriverStarted()) {
            closeWebDriver();
        }
    }
}
