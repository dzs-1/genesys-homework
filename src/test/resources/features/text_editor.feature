@genesys_homework
@text_editor
Feature: Text Editor

  @case_3
  Scenario: Case 3 - Rich Text Editor
    Given the user opens the text editor
    When the user clicks on bold style button in the editor
    And the user types "Automation" in the editor
    And the user clicks on bold style button in the editor
    And the user hits space
    And the user clicks on  underline style in the editor
    And the user types "Test" in the editor
    And the user clicks on  underline style in the editor
    And the user hits space
    And the user types "Example" in the editor
    Then the user validates that the typed text is "Automation Test Example"
