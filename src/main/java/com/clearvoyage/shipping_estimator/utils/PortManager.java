package com.clearvoyage.shipping_estimator.utils;

import com.clearvoyage.shipping_estimator.entities.Port;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;

public class PortManager {

    private static final String PORTS_FILE = "PortCache.json";
    private static List<Port> portsList = new ArrayList<>();

    static {
        loadPorts();
    }

    /**
     * Loads ports from the JSON file into the list.
     */
    private static void loadPorts() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = PortManager.class.getClassLoader().getResourceAsStream(PORTS_FILE)) {
            if (inputStream != null) {
                portsList = objectMapper.readValue(inputStream, new TypeReference<List<Port>>() {});
            } else {
                System.err.println("Ports file not found: " + PORTS_FILE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the list of all ports.
     *
     * @return A list of Port objects.
     */
    public static List<Port> getAllPorts() {
        return new ArrayList<>(portsList); // Return a copy to prevent modification
    }

    /**
     * Retrieves a specific port by name.
     *
     * @param name The name of the port.
     * @return The Port object, or null if not found.
     */
    public static Port getPortByName(String name) {
        if (name == null) {
            return null;
        }
        String nameUpper = name.trim().toUpperCase();
        for (Port port : portsList) {
            if (port.getName().trim().toUpperCase().equals(nameUpper)) {
                return port;
            }
        }
        return null;
    }
}
