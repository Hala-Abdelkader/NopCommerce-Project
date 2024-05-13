Feature: Scenario of Buying a Product and Confirming Order
@userStory1 @total
  Scenario: User by product through given url
    Given User LogIn Valid
    When User Navigates to Performance PC Product Page
    And User Clicks on Add to Cart
    And User Clicks on Shopping Cart Icon
    And User Clicks on Checkout
    And User Enter Valid Credentials
    And User Chooses Ground Shipping Method
    And User Chooses Cheque Payment Method
    And User Clicks On Continue in Payment Info Section
    And User Clicks On Confirm Button
    Then Order is successfully processed
@total
  Scenario: User can buy product from featured product then check the method
    Given User LogIn Valid
    When User select product from featured products
    And User click on add to cart
    And User Clicks on Shopping Cart Icon
    And User Clicks on Checkout
    And User Enter Valid Credentials
    And User Chooses Ground Shipping Method
    And User Chooses Cheque Payment Method
    And User Clicks On Continue in Payment Info Section
    And User Clicks On Confirm Button
    Then Order is successfully processed
@total
  Scenario: Browsing through website adding/removing items and checking out with an invalid Credit Card
    Given User LogIn Valid
    And User search for a product
    And User add the product to cart
    And User browse for books
    And User add a book to the cart
    And User go to the cart
    And User remove the book from the cart
    And User Clicks on Checkout
    And User Enter Valid Credentials
    And User Chooses Ground Shipping Method
    And User provide invalid payment details
    Then User should see a payment error message

