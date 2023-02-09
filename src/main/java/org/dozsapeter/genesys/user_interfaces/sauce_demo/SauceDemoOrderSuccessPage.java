package org.dozsapeter.genesys.user_interfaces.sauce_demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.dozsapeter.genesys.step_defintions.SetupStepDefinitions.webDriver;

public class SauceDemoOrderSuccessPage {

    @FindBy(xpath = "//h2[@class='complete-header']")
    public static WebElement ORDER_SUCCESS_MESSAGE;

    public SauceDemoOrderSuccessPage() {
        PageFactory.initElements(webDriver, this);
    }

    public String getSuccessMessage() {
        return ORDER_SUCCESS_MESSAGE.getText();
    }
}
