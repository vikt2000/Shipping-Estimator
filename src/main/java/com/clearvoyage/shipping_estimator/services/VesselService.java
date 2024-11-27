package com.clearvoyage.shipping_estimator.services;

import com.clearvoyage.shipping_estimator.entities.Vessel;
import java.util.List;
import java.util.Optional;

public interface VesselService {

    Vessel saveVessel(Vessel vessel);

    Optional<Vessel> getVesselByImo(Long imo);

    List<Vessel> getAllVessels();

    Optional<Vessel> updateVessel(Long imo, Vessel vessel);

    boolean deleteVessel(Long imo);
}
