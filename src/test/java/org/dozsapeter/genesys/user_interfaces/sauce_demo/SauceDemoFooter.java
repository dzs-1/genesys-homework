package org.dozsapeter.genesys.user_interfaces.sauce_demo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.dozsapeter.genesys.step_defintions.CommonStepDefinitions.webDriver;

public class SauceDemoFooter {

    @FindBy(xpath = "//div[@class='footer_copy']")
    private static WebElement FOOTER_SECTION;

    public SauceDemoFooter() {
        PageFactory.initElements(webDriver, this);
    }

    public String getFooterSectionText() {
        return FOOTER_SECTION.getAttribute("innerHTML");
    }

}
