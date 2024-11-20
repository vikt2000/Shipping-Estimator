package com.clearvoyage.shipping_estimator.dataloader;

import com.clearvoyage.shipping_estimator.entities.Cargo;
import com.clearvoyage.shipping_estimator.entities.Estimate;
import com.clearvoyage.shipping_estimator.entities.Port;
import com.clearvoyage.shipping_estimator.entities.Vessel;
import com.clearvoyage.shipping_estimator.services.CargoService;
import com.clearvoyage.shipping_estimator.services.EstimateService;
import com.clearvoyage.shipping_estimator.services.PortService;
import com.clearvoyage.shipping_estimator.services.VesselService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CargoService cargoService;
    private final PortService portService ;
    private final EstimateService estimateService;
    private final VesselService vesselService;


    @Autowired
    public DataLoader(CargoService cargoService, PortService portService, EstimateService estimateService, VesselService vesselService) {
        this.cargoService = cargoService;
        this.portService = portService;
        this.estimateService = estimateService;
        this.vesselService = vesselService;

    }

    @Override
    public void run(String... args) throws Exception {
        // Create some sample Ports
        Port port1 = new Port(null, "Port of Los Angeles", 2100.215, 57751.365);
        Port port2 = new Port(null, "Port of New York", 54561.2156, 5485.264);
        portService.savePort(port1);
        portService.savePort(port2);

        // Create some sample Cargos
        Cargo cargo1 = new Cargo(null, "Electronics", port1, port2, 1000, "pcs", 1200.0);
        Cargo cargo2 = new Cargo(null, "Furniture", port2, port1, 500, "pcs", 2500.0);
        cargoService.saveCargo(cargo1);
        cargoService.saveCargo(cargo2);

        // Create and save a sample Vessel
        Vessel vessel1 = new Vessel((9223372036854775807L), "Cargo Ship 1", 2500.0, 500.0, 200.0);
        vesselService.saveVessel(vessel1);

        // Create and save an Estimate
        Estimate estimate1 = new Estimate(null, cargo1, vessel1, 1200.0);
        estimateService.saveEstimate(estimate1);

        // Optional: You could also create more instances of each entity as


    }
}
