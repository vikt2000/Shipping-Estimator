package com.clearvoyage.shipping_estimator.services;

import com.clearvoyage.shipping_estimator.entities.Cargo;
import com.clearvoyage.shipping_estimator.entities.Port;
import com.clearvoyage.shipping_estimator.repositories.CargoRepository;
import com.clearvoyage.shipping_estimator.repositories.PortRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CargoServiceImplTest {

    @Mock
    private CargoRepository cargoRepository;

    @Mock
    private PortRepository portRepository;

    @InjectMocks
    private CargoServiceImpl cargoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDeleteCargo() {
        // Arrange
        Integer cargoId = 1;
        Cargo cargo = new Cargo();
        when(cargoRepository.findById(cargoId)).thenReturn(Optional.of(cargo));

        // Act
        boolean result = cargoService.deleteCargo(cargoId);

        // Assert
        assertTrue(result);
        verify(cargoRepository, times(1)).delete(cargo);
    }

    @Test
    void testGetAllCargos() {
        // Arrange
        List<Cargo> cargos = new ArrayList<>();
        cargos.add(new Cargo());
        when(cargoRepository.findAll()).thenReturn(cargos);

        // Act
        List<Cargo> result = cargoService.getAllCargos();

        // Assert
        assertEquals(1, result.size());
        verify(cargoRepository, times(1)).findAll();
    }

    @Test
    void testGetCargoById() {
        // Arrange
        Integer cargoId = 1;
        Cargo cargo = new Cargo();
        when(cargoRepository.findById(cargoId)).thenReturn(Optional.of(cargo));

        // Act
        Optional<Cargo> result = cargoService.getCargoById(cargoId);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(cargo, result.get());
        verify(cargoRepository, times(1)).findById(cargoId);
    }

    @Test
    void testSaveCargo() {
        // Arrange
        Cargo cargo = new Cargo();
        Port loadingPort = new Port();
        loadingPort.setId(1);
        cargo.setLoadingPort(loadingPort);
        when(portRepository.findById(1)).thenReturn(Optional.of(loadingPort));
        when(cargoRepository.save(cargo)).thenReturn(cargo);

        // Act
        Cargo result = cargoService.saveCargo(cargo);

        // Assert
        assertEquals(cargo, result);
        verify(portRepository, times(1)).findById(1);
        verify(cargoRepository, times(1)).save(cargo);
    }

    @Test
    void testUpdateCargo() {
        // Arrange
        Integer cargoId = 1;
        Cargo existingCargo = new Cargo();
        Cargo cargoDetails = new Cargo();
        cargoDetails.setName("Updated Name");
        Port loadingPort = new Port();
        loadingPort.setId(1);
        cargoDetails.setLoadingPort(loadingPort);
        when(cargoRepository.findById(cargoId)).thenReturn(Optional.of(existingCargo));
        when(portRepository.findById(1)).thenReturn(Optional.of(loadingPort));
        when(cargoRepository.save(existingCargo)).thenReturn(existingCargo);

        // Act
        Optional<Cargo> result = cargoService.updateCargo(cargoId, cargoDetails);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Updated Name", result.get().getName());
        verify(cargoRepository, times(1)).findById(cargoId);
        verify(portRepository, times(1)).findById(1);
        verify(cargoRepository, times(1)).save(existingCargo);
    }
}
