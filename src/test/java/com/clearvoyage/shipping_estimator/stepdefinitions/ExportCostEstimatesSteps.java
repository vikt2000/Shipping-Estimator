/*
package com.clearvoyage.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

public class ExportCostEstimatesSteps {

    private File exportedFile;

    @Given("I have generated a cost estimate for a route")
    public void generatedCostEstimate() {
        // Code to simulate generating a cost estimate
        System.out.println("Cost estimate for the route generated.");
    }

    @When("I select {string} and choose the format {string}")
    public void selectExportAndChooseFormat(String action, String format) {
        // Code to simulate selecting "Export" and choosing the format
        if ("Export".equals(action)) {
            exportedFile = exportCostEstimate(format);
        }
    }

    @Then("the system should download the estimate in the selected format")
    public void systemDownloadsEstimateInSelectedFormat() {
        // Code to verify the estimate is downloaded in the selected format
        assertTrue(exportedFile.exists(), "The exported file should exist.");
        System.out.println("Exported file: " + exportedFile.getPath());
    }

    private File exportCostEstimate(String format) {
        // Mock export logic
        String fileName = "cost_estimate." + (format.equalsIgnoreCase("PDF") ? "pdf" : "xlsx");
        return new File(fileName);
    }
}
*/