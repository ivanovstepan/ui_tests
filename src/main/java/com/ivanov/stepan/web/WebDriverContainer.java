package com.ivanov.stepan.web;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WebDriverContainer {

    private final static ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal();
    static Logger log = Logger.getRootLogger();

    public static WebDriverContainer getInstance() {
        return instance;
    }

    static WebDriverContainer instance = new WebDriverContainer();

    /**
     * Static instance of WebDriverContainer to access non-static scope;
     * No sense to handle multiple WebDriverContainer instances;
     * Only this one should be used
     */
    public WebDriver getDriver() {
        return WEB_DRIVER_THREAD_LOCAL.get();
    }

    public static WebDriverContainer launch(String browserName) {
        WEB_DRIVER_THREAD_LOCAL.set(WebDriverManageUtils.launchBrowser(browserName));
        WEB_DRIVER_THREAD_LOCAL.get().manage().window().maximize();
        return instance;
    }

    public static WebDriverContainer down() {
        log.debug("Down Chrome");
        try {
            WebDriverManageUtils.closeBrowser(WEB_DRIVER_THREAD_LOCAL.get());
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
        }
        return instance;
    }

}
