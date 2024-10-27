package com.clearvoyage.shipping_estimator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clearvoyage.shipping_estimator.entities.Vessel;
import com.clearvoyage.shipping_estimator.repositories.VesselRepository;
import java.util.List;
import java.util.Optional;

@Service
public class VesselServiceImpl implements VesselService {

    private final VesselRepository vesselRepository;

    @Autowired
    public VesselServiceImpl(VesselRepository vesselRepository) {
        this.vesselRepository = vesselRepository;
    }

    @Override
    public Vessel saveVessel(Vessel vessel) {
        return vesselRepository.save(vessel);
    }

    @Override
    public Optional<Vessel> getVesselByImo(Long imo) {
        return vesselRepository.findByImo(imo);
    }

    @Override
    public List<Vessel> getAllVessels() {
        return vesselRepository.findAll();
    }

    @Override
    public Optional<Vessel> updateVessel(Long imo, Vessel vesselDetails) {
        return vesselRepository.findByImo(imo).map(existingVessel -> {
            existingVessel.setName(vesselDetails.getName());
            existingVessel.setLength(vesselDetails.getLength());
            existingVessel.setWidth(vesselDetails.getWidth());
            existingVessel.setMaxDraft(vesselDetails.getMaxDraft());
            return vesselRepository.save(existingVessel);
        });
    }

    @Override
    public boolean deleteVessel(Long imo) {
        return vesselRepository.findByImo(imo).map(vessel -> {
            vesselRepository.delete(vessel);
            return true;
        }).orElse(false);
    }
}
