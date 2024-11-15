Feature: Generate detailed cost reports
  As a logistics coordinator,
  I want to generate detailed reports on the cost breakdown of each trip
  So that I can present this data to stakeholders and support my decisions.

  Scenario: Generate a detailed cost breakdown report
    Given I have completed a cost estimation for a trip
    When I click on "Generate Report"
    Then the system should provide a detailed cost breakdown, including fuel costs, port fees, and any other expenses
