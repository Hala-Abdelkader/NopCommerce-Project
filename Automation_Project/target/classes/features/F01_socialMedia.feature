Feature: User can navigate to the social media pages for the website

  Scenario: User navigates to social media pages
    Given User is on the homepage
    When User verifies the presence of social media icons
    And User clicks on the Facebook icon
    Then Facebook page should be opened
    When User clicks on the Twitter icon
    Then Twitter page should be opened
    When User clicks on the RSS icon
    Then RSS page should be opened
    When User clicks on the YouTube icon
    Then YouTube channel should be opened
