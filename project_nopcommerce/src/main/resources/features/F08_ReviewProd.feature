Feature: Review a specific product in the website
  @total
  Scenario: User can review a product he bought
    Given User LogIn Valid
    When User click on my account
    And User click on Orders
    And User click on details
    And User select a specific product from a previous order
    And User click on add review and write the review details
    Then User Submit his review

