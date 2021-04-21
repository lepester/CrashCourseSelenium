Feature: Go to SoftServe IT Academy Site

@RunMe
Scenario: Open SoftServe IT Academy WebPage

Given I open Google
When I enter a query and proceed to search results
Then I should check whether the site is correct
And I close browser