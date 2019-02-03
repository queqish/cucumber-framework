Feature: Send email via contact us form on webdriveruniversity.com website
  User should be able to send email via form when enters correct email address
  User should be able to reset form when he want to clear all textboxes
  User should not be able to send email via form when enters inccorrect email address

  Background:
    Given A User navigates to webdriveruniversity website
    And User enters first name
    And User enters last name
    And User enters Comment

  Scenario:
    Given User enters "user@webdriver.com" email address
    When User clicks submit button
    Then User should see correct message

  Scenario:
    Given User enters "incorrectemail" email address
    When User clicks submit button
    Then User should see error message

  Scenario:
    Given User enters "user@webdriver.com" email address
    When User clicks reset button
    Then All textboxes should be empty