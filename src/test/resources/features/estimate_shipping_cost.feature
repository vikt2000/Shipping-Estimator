Feature: Estimate shipping cost
  As a logistics coordinator,
  I want to estimate the shipping cost for a given route
  So that I can make cost-effective decisions.

  Scenario: Estimate shipping cost for a specific route
    Given I have access to the estimator and have entered a specific shipping route
    When I click on "Calculate Cost"
    Then the system should display an estimated shipping cost for that route
