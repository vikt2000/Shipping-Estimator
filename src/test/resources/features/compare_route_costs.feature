Feature: Compare route costs
  As a logistics coordinator,
  I want to input multiple routes and compare their costs
  So that I can choose the most cost-effective option.

  Scenario: Compare costs of multiple routes
    Given I have entered multiple shipping routes
    When I click on "Compare Costs"
    Then the system should display the cost of each route side by side, with an option to highlight the most cost-effective route
