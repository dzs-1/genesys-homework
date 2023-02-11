@genesys_homework
@iframe_and_tab_handling
Feature: iFrame and tab handling

  @case_4
  Scenario: iFrame and tab handling
    Given the user opens the Guru Demo page
    And the user accepts the cookie consent on the Guru Demo page
    When the user scrolls down to the bottom of the page
    And the user clicks on the iFrame
    And the user switches to the new tab
    Then the user verifies that the new tab's title is "Selenium Live Project: FREE Real Time Project for Practice"
    And the user closes the tab
    And the user switches back to the original tab
    When the user scrolls up to the top of the page
    And the user clicks on the Testing link in the header
    And the user switches to the new tab
    And the user accepts the cookie consent the Guru Project page
    And the user verifies the red button is displayed on the page