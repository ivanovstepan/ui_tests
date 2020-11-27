package com.ivanov.stepan.web.tests;

import com.ivanov.stepan.utils.EnvConfig;
import com.ivanov.stepan.web.WebDriverContainer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseWebTest {

    @BeforeClass
    public void run() {
        WebDriverContainer.launch(EnvConfig.BROWER);
    }

    @AfterClass(alwaysRun = true)
    public void down() {
        WebDriverContainer.down();
    }

}
