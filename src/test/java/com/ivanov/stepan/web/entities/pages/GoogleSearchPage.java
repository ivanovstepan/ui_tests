package com.ivanov.stepan.web.entities.pages;

import com.ivanov.stepan.utils.EnvConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class GoogleSearchPage extends AbstractPage {

    private final String url = EnvConfig.URL + "/search?q=";
    private By googleLogo = By.xpath("//a[@id='logo']");
    private By googleSearchLinks = By.xpath("//div[@id='search']//div[@class=\"rc\"]/div/a");
    private By googleSearchDescriptions = By.xpath("//div[@id='search']//div[@class=\"rc\"]/div[2]//span/span");


    public GoogleSearchPage navigate() {
        getDriverContainer().getDriver().get(url);
        return this;
    }

    public GoogleSearchPage navigate(String searchValue) {
        getDriverContainer().getDriver().get(url + searchValue);
        return this;
    }

    public GoogleSearchPage clickGoogleLogo() {
        getDriverContainer().getDriver().findElement(googleLogo).click();
        return this;
    }

    public List<String> getSearchLinks() {
        return getDriverContainer().getDriver().findElements(googleSearchLinks).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getSearchDescriptions() {
        return getDriverContainer().getDriver().findElements(googleSearchDescriptions).stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
