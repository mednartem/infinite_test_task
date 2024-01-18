package com.infinite.main.config;

import org.aeonbits.owner.ConfigFactory;

public class ProjectConfig {
    public static BrowserConfig browser = ConfigFactory.create(BrowserConfig.class, System.getProperties());
}
