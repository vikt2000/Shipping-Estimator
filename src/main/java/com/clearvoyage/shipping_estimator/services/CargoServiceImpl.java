package com.clearvoyage.shipping_estimator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;  // Import the Transactional annotation
import com.clearvoyage.shipping_estimator.entities.Cargo;
import com.clearvoyage.shipping_estimator.entities.Port; // Assuming Port is the entity class for LoadingPort and DischargePort
import com.clearvoyage.shipping_estimator.repositories.CargoRepository;
import com.clearvoyage.shipping_estimator.repositories.PortRepository; // Import the Port repository
import java.util.NoSuchElementException; // Import this

import java.util.List;
import java.util.Optional;

@Service
public class CargoServiceImpl implements CargoService {

    private final CargoRepository cargoRepository;
    private final PortRepository portRepository;

    @Autowired
    public CargoServiceImpl(CargoRepository cargoRepository, PortRepository portRepository) {
        this.cargoRepository = cargoRepository;
        this.portRepository = portRepository;
    }

    @Override
    @Transactional
    public Cargo saveCargo(Cargo cargo) {
        if (cargo.getLoadingPort() != null) {
            Port loadingPort = portRepository.findById(cargo.getLoadingPort().getId())
                .orElseThrow(() -> new NoSuchElementException("Loading Port not found"));
            cargo.setLoadingPort(loadingPort);
        }
        if (cargo.getDischargePort() != null) {
            Port dischargePort = portRepository.findById(cargo.getDischargePort().getId())
                .orElseThrow(() -> new NoSuchElementException("Discharge Port not found"));
            cargo.setDischargePort(dischargePort);
        }
    
        return cargoRepository.save(cargo); 
    }

    @Override
    public Optional<Cargo> getCargoById(Integer id) {
        return cargoRepository.findById(id);
    }

    @Override
    public List<Cargo> getAllCargos() {
        return cargoRepository.findAll();
    }

    @Override
    public Optional<Cargo> updateCargo(Integer id, Cargo cargoDetails) {
        return cargoRepository.findById(id).map(existingCargo -> {
            existingCargo.setName(cargoDetails.getName());

            if (cargoDetails.getLoadingPort() != null) {
                Port loadingPort = portRepository.findById(cargoDetails.getLoadingPort().getId())
                    .orElseThrow(() -> new NoSuchElementException("Loading Port not found"));
                existingCargo.setLoadingPort(loadingPort);
            }
            if (cargoDetails.getDischargePort() != null) {
                Port dischargePort = portRepository.findById(cargoDetails.getDischargePort().getId())
                    .orElseThrow(() -> new NoSuchElementException("Discharge Port not found"));
                existingCargo.setDischargePort(dischargePort);
            }
    
            existingCargo.setQuantity(cargoDetails.getQuantity());
            existingCargo.setUnit(cargoDetails.getUnit());
            existingCargo.setWeight(cargoDetails.getWeight());
            return cargoRepository.save(existingCargo);
        });
    }

    @Override
    public boolean deleteCargo(Integer id) {
        return cargoRepository.findById(id).map(cargo -> {
            cargoRepository.delete(cargo);
            return true;
        }).orElse(false);
    }
}
