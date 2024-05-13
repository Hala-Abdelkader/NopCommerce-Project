Feature: Scenario of Buying a Product and Confirming Order
@userStory1 @total
  Scenario:
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
    Then Window is Redirected to Thank you Page
