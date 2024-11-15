/*
package com.clearvoyage.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompareRouteCostsSteps {

    private String comparisonResult;

    @Given("I have entered multiple shipping routes")
    public void enteredMultipleRoutes() {
        // Code to simulate entering multiple shipping routes
        System.out.println("Multiple shipping routes entered.");
    }

    @When("I click on {string}")
    public void clickOnCompareCosts(String button) {
        // Code to simulate clicking the "Compare Costs" button
        if ("Compare Costs".equals(button)) {
            comparisonResult = compareRouteCosts();
        }
    }

    @Then("the system should display the cost of each route side by side, with an option to highlight the most cost-effective route")
    public void systemDisplaysCostComparison() {
        // Code to verify the cost comparison is displayed
        assertTrue(comparisonResult.contains("Route A: $500") && comparisonResult.contains("Route B: $450"), 
                   "The cost comparison should display the costs of each route.");
        System.out.println("Cost comparison result: " + comparisonResult);
    }

    private String compareRouteCosts() {
        // Mock comparison logic
        return "Route A: $500, Route B: $450, Most cost-effective: Route B";
    }
}
*/