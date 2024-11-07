package com.clearvoyage.shipping_estimator.getAndFetchRequest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clearvoyage.shipping_estimator.entities.Cargo;
import com.clearvoyage.shipping_estimator.entities.Estimate;
import com.clearvoyage.shipping_estimator.entities.Port;
import com.clearvoyage.shipping_estimator.entities.Vessel;
import com.clearvoyage.shipping_estimator.services.CargoService;
import com.clearvoyage.shipping_estimator.services.EstimateService;
import com.clearvoyage.shipping_estimator.services.PortService;
import com.clearvoyage.shipping_estimator.services.VesselService;

@RestController
@RequestMapping("/localhost/searoutesapi")
public class DataController {
    @Autowired
    private CargoService cargoservice;
    private EstimateService estimateservice;
    private PortService portservice;
    private VesselService vesselservice;

    @GetMapping("/cargos")
    public List<Cargo> getAllCargos() {
        return cargoservice.getAllCargos();
    }
    @GetMapping("/estimates")
    public List<Estimate> getAllEstimates() {
        return estimateservice.getAllEstimates();
    }
    @GetMapping("/ports")
    public List<Port> getAllPorts() {
        return portservice.getAllPorts();
    }
    @GetMapping("/vessels")
    public List<Vessel> getAllVessels() {
        return vesselservice.getAllVessels();
    }

    @PutMapping("/cargos/{id}") 
    public void updateCargo(@PathVariable Integer id , @RequestBody Cargo cargo) {
        Optional<Cargo> updatedCargo = cargoservice.updateCargo(id, cargo);
    }

}
