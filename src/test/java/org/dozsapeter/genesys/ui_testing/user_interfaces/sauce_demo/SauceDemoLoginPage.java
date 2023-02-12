package org.dozsapeter.genesys.ui_testing.user_interfaces.sauce_demo;

import com.google.gson.Gson;
import org.dozsapeter.genesys.ui_testing.TestUser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static org.dozsapeter.genesys.helpers.FileResolver.getFileAsStringFromResources;
import static org.dozsapeter.genesys.constants.FileNames.CREDENTIALS_FILE;
import static org.dozsapeter.genesys.constants.Urls.SAUCE_DEMO_INVENTORY_URL;
import static org.dozsapeter.genesys.ui_testing.step_definitions.CommonStepDefinitions.webDriver;
import static org.dozsapeter.genesys.ui_testing.step_definitions.CommonStepDefinitions.webDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class SauceDemoLoginPage {

    private static Gson gson = new Gson();
    private static TestUser user;
    private static final String USERNAME = System.getProperty("username");
    private static final String PASSWORD = System.getProperty("password");

    static {
        try {
            user = gson.fromJson(getFileAsStringFromResources(CREDENTIALS_FILE), TestUser.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FindBy(xpath = "//input[contains(@id, 'user-name')]")
    private static WebElement SAUCE_DEMO_USERNAME_LOGIN_INPUT_FIELD;

    @FindBy(xpath = "//input[contains(@id, 'password')]")
    private static WebElement SAUCE_DEMO_PASSWORD_LOGIN_INPUT_FIELD;

    @FindBy(xpath = "//input[@id='login-button']")
    private static WebElement LOGIN_BUTTON;

    @FindBy(xpath = "//h3[@data-test='error']")
    private static WebElement ERROR_MESSAGE;

    public SauceDemoLoginPage() {
        PageFactory.initElements(webDriver, this);
    }

    public void enterUsername() {
        webDriverWait.until(elementToBeClickable(SAUCE_DEMO_USERNAME_LOGIN_INPUT_FIELD));
        SAUCE_DEMO_USERNAME_LOGIN_INPUT_FIELD.sendKeys(user.getUsername());
    }

    public void enterDefaultUsername() {
        webDriverWait.until(elementToBeClickable(SAUCE_DEMO_USERNAME_LOGIN_INPUT_FIELD));
        SAUCE_DEMO_USERNAME_LOGIN_INPUT_FIELD.sendKeys(USERNAME);
    }

    public void enterPassword() {
        webDriverWait.until(elementToBeClickable(SAUCE_DEMO_PASSWORD_LOGIN_INPUT_FIELD));
        SAUCE_DEMO_PASSWORD_LOGIN_INPUT_FIELD.sendKeys(user.getPassword());
    }

    public void enterDefaultPassword() {
        webDriverWait.until(elementToBeClickable(SAUCE_DEMO_PASSWORD_LOGIN_INPUT_FIELD));
        SAUCE_DEMO_PASSWORD_LOGIN_INPUT_FIELD.sendKeys(PASSWORD);
    }

    public void openPage() {
        webDriver.get(SAUCE_DEMO_INVENTORY_URL);
    }

    public void clickOnLogin() {
        webDriverWait.until(elementToBeClickable(LOGIN_BUTTON));
        LOGIN_BUTTON.click();
    }

    public String getErrorMessage() {
        return ERROR_MESSAGE.getText();
    }
}
