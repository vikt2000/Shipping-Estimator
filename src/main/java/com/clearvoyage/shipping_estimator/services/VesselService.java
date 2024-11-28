package com.clearvoyage.shipping_estimator.services;

import com.clearvoyage.shipping_estimator.entities.Vessel;
import java.util.List;
import java.util.Optional;

public interface VesselService {

    /**
     * Saves a new Vessel to the database.
     *
     * @param vessel The vessel to save.
     * @return The saved vessel.
     */
    Vessel saveVessel(Vessel vessel);

    /**
     * Retrieves a Vessel by its IMO number.
     *
     * @param imo The IMO number of the vessel.
     * @return An Optional containing the found vessel or empty if not found.
     */
    Optional<Vessel> getVesselByImo(Long imo);

    /**
     * Retrieves all Vessels from the database.
     *
     * @return A list of all vessels.
     */
    List<Vessel> getAllVessels();

    /**
     * Updates an existing Vessel.
     *
     * @param imo    The IMO number of the vessel to update.
     * @param vessel The vessel data to update.
     * @return The updated vessel, or Optional.empty() if not found.
     */
    Optional<Vessel> updateVessel(Long imo, Vessel vessel);

    /**
     * Deletes a Vessel by its IMO number.
     *
     * @param imo The IMO number of the vessel to delete.
     * @return True if deletion was successful, false otherwise.
     */
    boolean deleteVessel(Long imo);
}
