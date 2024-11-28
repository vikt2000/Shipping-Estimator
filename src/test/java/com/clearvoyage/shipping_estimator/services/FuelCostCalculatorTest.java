/*
package com.clearvoyage.shipping_estimator.services;

import com.clearvoyage.shipping_estimator.utils.DistanceManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNull;

public class FuelCostCalculatorTest {

    private MockedStatic<DistanceManager> mockedDistanceManager;

    @BeforeEach
    void setUp() {
        mockedDistanceManager = Mockito.mockStatic(DistanceManager.class);
    }

    @Test
    void testCalculateFuelCost() {
        // Mock the voyage info
        VoyageInfo voyageInfo = new VoyageInfo(5.0); // 5 days duration
        mockedDistanceManager.when(() -> DistanceManager.getVoyageInfo("PortA", "PortB"))
                             .thenReturn(voyageInfo);

        // Expected result based on the calculation
        double expectedFuelCost = 5.0 * 20.0 * 500.0; // 5 days * 20 tonnes/day * 500 USD/tonne
        Double actualFuelCost = FuelCostCalculator.calculateFuelCost("PortA", "PortB");

        // Assert that the actual fuel cost matches the expected fuel cost
        assertEquals(expectedFuelCost, actualFuelCost, 0.01);
    }

    @Test
    void testCalculateFuelCostWithInvalidPorts() {
        // Mock the voyage info to return null for invalid ports
        mockedDistanceManager.when(() -> DistanceManager.getVoyageInfo("InvalidPortA", "InvalidPortB"))
                             .thenReturn(null);

        // Assert that the actual fuel cost is null
        Double actualFuelCost = FuelCostCalculator.calculateFuelCost("InvalidPortA", "InvalidPortB");
        assertNull(actualFuelCost);
    }
}
*/