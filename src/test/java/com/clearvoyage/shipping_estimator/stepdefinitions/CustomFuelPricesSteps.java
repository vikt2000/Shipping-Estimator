/*
package com.clearvoyage.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomFuelPricesSteps {

    private double estimatedCost;

    @Given("I have entered a custom fuel price for a specific region")
    public void enteredCustomFuelPrice() {
        // Code to simulate entering a custom fuel price for a region
        System.out.println("Custom fuel price for the region entered.");
    }

    @When("I run the cost estimation for a route that includes this region")
    public void runCostEstimation() {
        // Code to run the cost estimation using the custom fuel price
        String route = "Route including custom region";
        estimatedCost = calculateCostWithCustomFuelPrice(route);
    }

    @Then("the system should calculate the cost using the custom fuel price for that region")
    public void systemCalculatesCostWithCustomFuelPrice() {
        // Code to verify the cost is calculated using the custom fuel price
        double expectedCost = 150.0; // Example expected cost with custom fuel price
        assertEquals(expectedCost, estimatedCost, "The cost should be calculated using the custom fuel price.");
    }

    private double calculateCostWithCustomFuelPrice(String route) {
        // Mock calculation logic using custom fuel price
        return 150.0; // Example cost with custom fuel price
    }
}
*/