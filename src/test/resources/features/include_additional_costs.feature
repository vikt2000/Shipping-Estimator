Feature: Include additional costs in shipping estimate
  As a logistics coordinator,
  I want the ability to include additional costs such as insurance, port fees, and other surcharges in the estimate
  So that I can have a comprehensive view of the total shipping cost.

  Scenario: Include additional costs in the final cost estimate
    Given I have entered additional costs (insurance, port fees, surcharges)
    When I run the estimate
    Then the system should include these additional costs in the final cost estimate
