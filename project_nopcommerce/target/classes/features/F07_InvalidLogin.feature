Feature: Login with invalid data
  @total
  Scenario: User login with correct email and wrong password and test forget password
    Given User go to login page
    When User Enter the email
    And User enter password
    And User click on login button
    Then User can't login successfully
    When User click on forget password
    And User write his recovery email address
    And User click on recover button
    Then the account is recovered successfully
