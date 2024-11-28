package com.clearvoyage.shipping_estimator.services;

import com.clearvoyage.shipping_estimator.utils.DistanceManager;
import com.clearvoyage.shipping_estimator.utils.VoyageInfo;

public class FuelCostCalculator {

    private static final double DEFAULT_FUEL_CONSUMPTION_PER_DAY = 20.0; // Tonnes per day
    private static final double DEFAULT_FUEL_PRICE_PER_TONNE = 500.0;   // USD per tonne
    private static final double AVERAGE_SPEED_KNOTS = 12.0;             // Knots

    /**
     * Calculates the fuel cost for a voyage between two ports.
     *
     * @param portA The name of the departure port.
     * @param portB The name of the destination port.
     * @return The total fuel cost in USD, or null if the voyage info is not found.
     */
    public static Double calculateFuelCost(String portA, String portB) {
        VoyageInfo voyageInfo = DistanceManager.getVoyageInfo(portA, portB);

        if (voyageInfo == null) {
            return null; // Voyage information not found
        }

        double voyageDurationInDays = calculateDurationInDays(voyageInfo);

        return calculateFuelCost(voyageDurationInDays, DEFAULT_FUEL_CONSUMPTION_PER_DAY, DEFAULT_FUEL_PRICE_PER_TONNE);
    }

    /**
     * Calculates the voyage duration in days based on distance and average speed.
     *
     * @param voyageInfo The voyage information containing distance details.
     * @return The voyage duration in days.
     */
    private static double calculateDurationInDays(VoyageInfo voyageInfo) {
        double distanceInNauticalMiles = voyageInfo.getDistance();
        return distanceInNauticalMiles / (AVERAGE_SPEED_KNOTS * 24);
    }

    /**
     * Calculates the fuel cost based on the voyage duration in days.
     *
     * @param voyageDurationInDays     The duration of the voyage in days.
     * @param fuelConsumptionPerDay    The daily fuel consumption in tonnes.
     * @param fuelPricePerTonne        The price of fuel per tonne in USD.
     * @return The total fuel cost in USD.
     */
    public static double calculateFuelCost(double voyageDurationInDays, double fuelConsumptionPerDay, double fuelPricePerTonne) {
        double totalFuelConsumption = voyageDurationInDays * fuelConsumptionPerDay;
        double totalFuelCost = totalFuelConsumption * fuelPricePerTonne;

        // Round to 2 decimal places
        return Math.round(totalFuelCost * 100.0) / 100.0;
    }

}
