package com.clearvoyage.shipping_estimator.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FuelCostCalculatorTest {

    @Test
    void testCalculateFuelCost() {
        // Test the calculateFuelCost method with valid ports
        String portA = "PortA";
        String portB = "PortB";
        double expectedFuelCost = 50000.0; // Expected result based on the calculation
        Double actualFuelCost = FuelCostCalculator.calculateFuelCost(portA, portB);
        
        // Assert that the actual fuel cost matches the expected fuel cost
        assertEquals(expectedFuelCost, actualFuelCost, 0.01);
    }

    @Test
    void testCalculateFuelCostWithInvalidPorts() {
        // Test the calculateFuelCost method with invalid ports
        String portA = "InvalidPortA";
        String portB = "InvalidPortB";
        Double actualFuelCost = FuelCostCalculator.calculateFuelCost(portA, portB);
        
        // Assert that the actual fuel cost is null
        assertNull(actualFuelCost);
    }
/* 
    @Test
    void testMain() {
        // This test can be used to ensure the main method runs without errors
        FuelCostCalculator.main(new String[]{});
    }
*/
}
