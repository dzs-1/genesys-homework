package org.dozsapeter.genesys.ui_testing.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import org.dozsapeter.genesys.ui_testing.webdriver.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonStepDefinitions {

    public static WebDriver webDriver;
    public static WebDriverWait webDriverWait;
    public static JavascriptExecutor javascriptExecutor;

    @Before
    public void setupBrowser() {
        webDriver = WebDriverFactory.getDriver();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @And("the user scrolls down to the bottom of the page")
    public void scrollsDownToTheBottomOfThePage() {
        javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("window.scrollBy(0, 0)");
    }

    @And("the user scrolls up to the top of the page")
    public void scrollsUpToTheTopOfThePage() {
        javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }
}