Feature: Feature to test DuckDuckGo search functionality

  @SmokeTest
  Scenario: Check if the DuckDuckGo search is working
    Given browser is open
    And user is on the DuckDuckGo search page
    When user searches current time in California
    And hits enter
    Then user is shown the search results