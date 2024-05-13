Feature: Registering New Users

  @newRandom  #Used to Register New Valid User with Random Credentials
  Scenario: Registering Valid New User Account
    Given user go to Registration page
    When user select gender male
    And user enters FirstName and Last Name
    And user selects date of birth
    And user enters valid email
    And user enters "abc1234" as password
    And user clicks on Register Button
    Then Registration is Successful

  Scenario: Register with invalid credentials
    Given user go to Registration page
    When  user select gender male
    And user enters FirstName and Last Name
    And  user selects date of birth
    And  user enters valid email
    And  user enters "abc1234" as password
    And user enters "1234abc" as confirmation password
    And user clicks on Register Button
    Then User should see password unmatch error message