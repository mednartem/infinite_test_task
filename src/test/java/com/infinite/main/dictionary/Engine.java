package com.infinite.main.dictionary;

public enum Engine {
    GOOGLE("https://www.google.com/"),
    YAHOO("https://search.yahoo.com/"),
    YANDEX("https://yandex.com/");

    private final String url;

    Engine(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
