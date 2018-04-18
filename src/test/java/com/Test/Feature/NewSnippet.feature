@test
Feature: Snippet Functionality

  Background:
    Given I am on the "Sign_Up" page
    And I have signed in successfully

  Scenario: Create Snippet
    When I navigate to the "New Snippet" page
    And I complete the "New Snippet" form
    Then the snippet is displayed successfully