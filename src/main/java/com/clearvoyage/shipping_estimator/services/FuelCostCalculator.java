package com.clearvoyage.shipping_estimator.services;

public class FuelCostCalculator {

    public static void main(String[] args) {
        double distanceInNauticalMiles = 1000.0;
        double fuelCost = calculateFuelCost(distanceInNauticalMiles);

        System.out.println("Total fuel cost: $" + fuelCost);
    }

    /**
     * Calculates the fuel cost based on the distance.
     *
     * @param distanceInNauticalMiles The distance of the voyage in nautical miles.
     * @return The total fuel cost in USD.
     */
    public static double calculateFuelCost(double distanceInNauticalMiles) {

        double averageSpeedInKnots = 12.0;
        double fuelConsumptionPerDay = 20.0;
        double fuelPricePerTonne = 500.0;

        double voyageDurationInDays = distanceInNauticalMiles / averageSpeedInKnots / 24.0;

        double totalFuelConsumption = voyageDurationInDays * fuelConsumptionPerDay;

        return totalFuelConsumption * fuelPricePerTonne;
    }
}
