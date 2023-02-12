package org.dozsapeter.genesys.ui_testing.step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.dozsapeter.genesys.ui_testing.user_interfaces.sauce_demo.*;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SauceDemoStepDefinitions {

    private static SauceDemoLoginPage sauceDemoLoginPage;
    private static SauceDemoHeader sauceDemoHeader;
    private static SauceDemoFooter sauceDemoFooter;

    @Given("the user opens the Sauce Demo page")
    public void opensTheSauceDemoPage() {
        sauceDemoLoginPage = new SauceDemoLoginPage();
        sauceDemoLoginPage.openPage();
    }

    @When("the user logs in to the Sauce Demo page")
    public void logsInToTheSauceDemoPage() {
        sauceDemoLoginPage = new SauceDemoLoginPage();
        sauceDemoLoginPage.enterUsername();
        sauceDemoLoginPage.enterPassword();
        sauceDemoLoginPage.clickOnLogin();
    }


    @And("the user adds the following items to the cart:")
    public void addsTheFollowingItemsToTheCart(final DataTable dataTable) {
        SauceDemoHomePage sauceDemoHomePage = new SauceDemoHomePage();
        List<String> rows = dataTable.asList();
        for (String row : rows) {
            sauceDemoHomePage.clickOnInventoryItem(row);
        }
    }

    @And("the user validates that there are {int} items in the cart")
    public void validatesThatThereAreItemsInTheCart(final int numberOfItems) {
        sauceDemoHeader = new SauceDemoHeader();
        assertEquals(numberOfItems, sauceDemoHeader.getShoppingCartItemCounterValue());
    }

    @And("the user goes through the checkout process with the following data:")
    public void goesThroughTheCheckoutProcessWithTheFollowingData(final DataTable dataTable) {
        sauceDemoHeader = new SauceDemoHeader();
        SauceDemoCartPage sauceDemoCartPage = new SauceDemoCartPage();
        SauceDemoCheckoutInformationPage sauceDemoCheckoutInformationPage = new SauceDemoCheckoutInformationPage();
        SauceDemoCheckoutOverviewPage sauceDemoCheckoutOverviewPage = new SauceDemoCheckoutOverviewPage();
        sauceDemoHeader.clickOnCartIcon();
        sauceDemoCartPage.clickOnCheckoutButton();
        Map<String, String> map = dataTable.transpose().asMap();
        sauceDemoCheckoutInformationPage.enterValueIntoFirstNameField(map.get("First name"));
        sauceDemoCheckoutInformationPage.enterValueIntoLastNameField(map.get("Last name"));
        sauceDemoCheckoutInformationPage.enterValueIntoPostalCodeField(map.get("Postal code"));
        sauceDemoCheckoutInformationPage.clickOnContinueButton();
        sauceDemoCheckoutOverviewPage.clickOnFinishButton();
    }

    @Then("the user verifies that the {string} message is present")
    public void verifiesThatTheMessageIsPresent(final String message) {
        SauceDemoOrderSuccessPage sauceDemoOrderSuccessPage = new SauceDemoOrderSuccessPage();
        assertEquals(message.toUpperCase(), sauceDemoOrderSuccessPage.getSuccessMessage());
    }

    @When("the user clicks on the login button")
    public void clicksOnTheLoginButton() {
        sauceDemoLoginPage = new SauceDemoLoginPage();
        sauceDemoLoginPage.clickOnLogin();
    }

    @Then("the user validates the error message is {string}")
    public void validatesTheErrorMessageIs(final String errorMessage) {
        sauceDemoLoginPage = new SauceDemoLoginPage();
        assertEquals(errorMessage, sauceDemoLoginPage.getErrorMessage());
    }

    @When("the user logs in with default username and password")
    public void logsInWithDefaultUsernameAndPassword() {
        sauceDemoLoginPage = new SauceDemoLoginPage();
        sauceDemoLoginPage.enterDefaultUsername();
        sauceDemoLoginPage.enterDefaultPassword();
        sauceDemoLoginPage.clickOnLogin();
    }

    @Then("the user verifies that the footer message contains {string} and {string}")
    public void verifiesThatTheFooterMessageContainsAnd(final String year, String termsOfServiceText) {
        sauceDemoFooter = new SauceDemoFooter();
        assertTrue(sauceDemoFooter.getFooterSectionText().contains(termsOfServiceText));
        assertTrue(sauceDemoFooter.getFooterSectionText().contains(year));
    }
}