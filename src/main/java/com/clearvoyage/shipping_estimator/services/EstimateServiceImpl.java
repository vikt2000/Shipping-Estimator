package com.clearvoyage.shipping_estimator.services;

import com.clearvoyage.shipping_estimator.utils.DistanceManager;
import com.clearvoyage.shipping_estimator.utils.VoyageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.clearvoyage.shipping_estimator.entities.Estimate;
import com.clearvoyage.shipping_estimator.entities.Cargo;
import com.clearvoyage.shipping_estimator.entities.Vessel;
import com.clearvoyage.shipping_estimator.repositories.EstimateRepository;
import com.clearvoyage.shipping_estimator.repositories.CargoRepository;
import com.clearvoyage.shipping_estimator.repositories.VesselRepository;
import java.util.NoSuchElementException; // Import this

import java.util.List;
import java.util.Optional;

@Service
public class EstimateServiceImpl implements EstimateService {

    private final EstimateRepository estimateRepository;
    private final CargoRepository cargoRepository;
    private final VesselRepository vesselRepository;

    @Autowired
    public EstimateServiceImpl(EstimateRepository estimateRepository,
                               CargoRepository cargoRepository,
                               VesselRepository vesselRepository) {
        this.estimateRepository = estimateRepository;
        this.cargoRepository = cargoRepository;
        this.vesselRepository = vesselRepository;
    }

    public Double getFuelCostBetweenPorts(String portA, String portB) {
        Double fuelCost = FuelCostCalculator.calculateFuelCost(portA, portB);

        if (fuelCost != null) {
            return fuelCost;
        } else {
            throw new IllegalArgumentException("Voyage information between the specified ports is not available.");
        }
    }

    public VoyageInfo getVoyageInfoBetweenPorts(String portA, String portB) {
        VoyageInfo voyageInfo = DistanceManager.getVoyageInfo(portA, portB);

        if (voyageInfo != null) {
            return voyageInfo;
        } else {
            throw new IllegalArgumentException("Voyage information between the specified ports is not available.");
        }
    }

    @Override
    @Transactional
    public Estimate saveEstimate(Estimate estimate) {
        // Validate and fetch associated entities
        if (estimate.getCargo() != null) {
            Cargo cargo = cargoRepository.findById(estimate.getCargo().getId())
                    .orElseThrow(() -> new NoSuchElementException("Cargo not found"));
            estimate.setCargo(cargo);
        }

        if (estimate.getVessel() != null) {
            Vessel vessel = vesselRepository.findById(estimate.getVessel().getImo())
                    .orElseThrow(() -> new NoSuchElementException("Vessel not found"));
            estimate.setVessel(vessel);
        }

        return estimateRepository.save(estimate);
    }

    @Override
    public Optional<Estimate> getEstimateById(Integer id) {
        return estimateRepository.findById(id);
    }

    @Override
    public List<Estimate> getAllEstimates() {
        return estimateRepository.findAll();
    }

    @Override
    public Optional<Estimate> updateEstimate(Integer id, Estimate estimateDetails) {
        return estimateRepository.findById(id).map(existingEstimate -> {
            // Validate and fetch associated entities
            if (estimateDetails.getCargo() != null) {
                Cargo cargo = cargoRepository.findById(estimateDetails.getCargo().getId())
                        .orElseThrow(() -> new NoSuchElementException("Cargo not found"));
                existingEstimate.setCargo(cargo);
            }

            if (estimateDetails.getVessel() != null) {
                Vessel vessel = vesselRepository.findById(estimateDetails.getVessel().getImo())
                        .orElseThrow(() -> new NoSuchElementException("Vessel not found"));
                existingEstimate.setVessel(vessel);
            }

            existingEstimate.setWeight(estimateDetails.getWeight());
            return estimateRepository.save(existingEstimate);
        });
    }

    @Override
    public boolean deleteEstimate(Integer id) {
        return estimateRepository.findById(id).map(estimate -> {
            estimateRepository.delete(estimate);
            return true;
        }).orElse(false);
    }
}
