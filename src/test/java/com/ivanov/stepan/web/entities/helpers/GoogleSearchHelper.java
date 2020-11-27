package com.ivanov.stepan.web.entities.helpers;

import com.ivanov.stepan.web.entities.pages.GoogleSearchPage;

import java.util.List;

public class GoogleSearchHelper extends AbstractHelper {

    private final GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    public GoogleSearchHelper navigate() {
        log.debug("Navigate to google search page");
        googleSearchPage.navigate();
        return this;
    }

    public GoogleSearchHelper navigate(String searchValue) {
        log.debug("Navigate to google search page with searchValue - " + searchValue);
        googleSearchPage.navigate(searchValue);
        return this;
    }

    public GoogleSearchHelper clickGoogleLogo() {
        log.debug("Click on Google logo");
        googleSearchPage.clickGoogleLogo();
        return this;
    }

    public boolean isSearchValuePresentInLinks(String searchValue) {
        List<String> searchLinkList = googleSearchPage.getSearchLinks();
        log.debug("Get search links descriptions  - " + searchLinkList.toString());
        boolean result = searchLinkList.stream().anyMatch(link -> link.contains(searchValue));
        log.debug("Check if SearchValue: " + searchValue + "present in list of links - " + result);
        return result;
    }

    public boolean isSearchValuePresentInDescriptions(String searchValue) {
        List<String> searchDescriptionsList = googleSearchPage.getSearchDescriptions();
        log.debug("Get search links descriptions  - " + searchDescriptionsList.toString());
        boolean result = searchDescriptionsList.stream().anyMatch(descriction -> descriction.contains(searchValue));
        log.debug("Check if SearchValue: \"" + searchValue + "\" present in list of descriptions - " + result);
        return result;
    }

}
