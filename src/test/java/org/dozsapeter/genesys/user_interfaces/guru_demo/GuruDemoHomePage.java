package org.dozsapeter.genesys.user_interfaces.guru_demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.dozsapeter.genesys.constants.Urls.GURU_99_DEMO_URL;
import static org.dozsapeter.genesys.step_defintions.CommonStepDefinitions.webDriver;
import static org.dozsapeter.genesys.step_defintions.CommonStepDefinitions.webDriverWait;

public class GuruDemoHomePage {

    @FindBy(xpath = "//iframe[@id='a077aa5e']")
    private static WebElement GURU_IFRAME;

    @FindBy(xpath = "//iframe[@id='gdpr-consent-notice']")
    private static WebElement GDPR_CONSENT_IFRAME;

    @FindBy(xpath = "//img[parent::a[contains(@href, 'selenium')]]")
    private static WebElement IMAGE_IN_IFRAME;

    @FindBy(xpath = "//button[@id='save']")
    private static WebElement ACCEPT_ALL_COOKIES_BUTTON;

    @FindBy(xpath = "//a[contains(text(), 'Testing')][ancestor::td]")
    private static WebElement TESTING_LINK_IN_HEADER;

    private static final String originalWindow = webDriver.getWindowHandle();

    public GuruDemoHomePage() {
        PageFactory.initElements(webDriver, this);
    }

    public void openPage() {
        webDriver.get(GURU_99_DEMO_URL);
    }

    public void clickOnIFrame() {
        webDriver.switchTo().frame(GURU_IFRAME);
        IMAGE_IN_IFRAME.click();
    }

    public void clickOnAcceptAllCookiesButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(GDPR_CONSENT_IFRAME));
        webDriver.switchTo().frame(GDPR_CONSENT_IFRAME);
        ACCEPT_ALL_COOKIES_BUTTON.click();
    }

    public String getTabTitle() {
        return webDriver.getTitle();
    }

    public void closeTab() {
        webDriver.close();
    }

    public void switchToNewTab() {
        for (String windowHandle : webDriver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                webDriver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void switchToOriginalTab() {
        webDriver.switchTo().window(originalWindow);
    }

    public void clickOnTestingLink() {
        TESTING_LINK_IN_HEADER.click();
    }
}
