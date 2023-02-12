package org.dozsapeter.genesys.ui_testing.user_interfaces.sauce_demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.dozsapeter.genesys.ui_testing.step_defintions.CommonStepDefinitions.webDriver;

public class SauceDemoCartPage {

    @FindBy(xpath = "//button[@id='checkout']")
    private static WebElement CHECKOUT_BUTTON;

    public SauceDemoCartPage() {
        PageFactory.initElements(webDriver, this);
    }

    public void clickOnCheckoutButton() {
        CHECKOUT_BUTTON.click();
    }
}
