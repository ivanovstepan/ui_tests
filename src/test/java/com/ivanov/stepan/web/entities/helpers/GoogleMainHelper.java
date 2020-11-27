package com.ivanov.stepan.web.entities.helpers;

import com.ivanov.stepan.web.entities.pages.GoogleMainPage;

public class GoogleMainHelper extends AbstractHelper {

    private final GoogleMainPage googleMainPage = new GoogleMainPage();

    public GoogleMainHelper navigate() {
        log.debug("Navigate to google main page");
        googleMainPage.navigate();
        return this;
    }

    public boolean isPageLoaded() {
        boolean isLoaded = googleMainPage.isPageLoaded();
        log.debug("Check if Google main page loaded - " + isLoaded);
        return isLoaded;
    }

    public String getInputTitle() {
        String title = googleMainPage.getInputTitle();
        log.debug("Get title of input - " + title);
        return title;
    }

}
