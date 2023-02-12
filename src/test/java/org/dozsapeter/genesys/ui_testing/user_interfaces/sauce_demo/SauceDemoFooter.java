package org.dozsapeter.genesys.ui_testing.user_interfaces.sauce_demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.dozsapeter.genesys.ui_testing.step_definitions.CommonStepDefinitions.webDriver;

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
