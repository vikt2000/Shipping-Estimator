package com.clearvoyage.shipping_estimator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clearvoyage.shipping_estimator.entities.Cargo;
import com.clearvoyage.shipping_estimator.repositories.CargoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CargoServiceImpl implements CargoService {

    private final CargoRepository cargoRepository;

    @Autowired
    public CargoServiceImpl(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    public Cargo saveCargo(Cargo cargo) {
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
            existingCargo.setLoadingPort(cargoDetails.getLoadingPort());
            existingCargo.setDischargePort(cargoDetails.getDischargePort());
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
