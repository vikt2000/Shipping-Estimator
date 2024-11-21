package com.clearvoyage.shipping_estimator.utils;

public class VoyageInfo {

    private double distance; // In nautical miles
    private double duration; // In days

    public VoyageInfo() {
        // Default constructor for JSON deserialization
    }

    public VoyageInfo(double distance, double duration) {
        this.distance = distance;
        this.duration = duration;
    }

    // Getters and Setters
    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
