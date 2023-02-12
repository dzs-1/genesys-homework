package org.dozsapeter.genesys.ui_testing.user_interfaces.guru_demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static org.dozsapeter.genesys.constants.Urls.GURU_99_DEMO_URL;
import static org.dozsapeter.genesys.ui_testing.step_definitions.CommonStepDefinitions.webDriver;
import static org.dozsapeter.genesys.ui_testing.step_definitions.CommonStepDefinitions.webDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

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

    @FindBy(xpath = "//div[@id='dismiss-button']")
    private static WebElement DISMISS_BUTTON;

    @FindBy(xpath = "//iframe[@id='google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0']")
    private static WebElement PARENT_IFRAME;

    @FindBy(xpath = "//iframe[@id='ad_iframe']")
    private static WebElement AD_IFRAME;

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
        //webDriverWait.until(visibilityOf(GDPR_CONSENT_IFRAME));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
        synchronized (webDriver) {
            try {
                webDriver.wait(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        webDriver.switchTo().frame(PARENT_IFRAME);
        webDriver.switchTo().frame(AD_IFRAME);

        //
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //

        webDriver.switchTo().activeElement();

    }
}
