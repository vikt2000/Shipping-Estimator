package com.clearvoyage.shipping_estimator.services;

import com.clearvoyage.shipping_estimator.entities.Cargo;
import java.util.List;
import java.util.Optional;

public interface CargoService {

    /**
     * Saves a new Cargo to the database.
     *
     * @param cargo The cargo to save.
     * @return The saved cargo.
     */
    Cargo saveCargo(Cargo cargo);

    /**
     * Retrieves a Cargo by its ID.
     *
     * @param id The ID of the cargo.
     * @return An Optional containing the found cargo or empty if not found.
     */
    Optional<Cargo> getCargoById(Integer id);

    /**
     * Retrieves all Cargos from the database.
     *
     * @return A list of all cargos.
     */
    List<Cargo> getAllCargos();

    /**
     * Updates an existing Cargo.
     *
     * @param id    The ID of the cargo to update.
     * @param cargo The cargo data to update.
     * @return The updated cargo, or Optional.empty() if not found.
     */
    Optional<Cargo> updateCargo(Integer id, Cargo cargo);

    /**
     * Deletes a Cargo by its ID.
     *
     * @param id The ID of the cargo to delete.
     * @return True if deletion was successful, false otherwise.
     */
    boolean deleteCargo(Integer id);
}
