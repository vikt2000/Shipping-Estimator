package com.clearvoyage.shipping_estimator.services;

import com.clearvoyage.shipping_estimator.utils.DistanceManager;
import com.clearvoyage.shipping_estimator.utils.VoyageInfo;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    /**
     * Retrieves the distance between two ports.
     *
     * @param portA The name of the first port.
     * @param portB The name of the second port.
     * @return The distance in nautical miles, or null if not found.
     */
    public Double getDistance(String portA, String portB) {
        VoyageInfo voyageInfo = DistanceManager.getVoyageInfo(portA, portB);
        if (voyageInfo != null) {
            return voyageInfo.getDistance();
        } else {
            return null;
        }
    }
}
