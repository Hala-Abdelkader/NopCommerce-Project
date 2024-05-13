Feature: Scenario of Testing Contact Us Messaging

  #Positive
  @userStory10 @total
  Scenario: User can send Enquiry through Contact Us page without registering
    Given user go to Contact Us page
    When user enters name
    And user enters email
    And user enters inquiry
    And user clicks submit
    Then user sees message sent successfully

  #Negative
  Scenario: User fails to send Empty Enquiry is Sent
    Given user go to Contact Us page
    And all fields in Contact Us are empty
    When user clicks submit
    Then error popups should be displayed