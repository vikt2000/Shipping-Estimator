package com.clearvoyage.shipping_estimator.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FuelCostCalculatorTest {

    @Test
    void testCalculateFuelCost() {
        // Test the calculateFuelCost method with a distance that results in a round number for fuel cost
        double distanceInNauticalMiles = 1440.0; // Adjusted distance
        double expectedFuelCost = 50000.0; // Expected result based on the calculation
        double actualFuelCost = FuelCostCalculator.calculateFuelCost(distanceInNauticalMiles);
        
        // Assert that the actual fuel cost matches the expected fuel cost
        assertEquals(expectedFuelCost, actualFuelCost, 0.01);
    }

    @Test
    void testMain() {
        // This test can be used to ensure the main method runs without errors
        FuelCostCalculator.main(new String[]{});
    }
}
