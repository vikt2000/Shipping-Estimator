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

    /**
     * Creates a new Estimate.
     *
     * @param estimate The estimate to create.
     * @return The created estimate.
     */
    @PostMapping
    public ResponseEntity<Estimate> createEstimate(@RequestBody Estimate estimate) {
        Estimate savedEstimate = estimateService.saveEstimate(estimate);
        return ResponseEntity.ok(savedEstimate);
    }

    /**
     * Retrieves an Estimate by its ID.
     *
     * @param id The ID of the estimate.
     * @return The found estimate or 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Estimate> getEstimateById(@PathVariable Integer id) {
        Optional<Estimate> estimateOpt = estimateService.getEstimateById(id);
        return estimateOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Retrieves all Estimates.
     *
     * @return A list of all estimates.
     */
    @GetMapping
    public ResponseEntity<List<Estimate>> getAllEstimates() {
        List<Estimate> estimates = estimateService.getAllEstimates();
        return ResponseEntity.ok(estimates);
    }

    /**
     * Updates an existing Estimate.
     *
     * @param id       The ID of the estimate to update.
     * @param estimate The estimate data to update.
     * @return The updated estimate or 404 if not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Estimate> updateEstimate(@PathVariable Integer id, @RequestBody Estimate estimate) {
        Optional<Estimate> updatedEstimateOpt = estimateService.updateEstimate(id, estimate);
        return updatedEstimateOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Deletes an Estimate by its ID.
     *
     * @param id The ID of the estimate to delete.
     * @return A response indicating the outcome.
     */
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

    @GetMapping("/cargo-cost")
    public ResponseEntity<Double> getCargoCost(@RequestParam Double amount, @RequestParam Double price) {
        if (amount == null || price == null || amount < 0 || price < 0) {
            return ResponseEntity.badRequest().build();
        }

        Double cargoCost = amount * price;
        return ResponseEntity.ok(cargoCost);
    }

    /**
     * Calculates the broker commission based on the cargo cost and given percentage.
     *
     * @param amount     The amount in tons.
     * @param price      The price per ton.
     * @param percentage The commission percentage.
     * @return The broker commission amount.
     */
    @GetMapping("/broker-commission")
    public ResponseEntity<Double> getBrokerCommission(
            @RequestParam Double amount,
            @RequestParam Double price,
            @RequestParam Double percentage) {

        // Validate inputs
        if (amount == null || price == null || percentage == null ||
                amount < 0 || price < 0 || percentage < 0) {
            return ResponseEntity.badRequest().build();
        }

        // Calculate cargo cost
        Double cargoCost = amount * price;

        // Calculate commission
        Double commission = (cargoCost * percentage) / 100;

        return ResponseEntity.ok(commission);
    }

    /**
     * Calculates the address commission based on the cargo cost and given percentage.
     *
     * @param amount     The amount in tons.
     * @param price      The price per ton.
     * @param percentage The commission percentage.
     * @return The address commission amount.
     */
    @GetMapping("/address-commission")
    public ResponseEntity<Double> getAddressCommission(
            @RequestParam Double amount,
            @RequestParam Double price,
            @RequestParam Double percentage) {

        // Validate inputs
        if (amount == null || price == null || percentage == null ||
                amount < 0 || price < 0 || percentage < 0) {
            return ResponseEntity.badRequest().build();
        }

        // Calculate cargo cost
        Double cargoCost = amount * price;

        // Calculate commission
        Double commission = (cargoCost * percentage) / 100;

        return ResponseEntity.ok(commission);
    }
}
