Feature: Buying product from featured products
  Scenario: User can buy product from featured product then check the method
    Given User login with valid data
    When User select product from featured products
    And User click on add to cart
    And User go to the shopping cart
    And User agree with the terms of service
    And User click on checkout button
    And User enter the required data and click continue
    And User change shipping method and click continue
    And User select payment method and click continue
    And User confirm on order details
    Then Order is successfully processed
    And User is logged out


