package com.clearvoyage.shipping_estimator.services;

import com.clearvoyage.shipping_estimator.entities.Estimate;
import java.util.List;
import java.util.Optional;

public interface EstimateService {

    /**
     * Saves a new Estimate to the database.
     *
     * @param estimate The estimate to save.
     * @return The saved estimate.
     */
    Estimate saveEstimate(Estimate estimate);

    /**
     * Retrieves an Estimate by its ID.
     *
     * @param id The ID of the estimate.
     * @return An Optional containing the found estimate or empty if not found.
     */
    Optional<Estimate> getEstimateById(Integer id);

    /**
     * Retrieves all Estimates from the database.
     *
     * @return A list of all estimates.
     */
    List<Estimate> getAllEstimates();

    /**
     * Updates an existing Estimate.
     *
     * @param id       The ID of the estimate to update.
     * @param estimate The estimate data to update.
     * @return The updated estimate, or Optional.empty() if not found.
     */
    Optional<Estimate> updateEstimate(Integer id, Estimate estimate);

    /**
     * Deletes an Estimate by its ID.
     *
     * @param id The ID of the estimate to delete.
     * @return True if deletion was successful, false otherwise.
     */
    boolean deleteEstimate(Integer id);
}