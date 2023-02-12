package org.dozsapeter.genesys.ui_testing.user_interfaces.text_editor;

import org.dozsapeter.genesys.constants.Urls;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.dozsapeter.genesys.ui_testing.step_definitions.CommonStepDefinitions.webDriver;
import static org.dozsapeter.genesys.ui_testing.step_definitions.CommonStepDefinitions.webDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class TextEditorPage {

    @FindBy(xpath = "//iframe[@tabindex='0']")
    private static WebElement EDITOR_SECTION;

    @FindBy(xpath = "//p[ancestor::html[@dir='ltr']]")
    private static WebElement PARAGRAPH_SECTION;

    public TextEditorPage() {
        PageFactory.initElements(webDriver, this);
    }

    public void openTextEditor() {
        webDriver.get(Urls.ONLINE_HTML_EDITOR_URL);
        webDriverWait.until(visibilityOfAllElements(EDITOR_SECTION));
        EDITOR_SECTION.click();
    }

    public void clickOnBoldButton() {
        String boldShortcut = Keys.chord(Keys.COMMAND, "b");
        EDITOR_SECTION.sendKeys(boldShortcut);
    }

    public void clickOnUnderlineButton() {
        String underLine = Keys.chord(Keys.COMMAND, "u");
        EDITOR_SECTION.sendKeys(underLine);
    }

    public void writeIntoEditor(final CharSequence... charSequences) {
        EDITOR_SECTION.sendKeys(charSequences);
    }

    public String getTextFromEditor() {
        webDriver.switchTo().frame(0);
        return PARAGRAPH_SECTION.getAttribute("textContent")
                                .replace("\u00a0"," ")
                                .replace("\u200B", "");
    }

    public void hitSpace() {
        EDITOR_SECTION.sendKeys(Keys.SPACE);
    }
}
