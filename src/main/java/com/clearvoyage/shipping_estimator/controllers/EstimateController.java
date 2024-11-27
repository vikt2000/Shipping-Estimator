package com.clearvoyage.shipping_estimator.controllers;

import com.clearvoyage.shipping_estimator.utils.VoyageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.clearvoyage.shipping_estimator.entities.Estimate;
import com.clearvoyage.shipping_estimator.services.EstimateService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estimates")
public class EstimateController {

    private final EstimateService estimateService;

    @Autowired
    public EstimateController(EstimateService estimateService) {
        this.estimateService = estimateService;
    }

    @PostMapping
    public ResponseEntity<Estimate> createEstimate(@RequestBody Estimate estimate) {
        Estimate savedEstimate = estimateService.saveEstimate(estimate);
        return ResponseEntity.ok(savedEstimate);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estimate> getEstimateById(@PathVariable Integer id) {
        Optional<Estimate> estimateOpt = estimateService.getEstimateById(id);
        return estimateOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Estimate>> getAllEstimates() {
        List<Estimate> estimates = estimateService.getAllEstimates();
        return ResponseEntity.ok(estimates);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estimate> updateEstimate(@PathVariable Integer id, @RequestBody Estimate estimate) {
        Optional<Estimate> updatedEstimateOpt = estimateService.updateEstimate(id, estimate);
        return updatedEstimateOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstimate(@PathVariable Integer id) {
        boolean isDeleted = estimateService.deleteEstimate(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/fuel-cost")
    public ResponseEntity<Double> getFuelCost(@RequestParam String portA, @RequestParam String portB) {
        if (!StringUtils.hasText(portA) || !StringUtils.hasText(portB)) {
            return ResponseEntity.badRequest().build();
        }

        try {
            Double fuelCost = estimateService.getFuelCostBetweenPorts(portA, portB);
            return ResponseEntity.ok(fuelCost);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/voyage-info")
    public ResponseEntity<VoyageInfo> getVoyageInfo(@RequestParam String portA, @RequestParam String portB) {
        if (!StringUtils.hasText(portA) || !StringUtils.hasText(portB)) {
            return ResponseEntity.badRequest().build();
        }

        try {
            VoyageInfo voyageInfo = estimateService.getVoyageInfoBetweenPorts(portA, portB);
            return ResponseEntity.ok(voyageInfo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(null);
        }
    }
}
