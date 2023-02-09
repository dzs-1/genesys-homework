package org.dozsapeter.genesys.user_interfaces.sauce_demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.dozsapeter.genesys.step_defintions.SetupStepDefinitions.webDriver;

public class SauceDemoCartPage {

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement CHECKOUT_BUTTON;

    public SauceDemoCartPage() {
        PageFactory.initElements(webDriver, this);
    }

    public void clickOnCheckoutButton() {
        CHECKOUT_BUTTON.click();
    }
}
