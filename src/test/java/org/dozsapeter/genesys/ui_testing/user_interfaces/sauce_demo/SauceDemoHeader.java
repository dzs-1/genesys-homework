package org.dozsapeter.genesys.ui_testing.user_interfaces.sauce_demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.dozsapeter.genesys.ui_testing.step_definitions.CommonStepDefinitions.webDriver;
import static org.dozsapeter.genesys.ui_testing.step_definitions.CommonStepDefinitions.webDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class SauceDemoHeader {

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private static WebElement SHOPPING_CART_COUNTER;

    @FindBy(xpath = "//div[@class='shopping_cart_container']")
    public static WebElement SHOPPING_CART_ICON;

    public SauceDemoHeader() {
        PageFactory.initElements(webDriver, this);
    }

    public Integer getShoppingCartItemCounterValue() {
        return Integer.valueOf(SHOPPING_CART_COUNTER.getText());
    }

    public void clickOnCartIcon() {
        webDriverWait.until(elementToBeClickable(SHOPPING_CART_ICON));
        SHOPPING_CART_ICON.click();
    }
}
