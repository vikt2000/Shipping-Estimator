package com.clearvoyage.shipping_estimator.services;

import com.clearvoyage.shipping_estimator.entities.Port;
import com.clearvoyage.shipping_estimator.utils.PortManager;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PortCacheService {

    /**
     * Retrieves all ports.
     *
     * @return A list of all Port objects.
     */
    public List<Port> getAllPorts() {
        return PortManager.getAllPorts();
    }

    /**
     * Retrieves a port by its name.
     *
     * @param name The name of the port.
     * @return The Port object, or null if not found.
     */
    public Port getPortByName(String name) {
        return PortManager.getPortByName(name);
    }
}
