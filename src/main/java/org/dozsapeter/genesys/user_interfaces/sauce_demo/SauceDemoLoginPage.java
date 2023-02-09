package org.dozsapeter.genesys.user_interfaces.sauce_demo;

import com.google.gson.Gson;
import org.dozsapeter.genesys.TestUser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static org.dozsapeter.genesys.FileResolver.getFileAsStringFromResources;
import static org.dozsapeter.genesys.constants.FileNames.CREDENTIALS_FILE;
import static org.dozsapeter.genesys.constants.Urls.SAUCE_DEMO_INVENTORY_URL;
import static org.dozsapeter.genesys.step_defintions.SetupStepDefinitions.webDriver;
import static org.dozsapeter.genesys.step_defintions.SetupStepDefinitions.webDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class SauceDemoLoginPage {

    Gson gson = new Gson();
    TestUser user = gson.fromJson(getFileAsStringFromResources(CREDENTIALS_FILE), TestUser.class);

    @FindBy(xpath = "//input[contains(@id, 'user-name')]")
    public static WebElement SAUCE_DEMO_USERNAME_LOGIN_INPUT_FIELD;

    @FindBy(xpath = "//input[contains(@id, 'password')]")
    public static WebElement SAUCE_DEMO_PASSWORD_LOGIN_INPUT_FIELD;

    @FindBy(xpath = "//input[@id='login-button']")
    public static WebElement LOGIN_BUTTON;

    public SauceDemoLoginPage() throws IOException {
        PageFactory.initElements(webDriver, this);
    }

    public void enterUsername() {
        webDriverWait.until(elementToBeClickable(SAUCE_DEMO_USERNAME_LOGIN_INPUT_FIELD));
        SAUCE_DEMO_USERNAME_LOGIN_INPUT_FIELD.sendKeys(user.getUsername());
    }

    public void enterPassword() {
        webDriverWait.until(elementToBeClickable(SAUCE_DEMO_PASSWORD_LOGIN_INPUT_FIELD));
        SAUCE_DEMO_PASSWORD_LOGIN_INPUT_FIELD.sendKeys(user.getPassword());
    }

    public void openPage() {
        webDriver.get(SAUCE_DEMO_INVENTORY_URL);
    }

    public void clickOnLogin() {
        LOGIN_BUTTON.click();
    }
}
