Feature: Input custom fuel prices
  As a logistics coordinator,
  I want to input custom fuel prices for specific regions
  So that I can get accurate cost estimates for different locations.

  Scenario: Use custom fuel prices in cost estimation
    Given I have entered a custom fuel price for a specific region
    When I run the cost estimation for a route that includes this region
    Then the system should calculate the cost using the custom fuel price for that region
