
Feature: Registering New Users

  @userStory5 @userStory1  #Used to Register New Valid User with Random Credentials
  Scenario: Registering Valid New User Account
    Given user go to Registration page
    When user select gender male
    And user enters FirstName and Last Name
    And user selects date of birth
    And user enters valid email
    And user enters valid password
    And user clicks on Register Button
    Then Registration is Successful
