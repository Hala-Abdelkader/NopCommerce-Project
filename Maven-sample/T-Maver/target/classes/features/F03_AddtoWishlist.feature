@Test

Feature: Testing wishlist

  Scenario: Add item to Wishlist
    Given User browse for an item
    And User add the item to my wishlist
    And User browse for another item
    Then User should see the items in the wishlist
    And User change the Qty of the second item
    And user the click update wishlist
    Then The user should see the new qty and price