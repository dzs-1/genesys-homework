package org.dozsapeter.genesys.ui_testing.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.dozsapeter.genesys.ui_testing.user_interfaces.guru_demo.GuruDemoHomePage;
import org.dozsapeter.genesys.ui_testing.user_interfaces.guru_demo.GuruDemoProjectPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuruDemoStepDefinitions {

    GuruDemoHomePage guruDemoHomePage;
    GuruDemoProjectPage guruDemoProjectPage;

    @Given("the user opens the Guru Demo page")
    public void opensTheGuruDemoPage() {
        guruDemoHomePage = new GuruDemoHomePage();
        guruDemoHomePage.openPage();
    }

    @When("the user clicks on the iFrame")
    public void clicksOnTheIFrame() {
        guruDemoHomePage = new GuruDemoHomePage();
        guruDemoHomePage.clickOnIFrame();
    }

    @And("the user switches to the new tab")
    public void switchesToTheNewTab() {
        guruDemoHomePage = new GuruDemoHomePage();
        guruDemoHomePage.switchToNewTab();
    }

    @Then("the user verifies that the new tab's title is {string}")
    public void verifiesThatTheNewTabSTitleIs(final String tabTitle) {
        guruDemoHomePage = new GuruDemoHomePage();
        assertEquals(tabTitle, guruDemoHomePage.getTabTitle());
    }

    @And("the user closes the tab")
    public void closesTheTab() {
        guruDemoHomePage = new GuruDemoHomePage();
        guruDemoHomePage.closeTab();
    }

    @And("the user switches back to the original tab")
    public void switchesBackToOriginalTab() {
        guruDemoHomePage = new GuruDemoHomePage();
        guruDemoHomePage.switchToOriginalTab();
    }

    @And("the user clicks on the Testing link in the header")
    public void clicksOnTheTestingLinkInTheHeader() {
        guruDemoHomePage = new GuruDemoHomePage();
        guruDemoHomePage.clickOnTestingLink();
    }

    @And("the user accepts the cookie consent on the Guru Demo page")
    public void acceptsTheCookieConsent() {
        guruDemoHomePage = new GuruDemoHomePage();
        guruDemoHomePage.clickOnAcceptAllCookiesButton();
    }

    @And("the user verifies the red button is displayed on the page")
    public void verifiesTheRedButtonIsDisplayedOnThePage() {
        guruDemoProjectPage= new GuruDemoProjectPage();
        assertTrue(guruDemoProjectPage.isRedButtonVisible());
    }

    @And("the user accepts the cookie consent the Guru Project page")
    public void theUserAcceptsTheCookieConsentTheGuruProjectPage() {
        guruDemoProjectPage= new GuruDemoProjectPage();
        guruDemoProjectPage.clickOnAcceptCookieConsent();
    }
}