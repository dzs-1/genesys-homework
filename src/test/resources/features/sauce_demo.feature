Feature: Sauce Demo

  Scenario: Case 1 - Automate Purchase Process
    Given the user opens the Sauce Demo page
    When the user logs in to the Sauce Demo page
    And the user adds the following items to the cart:
      |         Sauce Labs Backpack        |
      |       Sauce Labs Fleece Jacket     |
    Then the user validates that there are 2 items in the cart
    When the user goes through the checkout process with the following data:
      |      First name      |    Last name    |      Postal code       |
      |         Fred         |      Robot      |         1010           |
    Then the user verifies that the "Thank you for your order" message is present

