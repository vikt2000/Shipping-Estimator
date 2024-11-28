package com.clearvoyage.shipping_estimator.controllers;

import com.clearvoyage.shipping_estimator.entities.Port;
import com.clearvoyage.shipping_estimator.services.PortCacheService;
import com.clearvoyage.shipping_estimator.services.PortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ports")
public class PortController {

    private final PortCacheService portCacheService;

    @Autowired
    public PortController(PortCacheService portCacheService) {
        this.portCacheService = portCacheService;
    }

    /**
     * Retrieves all ports.
     *
     * @return A list of all Port objects.
     */
    @GetMapping
    public ResponseEntity<List<Port>> getAllPorts() {
        List<Port> ports = portCacheService.getAllPorts();
        return ResponseEntity.ok(ports);
    }

    /**
     * Retrieves a specific port by name.
     *
     * @param name The name of the port.
     * @return The Port object, or 404 if not found.
     */
    @GetMapping("/{name}")
    public ResponseEntity<Port> getPortByName(@PathVariable String name) {
        Port port = portCacheService.getPortByName(name);
        if (port != null) {
            return ResponseEntity.ok(port);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
