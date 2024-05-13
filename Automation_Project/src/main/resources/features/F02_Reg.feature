Feature: User can create new account
  Scenario: User can register with valid data
    Given User go to register page
    When User select gender
    And User enter first name and last name
    And user select date of birth
    And user enter email
    And user enter password and confirmation password
    And user click on register button
    Then account is created successfully


