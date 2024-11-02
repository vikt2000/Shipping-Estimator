package com.clearvoyage.shipping_estimator.services;

import com.clearvoyage.shipping_estimator.entities.Port;
import java.util.List;
import java.util.Optional;

public interface PortService {

    /**
     * Saves a new Port to the database.
     *
     * @param port The port to save.
     * @return The saved port.
     */
    Port savePort(Port port);

    /**
     * Retrieves a Port by its ID.
     *
     * @param id The ID of the port.
     * @return An Optional containing the found port or empty if not found.
     */
    Optional<Port> getPortById(Integer id);

    /**
     * Retrieves all Ports from the database.
     *
     * @return A list of all ports.
     */
    List<Port> getAllPorts();

    /**
     * Updates an existing Port.
     *
     * @param id   The ID of the port to update.
     * @param port The port data to update.
     * @return The updated port, or Optional.empty() if not found.
     */
    Optional<Port> updatePort(Integer id, Port port);

    /**
     * Deletes a Port by its ID.
     *
     * @param id The ID of the port to delete.
     * @return True if deletion was successful, false otherwise.
     */
    boolean deletePort(Integer id);
}
