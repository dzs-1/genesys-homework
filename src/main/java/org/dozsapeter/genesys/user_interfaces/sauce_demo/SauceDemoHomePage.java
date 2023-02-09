package org.dozsapeter.genesys.user_interfaces.sauce_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.String.format;
import static org.dozsapeter.genesys.step_defintions.SetupStepDefinitions.webDriver;
import static org.dozsapeter.genesys.step_defintions.SetupStepDefinitions.webDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class SauceDemoHomePage {

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private static WebElement SHOPPING_CART_COUNTER;

    @FindBy(xpath = "//div[@class='shopping_cart_container']")
    public static WebElement SHOPPING_CART_ICON;

    private static String INVENTORY_ITEM_XPATH = "//button[contains(@class, 'btn_inventory')]" +
            "[ancestor::div[contains(@class, 'inventory_item_description')]" +
            "[descendant::div[contains(text(), '%s')]]]";

    public SauceDemoHomePage() {
        PageFactory.initElements(webDriver, this);
    }

    public void clickOnInventoryItem(String itemName) {
        webDriver.findElement(By.xpath(format(INVENTORY_ITEM_XPATH, itemName))).click();
    }

    public Integer getShoppingCartItemCounterValue() {
        return Integer.valueOf(SHOPPING_CART_COUNTER.getText());
    }

    public void clickOnCartIcon() {
        webDriverWait.until(elementToBeClickable(SHOPPING_CART_ICON));
        SHOPPING_CART_ICON.click();
    }
}
