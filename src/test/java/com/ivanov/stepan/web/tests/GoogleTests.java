package com.ivanov.stepan.web.tests;

import com.ivanov.stepan.utils.RandomUtils;
import com.ivanov.stepan.web.entities.helpers.GoogleMainHelper;
import com.ivanov.stepan.web.entities.helpers.GoogleSearchHelper;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GoogleTests extends BaseWebTest {

    private final GoogleMainHelper googleMainHelper = new GoogleMainHelper();
    private final GoogleSearchHelper googleSearchHelper = new GoogleSearchHelper();
    protected static final String SEARCH_VALUE = RandomUtils.getRandomFullName();

    @Test
    public void logoButtonReturnsToMainPageTest() {
        googleSearchHelper.navigate(RandomUtils.getString())
                .clickGoogleLogo();
        assertThat("Google logo doesn't redirect to main page",
                googleMainHelper.isPageLoaded(), equalTo(true));
    }

    @Test
    public void inputToolTipIsPresentTest() {
        String inputTitle = googleMainHelper.navigate()
                .getInputTitle();
        assertThat("Tooltip for search input is incorrect", inputTitle, equalTo("Поиск"));
    }

    @Test
    public void correctSearchValueInLinkTest() {
        googleSearchHelper.navigate(SEARCH_VALUE);
        assertThat("Search value is not present in google links",
                googleSearchHelper.isSearchValuePresentInLinks(SEARCH_VALUE), equalTo(true));
    }

    @Test
    public void correctSearchValueInAdditionalTextTest() {
        googleSearchHelper.navigate(SEARCH_VALUE);
        assertThat("Search value is not present in google search descriptions",
                googleSearchHelper.isSearchValuePresentInDescriptions(SEARCH_VALUE), equalTo(true));
    }

}
