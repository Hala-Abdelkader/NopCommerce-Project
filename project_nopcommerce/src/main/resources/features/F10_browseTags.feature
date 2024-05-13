Feature: Testing Tags
  @total
  Scenario: Browse product by tag

    Given User browse computers category
    And User click view all tags
    Then User should see all the tags
    And User click on shoes tag
    Then User show see the product under this tags