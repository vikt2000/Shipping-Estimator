Feature: Estimate CO2 emissions
  As a logistics coordinator,
  I want to estimate the environmental impact (CO2 emissions) for different routes
  So that I can make more eco-friendly choices, if relevant to the company’s goals.

  Scenario: Calculate CO2 emissions for a specific route
    Given I have entered a route and ship details
    When I click on "Calculate CO2 Emissions"
    Then the system should display an estimate of CO2 emissions for that specific route
