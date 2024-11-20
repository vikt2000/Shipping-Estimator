package com.clearvoyage.shipping_estimator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.clearvoyage.shipping_estimator.entities.Vessel;
import com.clearvoyage.shipping_estimator.services.VesselService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vessels")
public class VesselController {

    private final VesselService vesselService;

    @Autowired
    public VesselController(VesselService vesselService) {
        this.vesselService = vesselService;
    }

    /**
     * Creates a new Vessel.
     *
     * @param vessel The vessel to create.
     * @return The created vessel.
     */
    @PostMapping
    public ResponseEntity<Vessel> createVessel(@RequestBody Vessel vessel) {
        Vessel savedVessel = vesselService.saveVessel(vessel);
        return ResponseEntity.ok(savedVessel);
    }

    /**
     * Retrieves a Vessel by its IMO number.
     *
     * @param imo The IMO number of the vessel.
     * @return The found vessel or 404 if not found.
     */
    @GetMapping("/{imo}")
    public ResponseEntity<Vessel> getVesselByImo(@PathVariable Long imo) {
        Optional<Vessel> vesselOpt = vesselService.getVesselByImo(imo);
        return vesselOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Retrieves all Vessels.
     *
     * @return A list of all vessels.
     */
    @GetMapping
    public ResponseEntity<List<Vessel>> getAllVessels() {
        List<Vessel> vessels = vesselService.getAllVessels();
        return ResponseEntity.ok(vessels);
    }

    /**
     * Updates an existing Vessel.
     *
     * @param imo    The IMO number of the vessel to update.
     * @param vessel The vessel data to update.
     * @return The updated vessel or 404 if not found.
     */
    @PutMapping("/{imo}")
    public ResponseEntity<Vessel> updateVessel(@PathVariable Long imo, @RequestBody Vessel vessel) {
        Optional<Vessel> updatedVesselOpt = vesselService.updateVessel(imo, vessel);
        return updatedVesselOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Deletes a Vessel by its IMO number.
     *
     * @param imo The IMO number of the vessel to delete.
     * @return A response indicating the outcome.
     */
    @DeleteMapping("/{imo}")
    public ResponseEntity<Void> deleteVessel(@PathVariable Long imo) {
        boolean isDeleted = vesselService.deleteVessel(imo);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
