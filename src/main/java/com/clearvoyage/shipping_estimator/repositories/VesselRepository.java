package com.clearvoyage.shipping_estimator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clearvoyage.shipping_estimator.entities.Vessel;

import java.util.List;
import java.util.Optional;

public interface VesselRepository extends JpaRepository<Vessel, Long> {


    Optional<Vessel> findByImo(Long imo);

    List<Vessel> findByNameContainingIgnoreCase(String name);
}
