package com.clearvoyage.shipping_estimator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.clearvoyage.shipping_estimator.entities.Port;
import com.clearvoyage.shipping_estimator.services.PortService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ports")
public class PortController {

    private final PortService portService;

    @Autowired
    public PortController(PortService portService) {
        this.portService = portService;
    }

    /**
     * Creates a new Port.
     *
     * @param port The port to create.
     * @return The created port.
     */
    @PostMapping
    public ResponseEntity<Port> createPort(@RequestBody Port port) {
        Port savedPort = portService.savePort(port);
        return ResponseEntity.ok(savedPort);
    }

    /**
     * Retrieves a Port by its ID.
     *
     * @param id The ID of the port.
     * @return The found port or 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Port> getPortById(@PathVariable Integer id) {
        Optional<Port> portOpt = portService.getPortById(id);
        return portOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Retrieves all Ports.
     *
     * @return A list of all ports.
     */
    @GetMapping
    public ResponseEntity<List<Port>> getAllPorts() {
        List<Port> ports = portService.getAllPorts();
        return ResponseEntity.ok(ports);
    }

    /**
     * Updates an existing Port.
     *
     * @param id   The ID of the port to update.
     * @param port The port data to update.
     * @return The updated port or 404 if not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Port> updatePort(@PathVariable Integer id, @RequestBody Port port) {
        Optional<Port> updatedPortOpt = portService.updatePort(id, port);
        return updatedPortOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Deletes a Port by its ID.
     *
     * @param id The ID of the port to delete.
     * @return A response indicating the outcome.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePort(@PathVariable Integer id) {
        boolean isDeleted = portService.deletePort(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
