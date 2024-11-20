package com.clearvoyage.shipping_estimator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.clearvoyage.shipping_estimator.entities.Cargo;
import com.clearvoyage.shipping_estimator.services.CargoService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cargos")
public class CargoController {

    private final CargoService cargoService;

    @Autowired
    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    /**
     * Creates a new Cargo.
     *
     * @param cargo The cargo to create.
     * @return The created cargo.
     */
    @PostMapping
    public ResponseEntity<Cargo> createCargo(@RequestBody Cargo cargo) {
        Cargo savedCargo = cargoService.saveCargo(cargo);
        return ResponseEntity.ok(savedCargo);
    }

    /**
     * Retrieves a Cargo by its ID.
     *
     * @param id The ID of the cargo.
     * @return The found cargo or 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cargo> getCargoById(@PathVariable Integer id) {
        Optional<Cargo> cargoOpt = cargoService.getCargoById(id);
        return cargoOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Retrieves all Cargos.
     *
     * @return A list of all cargos.
     */
    @GetMapping
    public ResponseEntity<List<Cargo>> getAllCargos() {
        List<Cargo> cargos = cargoService.getAllCargos();
        return ResponseEntity.ok(cargos);
    }

    /**
     * Updates an existing Cargo.
     *
     * @param id    The ID of the cargo to update.
     * @param cargo The cargo data to update.
     * @return The updated cargo or 404 if not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Cargo> updateCargo(@PathVariable Integer id, @RequestBody Cargo cargo) {
        Optional<Cargo> updatedCargoOpt = cargoService.updateCargo(id, cargo);
        return updatedCargoOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Deletes a Cargo by its ID.
     *
     * @param id The ID of the cargo to delete.
     * @return A response indicating the outcome.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCargo(@PathVariable Integer id) {
        boolean isDeleted = cargoService.deleteCargo(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
