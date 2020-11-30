package com.ivanov.stepan.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManageUtils {

    private static final int MAX_TRY = 3;
    static Logger log = Logger.getRootLogger();

    public static WebDriver launchBrowser(String browserName) {
        for (int i = 0; i < MAX_TRY; i++) {
            try {
                return startBrowser(browserName);
            } catch (UnsupportedOperationException e) {
                log.debug(e.getMessage(), e);
            }
        }
        throw new RuntimeException("Can't run browser " + browserName);
    }

    private static WebDriver startBrowser(String browserName) {
        if (browserName.equals("chrome")) {
            return runChrome();
        } else
            throw new UnsupportedOperationException("No such browser: " + browserName);
    }

    static WebDriver runChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("window-size=1920x1080");
        options.addArguments("disable-translate");
        return new ChromeDriver(options);
    }

    static void closeBrowser(WebDriver driver) {
        driver.quit();
    }

}
