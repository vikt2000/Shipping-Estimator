package com.clearvoyage.shipping_estimator.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.clearvoyage.shipping_estimator.entities.Cargo;
import com.clearvoyage.shipping_estimator.services.CargoService;





public class CargoRepositoryTest {

    @Mock
    private CargoRepository cargoRepository;

    @InjectMocks
    private CargoService cargoService; // Assuming you have a service layer

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        Cargo cargo = new Cargo();
        cargo.setId(1);
        cargo.setName("Test Cargo");

        when(cargoRepository.findById(1)).thenReturn(Optional.of(cargo));

        Optional<Cargo> foundCargo = cargoRepository.findById(1);

        assertEquals("Test Cargo", foundCargo.get().getName());
    }

}
