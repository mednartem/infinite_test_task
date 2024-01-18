package com.infinite.main.jupiter.extension;

import com.codeborne.selenide.WebDriverRunner;
import com.infinite.main.attachments.AttachmentHelpers;
import com.infinite.main.driver.DesktopDriver;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BrowserExtension implements BeforeEachCallback, AfterEachCallback, TestExecutionExceptionHandler {

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

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        if (WebDriverRunner.hasWebDriverStarted()) {
            AttachmentHelpers.attachAsText("Current url", WebDriverRunner.getWebDriver().getCurrentUrl());
            AttachmentHelpers.attachAsText("Browser console logs", AttachmentHelpers.getConsoleLogs());
        }
        throw throwable;
    }
}
