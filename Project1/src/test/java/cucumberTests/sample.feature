@smokeTest
Feature: To test my cucumber test is running
  I want to run a sample feature file.

  Scenario: cucumber setup
    Given sample feature file is ready
    When I run the feature file
    Then run should be successful

  @selenium
  Scenario: Login scenario test for Gmail
    Given navigate to Gmail page
    When user logged in using username as "userName" and password as "Password"
    Then home page should be displayed
