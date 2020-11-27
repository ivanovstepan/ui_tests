package com.ivanov.stepan.web.entities.pages;

import com.ivanov.stepan.utils.EnvConfig;
import org.openqa.selenium.By;

public class GoogleMainPage extends AbstractPage {

    private final String  url = EnvConfig.URL;
    private By  mainInput = By.xpath("//input[@name='q']");

    public GoogleMainPage navigate(){
        getDriverContainer().getDriver().get(url);
        return this;
    }

    public boolean isPageLoaded(){
        return !getDriverContainer().getDriver().getCurrentUrl().contains("/search");
    }

    public String getInputTitle(){
        return getDriverContainer().getDriver().findElement(mainInput).getAttribute("title");
    }

}
