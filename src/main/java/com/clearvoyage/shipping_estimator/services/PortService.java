package com.clearvoyage.shipping_estimator.services;

import com.clearvoyage.shipping_estimator.entities.Port;
import java.util.List;
import java.util.Optional;

public interface PortService {

    Port savePort(Port port);

    Optional<Port> getPortById(Integer id);

    List<Port> getAllPorts();

    Optional<Port> updatePort(Integer id, Port port);

    boolean deletePort(Integer id);
}
