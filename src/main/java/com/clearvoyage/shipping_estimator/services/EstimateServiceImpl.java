package com.clearvoyage.shipping_estimator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clearvoyage.shipping_estimator.entities.Estimate;
import com.clearvoyage.shipping_estimator.repositories.EstimateRepository;
import java.util.List;
import java.util.Optional;

@Service
public class EstimateServiceImpl implements EstimateService {

    private final EstimateRepository estimateRepository;

    @Autowired
    public EstimateServiceImpl(EstimateRepository estimateRepository) {
        this.estimateRepository = estimateRepository;
    }

    @Override
    public Estimate saveEstimate(Estimate estimate) {
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
            existingEstimate.setCargo(estimateDetails.getCargo());
            existingEstimate.setVessel(estimateDetails.getVessel());
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
