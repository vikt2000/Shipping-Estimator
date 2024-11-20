package com.clearvoyage.shipping_estimator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clearvoyage.shipping_estimator.entities.Estimate;

public interface EstimateRepository extends JpaRepository<Estimate, Integer> {
    // Additional custom query methods can be defined here if needed
}
