package org.dozsapeter.genesys.ui_testing.user_interfaces.sauce_demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.dozsapeter.genesys.ui_testing.step_defintions.CommonStepDefinitions.webDriver;

public class SauceDemoCheckoutInformationPage {

    @FindBy(xpath = "//input[@id='continue']")
    private static WebElement CONTINUE_BUTTON;

    @FindBy(xpath = "//input[@id='first-name']")
    private static WebElement FIRST_NAME_INPUT_FIELD;

    @FindBy(xpath = "//input[@id='last-name']")
    private static WebElement LAST_NAME_INPUT_FIELD;

    @FindBy(xpath = "//input[@id='postal-code']")
    private static WebElement POSTAL_CODE_INPUT_FIELD;

    public SauceDemoCheckoutInformationPage() {
        PageFactory.initElements(webDriver, this);
    }

    public void clickOnContinueButton() {
        CONTINUE_BUTTON.click();
    }

    public void enterValueIntoFirstNameField(final String firstName) {
        FIRST_NAME_INPUT_FIELD.sendKeys(firstName);
    }

    public void enterValueIntoLastNameField(final String lastName) {
        LAST_NAME_INPUT_FIELD.sendKeys(lastName);
    }

    public void enterValueIntoPostalCodeField(final String postalCode) {
        POSTAL_CODE_INPUT_FIELD.sendKeys(postalCode);
    }
}
