package com.clearvoyage.shipping_estimator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
}
