package com.clearvoyage.shipping_estimator.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.HashMap;

public class DistanceManager {

    private static final String DISTANCE_FILE = "PortDistanceCache.JSON";
    private static Map<String, VoyageInfo> voyageInfoMap = new HashMap<>();

    static {
        loadVoyageInfo();
    }

    private static void loadVoyageInfo() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = DistanceManager.class.getClassLoader().getResourceAsStream(DISTANCE_FILE)) {
            if (inputStream != null) {
                voyageInfoMap = objectMapper.readValue(inputStream, new TypeReference<Map<String, VoyageInfo>>() {});
            } else {
                System.err.println("Distance file not found: " + DISTANCE_FILE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static VoyageInfo getVoyageInfo(String portA, String portB) {
        String key = createKey(portA, portB);
        return voyageInfoMap.get(key);
    }

    private static String createKey(String portA, String portB) {
        String portAUpper = portA.trim().toUpperCase();
        String portBUpper = portB.trim().toUpperCase();

        if (portAUpper.compareTo(portBUpper) < 0) {
            return portAUpper + "-" + portBUpper;
        } else {
            return portBUpper + "-" + portAUpper;
        }
    }
}
