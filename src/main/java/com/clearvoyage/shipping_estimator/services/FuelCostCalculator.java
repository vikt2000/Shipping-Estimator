package com.clearvoyage.shipping_estimator.services;

import com.clearvoyage.shipping_estimator.utils.DistanceManager;
import com.clearvoyage.shipping_estimator.utils.VoyageInfo;

public class FuelCostCalculator {

    public static Double calculateFuelCost(String portA, String portB) {
        VoyageInfo voyageInfo = DistanceManager.getVoyageInfo(portA, portB);

        if (voyageInfo == null) {
            return null;
        }

        double voyageDurationInDays = voyageInfo.getDuration();

        return calculateFuelCost(voyageDurationInDays);
    }

    public static double calculateFuelCost(double voyageDurationInDays) {

        double fuelConsumptionPerDay = 20.0;
        double fuelPricePerTonne = 500.0;

        double totalFuelConsumption = voyageDurationInDays * fuelConsumptionPerDay;

        return totalFuelConsumption * fuelPricePerTonne;
    }
}
