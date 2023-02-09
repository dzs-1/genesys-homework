package org.dozsapeter.genesys.step_defintions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.dozsapeter.genesys.user_interfaces.sauce_demo.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SauceDemoStepDefinitions {

    SauceDemoLoginPage sauceDemoLoginPage;
    SauceDemoHomePage sauceDemoHomePage;
    SauceDemoCartPage sauceDemoCartPage;
    SauceDemoCheckoutInformationPage sauceDemoCheckoutInformationPage;
    SauceDemoCheckoutOverviewPage sauceDemoCheckoutOverviewPage;
    SauceDemoOrderSuccessPage sauceDemoOrderSuccessPage;

    @Given("the user opens the Sauce Demo page")
    public void opensTheSaucedemoPage() throws IOException {
        sauceDemoLoginPage = new SauceDemoLoginPage();
        sauceDemoHomePage = new SauceDemoHomePage();
        sauceDemoCartPage = new SauceDemoCartPage();
        sauceDemoCheckoutInformationPage = new SauceDemoCheckoutInformationPage();
        sauceDemoCheckoutOverviewPage = new SauceDemoCheckoutOverviewPage();
        sauceDemoOrderSuccessPage = new SauceDemoOrderSuccessPage();
        sauceDemoLoginPage.openPage();
    }

    @When("the user logs in to the Sauce Demo page")
    public void logsInToTheSauceDemoPage() {
        sauceDemoLoginPage.enterUsername();
        sauceDemoLoginPage.enterPassword();
        sauceDemoLoginPage.clickOnLogin();
    }


    @And("the user adds the following items to the cart:")
    public void addsTheFollowingItemsToTheCart(final DataTable dataTable) {
        List<String> rows = dataTable.asList();
        for (String row : rows) {
            sauceDemoHomePage.clickOnInventoryItem(row);
        }
    }

    @And("the user validates that there are {int} items in the cart")
    public void validatesThatThereAreItemsInTheCart(final int numberOfItems) {
        assertEquals(numberOfItems, sauceDemoHomePage.getShoppingCartItemCounterValue());
    }

    @And("the user goes through the checkout process with the following data:")
    public void goesThroughTheCheckoutProcessWithTheFollowingData(final DataTable dataTable) {
        Map<String, String> map = dataTable.transpose().asMap();
        sauceDemoHomePage.clickOnCartIcon();
        sauceDemoCartPage.clickOnCheckoutButton();
        sauceDemoCheckoutInformationPage.enterValueIntoFirstNameField(map.get("First name"));
        sauceDemoCheckoutInformationPage.enterValueIntoLastNameField(map.get("Last name"));
        sauceDemoCheckoutInformationPage.enterValueIntoPostalCodeField(map.get("Postal code"));
        sauceDemoCheckoutInformationPage.clickOnContinueButton();
        sauceDemoCheckoutOverviewPage.clickOnFinishButton();
    }

    @Then("the user verifies that the {string} message is present")
    public void verifiesThatTheMessageIsPresent(final String message) {
        assertEquals(message.toUpperCase(), sauceDemoOrderSuccessPage.getSuccessMessage());
    }
}