package com.ivanov.stepan.web.entities.pages;

import com.ivanov.stepan.web.WebDriverContainer;

public class AbstractPage {

    static WebDriverContainer getDriverContainer() {
        return WebDriverContainer.getInstance();
    }

}
