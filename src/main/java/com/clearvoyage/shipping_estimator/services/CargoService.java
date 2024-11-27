package com.clearvoyage.shipping_estimator.services;

import com.clearvoyage.shipping_estimator.entities.Cargo;
import java.util.List;
import java.util.Optional;

public interface CargoService {

    Cargo saveCargo(Cargo cargo);

    Optional<Cargo> getCargoById(Integer id);

    List<Cargo> getAllCargos();

    Optional<Cargo> updateCargo(Integer id, Cargo cargo);

    boolean deleteCargo(Integer id);
}
