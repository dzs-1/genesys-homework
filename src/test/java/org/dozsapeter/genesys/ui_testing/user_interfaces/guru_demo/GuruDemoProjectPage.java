package org.dozsapeter.genesys.ui_testing.user_interfaces.guru_demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.dozsapeter.genesys.ui_testing.step_defintions.CommonStepDefinitions.webDriver;
import static org.dozsapeter.genesys.ui_testing.step_defintions.CommonStepDefinitions.webDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class GuruDemoProjectPage {

    @FindBy(xpath = "//input[@class='submit']")
    private static WebElement RED_BUTTON;

    @FindBy(xpath = "//button[contains(@class, 'fc-cta-consent')]")
    private static WebElement COOKIE_CONSENT_BUTTON;

    public GuruDemoProjectPage() {
        PageFactory.initElements(webDriver, this);
    }

    public boolean isRedButtonVisible() {
        webDriverWait.until(visibilityOf(RED_BUTTON));
        return RED_BUTTON.isDisplayed();
    }

    public void clickOnAcceptCookieConsent() {
        webDriverWait.until(visibilityOf(COOKIE_CONSENT_BUTTON));
        COOKIE_CONSENT_BUTTON.click();
    }
}
