@Test

Feature: Testing Shopping Workflow

  Scenario: Main shopping workflow

    Given User navigate to the login page
    When User enter a valid username and password
    And User search for a product
    And User add the product to cart
    And User browse for books
    And User add a book to the cart
    And User go to the cart
    And User remove the book from the cart
    And User proceed to checkout
    And User provide invalid payment details
    Then User should see a payment error message




