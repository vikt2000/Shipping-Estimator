package com.clearvoyage.shipping_estimator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clearvoyage.shipping_estimator.entities.Port;
import com.clearvoyage.shipping_estimator.repositories.PortRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PortServiceImpl implements PortService {

    private final PortRepository portRepository;

    @Autowired
    public PortServiceImpl(PortRepository portRepository) {
        this.portRepository = portRepository;
    }

    @Override
    public Port savePort(Port port) {
        return portRepository.save(port);
    }

    @Override
    public Optional<Port> getPortById(Integer id) {
        return portRepository.findById(id);
    }

    @Override
    public List<Port> getAllPorts() {
        return portRepository.findAll();
    }

    @Override
    public Optional<Port> updatePort(Integer id, Port portDetails) {
        return portRepository.findById(id).map(existingPort -> {
            existingPort.setName(portDetails.getName());
            existingPort.setLatitude(portDetails.getLatitude());
            existingPort.setLongitude(portDetails.getLongitude());
            return portRepository.save(existingPort);
        });
    }

    @Override
    public boolean deletePort(Integer id) {
        return portRepository.findById(id).map(port -> {
            portRepository.delete(port);
            return true;
        }).orElse(false);
    }
}
