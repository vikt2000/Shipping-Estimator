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

    @PostMapping
    public ResponseEntity<Port> createPort(@RequestBody Port port) {
        Port savedPort = portService.savePort(port);
        return ResponseEntity.ok(savedPort);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Port> getPortById(@PathVariable Integer id) {
        Optional<Port> portOpt = portService.getPortById(id);
        return portOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Port>> getAllPorts() {
        List<Port> ports = portService.getAllPorts();
        return ResponseEntity.ok(ports);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Port> updatePort(@PathVariable Integer id, @RequestBody Port port) {
        Optional<Port> updatedPortOpt = portService.updatePort(id, port);
        return updatedPortOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

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
