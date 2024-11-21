package com.clearvoyage.shipping_estimator.controllers;

import com.clearvoyage.shipping_estimator.services.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StringUtils;

@RestController
@RequestMapping("/api/distances")
public class DistanceController {

    private final DistanceService distanceService;

    @Autowired
    public DistanceController(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @GetMapping
    public ResponseEntity<Double> getDistance(@RequestParam String portA, @RequestParam String portB) {
        if (!StringUtils.hasText(portA) || !StringUtils.hasText(portB)) {
            return ResponseEntity.badRequest().body(null);
        }

        Double distance = distanceService.getDistance(portA, portB);

        if (distance != null) {
            return ResponseEntity.ok(distance);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}
