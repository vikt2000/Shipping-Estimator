Feature: Optimize routes
  As a logistics coordinator,
  I want to optimize routes based on both fuel cost and time
  So that I can balance expenses with delivery schedules.

  Scenario: Optimize route based on fuel cost and time
    Given I have entered a route and details about time constraints and fuel prices
    When I click on "Optimize Route"
    Then the system should suggest the most efficient route based on the balance between fuel costs and delivery time
