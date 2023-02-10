package org.dozsapeter.genesys.step_defintions;

import org.dozsapeter.genesys.webdriver.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SetupStepDefinitions {

    public static WebDriver webDriver;
    public static WebDriverWait webDriverWait;

    @Before
    public void setupBrowser() {
        webDriver = WebDriverFactory.getDriver();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}