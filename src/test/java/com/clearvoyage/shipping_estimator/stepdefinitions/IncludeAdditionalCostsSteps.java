/*
package com.clearvoyage.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncludeAdditionalCostsSteps {

    private double finalCostEstimate;

    @Given("I have entered additional costs (insurance, port fees, surcharges)")
    public void enteredAdditionalCosts() {
        // Code to simulate entering additional costs
        System.out.println("Additional costs (insurance, port fees, surcharges) entered.");
    }

    @When("I run the estimate")
    public void runEstimate() {
        // Code to run the estimate including additional costs
        finalCostEstimate = calculateFinalCostEstimate(1000.0, 100.0, 50.0, 25.0); // Example base cost and additional costs
    }

    @Then("the system should include these additional costs in the final cost estimate")
    public void systemIncludesAdditionalCosts() {
        // Code to verify the final cost estimate includes additional costs
        double expectedFinalCost = 1175.0; // Example expected final cost
        assertEquals(expectedFinalCost, finalCostEstimate, "The final cost estimate should include additional costs.");
    }

    private double calculateFinalCostEstimate(double baseCost, double insurance, double portFees, double surcharges) {
        // Mock calculation logic
        return baseCost + insurance + portFees + surcharges;
    }
}
*/