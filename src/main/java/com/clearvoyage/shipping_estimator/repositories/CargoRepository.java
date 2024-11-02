package com.clearvoyage.shipping_estimator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clearvoyage.shipping_estimator.entities.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {
    // Additional query methods if needed
}
