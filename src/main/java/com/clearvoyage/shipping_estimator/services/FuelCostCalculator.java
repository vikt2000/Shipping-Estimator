package com.clearvoyage.shipping_estimator.services;

import com.clearvoyage.shipping_estimator.utils.DistanceManager;
import com.clearvoyage.shipping_estimator.utils.VoyageInfo;

public class FuelCostCalculator {

    /**
     * Calculates the fuel cost for a voyage between two ports.
     *
     * @param portA The name of the departure port.
     * @param portB The name of the destination port.
     * @return The total fuel cost in USD, or null if the voyage info is not found.
     */
    public static Double calculateFuelCost(String portA, String portB) {
        // Retrieve the voyage information between the two ports
        VoyageInfo voyageInfo = DistanceManager.getVoyageInfo(portA, portB);

        if (voyageInfo == null) {
            // Voyage information not found return null
            return null;
        }

        // Use the duration provided in the voyage info
        double voyageDurationInDays = voyageInfo.getDuration();

        // Calculate the fuel cost
        return calculateFuelCost(voyageDurationInDays);
    }

    /**
     * Calculates the fuel cost based on the voyage duration in days.
     *
     * @param voyageDurationInDays The duration of the voyage in days.
     * @return The total fuel cost in USD.
     */
    public static double calculateFuelCost(double voyageDurationInDays) {

        double fuelConsumptionPerDay = 20.0;     // Fuel consumption in tonnes per day
        double fuelPricePerTonne = 500.0;        // Fuel price in USD per tonne

        // Calculate total fuel consumption in tonnes
        double totalFuelConsumption = voyageDurationInDays * fuelConsumptionPerDay;

        // Calculate total fuel cost
        return totalFuelConsumption * fuelPricePerTonne;
    }
}
