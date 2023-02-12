package org.dozsapeter.genesys.ui_testing.user_interfaces.sauce_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static java.lang.String.format;
import static org.dozsapeter.genesys.ui_testing.step_definitions.CommonStepDefinitions.webDriver;

public class SauceDemoHomePage {

    private static String INVENTORY_ITEM_XPATH = "//button[contains(@class, 'btn_inventory')]" +
            "[ancestor::div[contains(@class, 'inventory_item_description')]" +
            "[descendant::div[contains(text(), '%s')]]]";

    public SauceDemoHomePage() {
        PageFactory.initElements(webDriver, this);
    }

    public void clickOnInventoryItem(String itemName) {
        webDriver.findElement(By.xpath(format(INVENTORY_ITEM_XPATH, itemName))).click();
    }
}
