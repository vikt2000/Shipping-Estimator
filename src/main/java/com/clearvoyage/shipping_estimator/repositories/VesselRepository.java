package com.clearvoyage.shipping_estimator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clearvoyage.shipping_estimator.entities.Vessel;

import java.util.List;
import java.util.Optional;

public interface VesselRepository extends JpaRepository<Vessel, Long> {

    /**
     * Finds a vessel by its IMO number.
     *
     * @param imo The IMO number of the vessel.
     * @return An Optional containing the found vessel or empty if not found.
     */
    Optional<Vessel> findByImo(Long imo);

    /**
     * Finds vessels by name containing the specified substring (case-insensitive).
     *
     * @param name The substring to search for in vessel names.
     * @return A list of matching vessels.
     */
    List<Vessel> findByNameContainingIgnoreCase(String name);
}
