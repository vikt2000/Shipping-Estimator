/*
package com.clearvoyage.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShippingCostSteps {

    private double estimatedCost;

    @Given("I have access to the estimator and have entered a specific shipping route")
    public void accessToEstimatorAndEnterRoute() {
        // Code to ensure access to the estimator and enter the route
        System.out.println("Access to the estimator confirmed and route entered.");
    }

    @When("I click on {string}")
    public void clickOnCalculateCost(String button) {
        // Code to simulate clicking the "Calculate Cost" button
        if ("Calculate Cost".equals(button)) {
            estimatedCost = calculateShippingCost("Route A to B");
        }
    }

    @Then("the system should display an estimated shipping cost for that route")
    public void displayEstimatedCost() {
        // Code to verify the estimated cost is displayed
        double expectedCost = 100.0; // Example expected cost
        assertEquals(expectedCost, estimatedCost, "The estimated shipping cost should be displayed correctly.");
    }

    private double calculateShippingCost(String route) {
        // Mock calculation logic
        return 100.0; // Example cost
    }
}

*/

/*I have used an ai to generete a templete for a user story to test find the userstory in test/resources/features/estimate_shipping_cost.feature */