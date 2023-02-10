package org.dozsapeter.genesys.user_interfaces.sauce_demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.dozsapeter.genesys.step_defintions.SetupStepDefinitions.webDriver;

public class SauceDemoCheckoutOverviewPage {

    @FindBy(xpath = "//button[@id='finish']")
    private static WebElement FINISH_BUTTON;

    public SauceDemoCheckoutOverviewPage() {
        PageFactory.initElements(webDriver, this);
    }

    public void clickOnFinishButton() {
        FINISH_BUTTON.click();
    }
}
