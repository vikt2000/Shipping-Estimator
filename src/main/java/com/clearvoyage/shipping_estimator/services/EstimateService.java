package com.clearvoyage.shipping_estimator.services;

import com.clearvoyage.shipping_estimator.entities.Estimate;
import com.clearvoyage.shipping_estimator.utils.VoyageInfo;

import java.util.List;
import java.util.Optional;

public interface EstimateService {

    Double getFuelCostBetweenPorts(String portA, String portB);

    VoyageInfo getVoyageInfoBetweenPorts(String portA, String portB);

    Estimate saveEstimate(Estimate estimate);

    Optional<Estimate> getEstimateById(Integer id);

    List<Estimate> getAllEstimates();

    Optional<Estimate> updateEstimate(Integer id, Estimate estimate);

    boolean deleteEstimate(Integer id);
}
