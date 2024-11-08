package com.clearvoyage.shipping_estimator.services;

public class FuelCostCalculator {

    public static void main(String[] args) {
        // Define the distance of the voyage in nautical miles
        double distanceInNauticalMiles = 1000.0;
        
        // Calculate the fuel cost for the given distance
        double fuelCost = calculateFuelCost(distanceInNauticalMiles);

        // Print the total fuel cost
        System.out.println("Total fuel cost: $" + fuelCost);
    }

    /**
     * Calculates the fuel cost based on the distance.
     *
     * @param distanceInNauticalMiles The distance of the voyage in nautical miles.
     * @return The total fuel cost in USD.
     */
    public static double calculateFuelCost(double distanceInNauticalMiles) {
        // Average speed of the ship in knots
        double averageSpeedInKnots = 12.0;
        
        // Fuel consumption per day in tonnes
        double fuelConsumptionPerDay = 20.0;
        
        // Price of fuel per tonne in USD
        double fuelPricePerTonne = 500.0;

        // Calculate the duration of the voyage in days
        double voyageDurationInDays = distanceInNauticalMiles / averageSpeedInKnots / 24.0;

        // Calculate the total fuel consumption for the voyage
        double totalFuelConsumption = voyageDurationInDays * fuelConsumptionPerDay;

        // Calculate and return the total fuel cost
        return totalFuelConsumption * fuelPricePerTonne;
    }
}
