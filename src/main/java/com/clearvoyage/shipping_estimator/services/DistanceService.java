package com.clearvoyage.shipping_estimator.services;

import com.clearvoyage.shipping_estimator.utils.DistanceManager;
import com.clearvoyage.shipping_estimator.utils.VoyageInfo;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    public Double getDistance(String portA, String portB) {
        VoyageInfo voyageInfo = DistanceManager.getVoyageInfo(portA, portB);
        if (voyageInfo != null) {
            return voyageInfo.getDistance();
        } else {
            return null;
        }
    }
}
