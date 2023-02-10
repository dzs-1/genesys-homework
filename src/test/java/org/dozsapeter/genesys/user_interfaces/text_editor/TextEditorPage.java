package org.dozsapeter.genesys.user_interfaces.text_editor;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.dozsapeter.genesys.constants.Urls.ONLINE_HTML_EDITOR_URL;
import static org.dozsapeter.genesys.step_defintions.SetupStepDefinitions.webDriver;
import static org.dozsapeter.genesys.step_defintions.SetupStepDefinitions.webDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class TextEditorPage {

    @FindBy(xpath = "//span[contains(@class, 'cke_button__bold_icon')]")
    private static WebElement BOLD_STYLE_BUTTON;

    @FindBy(xpath = "//span[contains(@class, 'cke_button__underline_icon')]")
    private static WebElement UNDERLINE_STYLE_BUTTON;

    @FindBy(xpath = "//iframe[contains(@title, 'Rich Text Editor')]")
    private static WebElement EDITOR_SECTION;

    private static final String PARAGRAPH_SECTION_XPATH = "//p[ancestor::html[@dir='ltr']]";

    public TextEditorPage() {
        PageFactory.initElements(webDriver, this);
    }

    public void openTextEditor() {
        webDriver.get(ONLINE_HTML_EDITOR_URL);
        webDriverWait.until(visibilityOfAllElements(EDITOR_SECTION, BOLD_STYLE_BUTTON, UNDERLINE_STYLE_BUTTON));
    }

    public void clickOnBoldButton() {
        webDriverWait.until(elementToBeClickable(BOLD_STYLE_BUTTON));
        BOLD_STYLE_BUTTON.click();
    }

    public void clickOnUnderlineButton() {
        UNDERLINE_STYLE_BUTTON.click();
    }

    public void writeIntoEditor(final CharSequence... charSequences) {
        EDITOR_SECTION.sendKeys(charSequences);
    }

    public String getTextFromEditor() {
        webDriver.switchTo().frame(0);
        return webDriver.findElement(By.xpath(PARAGRAPH_SECTION_XPATH))
                        .getAttribute("textContent")
                        .replace("\u00a0"," ")
                        .replace("\u200B", "");
    }

    public void hitSpace() {
        EDITOR_SECTION.sendKeys(Keys.SPACE);
    }
}
