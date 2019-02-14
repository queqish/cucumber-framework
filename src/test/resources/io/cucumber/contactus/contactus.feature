Feature: Submit data to webdriveruniversity.com using contact us form

  @NotImportant
  Scenario: Submit valid data via contact us form
    Given I access webdriveruniversity
    When I click on the contact us button
    And I enter a valid first name
    And I enter a valid last name
      | Picasso | Pueblo|
    And I enter a valid email address
    And I enter comments
      | example comment one | example comment two|
    When I click on the submit button
    Then the information should successfully be submitted via the contact us form

  @Important
  Scenario: Submit valid data via contact us form
    Given I access webdriveruniversity
    When I click on the contact us button
    And I enter a valid first name
    And I enter a valid last name
      | Important | Test|
    And I enter a valid email address
    And I enter comments
      | Yes | WAS|
    When I click on the submit button
    Then the information should successfully be submitted via the contact us form

  @Destructive
  Scenario: Submit valid data via contact us form
    Given I access webdriveruniversity
    When I click on the contact us button
    And I enter a valid first name
    And I enter a valid last name
      | Picasso | Pueblo|
    And I enter a valid email address
    And I enter comments
      | example comment one | example comment two|
    When I click on the submit button
    Then the information should successfully be submitted via the contact us form

    #DataTables