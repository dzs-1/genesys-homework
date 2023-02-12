package org.dozsapeter.genesys.ui_testing.step_defintions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.dozsapeter.genesys.ui_testing.user_interfaces.text_editor.TextEditorPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextEditorStepDefinitions {

    TextEditorPage textEditorPage = new TextEditorPage();

    @Given("the user opens the text editor")
    public void opensTheTextEditor() {
        textEditorPage.openTextEditor();
    }

    @When("the user clicks on bold style button in the editor")
    public void clicksOnBoldStyleButtonInTheEditor() {
        textEditorPage.clickOnBoldButton();
    }

    @And("the user clicks on underline style in the editor")
    public void clicksOnUnderlineStyleInTheEditor() {
        textEditorPage.clickOnUnderlineButton();
    }

    @And("the user types {string} in the editor")
    public void typesInTheEditor(final String text) {
        textEditorPage.writeIntoEditor(text);
    }

    @Then("the user validates that the typed text is {string}")
    public void validatesThatTheTypedTextIs(final String text) {
        assertEquals(text, textEditorPage.getTextFromEditor());
    }

    @And("the user hits space")
    public void hitsSpace() {
        textEditorPage.hitSpace();
    }
}
