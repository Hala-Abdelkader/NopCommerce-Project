Feature: Scenario of user Login and Changing Account Info

  @userStory5 @total
  Scenario: Changing Credentials from My Account Page
    Given User LogIn Valid
    And user navigates to My Account page
    When user changes gender to female
    And user changes Name
    And user changes date of birthday
    And user changes email
    And user clicks save
    Then My Account info is Updated
