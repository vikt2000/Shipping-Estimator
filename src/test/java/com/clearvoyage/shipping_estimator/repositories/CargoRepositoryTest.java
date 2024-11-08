package com.clearvoyage.shipping_estimator.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; // Import JUnit 5 Test annotation
import org.mockito.InjectMocks; // Import Mockito InjectMocks annotation
import org.mockito.Mock; // Import Mockito Mock annotation
import org.mockito.MockitoAnnotations; // Import MockitoAnnotations for initializing mocks
import com.clearvoyage.shipping_estimator.entities.Cargo; // Import Cargo entity
import com.clearvoyage.shipping_estimator.services.CargoServiceImpl; // Import CargoServiceImpl service implementation

public class CargoRepositoryTest {

    @Mock
    private CargoRepository cargoRepository; // Mock the CargoRepository

    @InjectMocks
    private CargoServiceImpl cargoService; // Inject the mock into CargoServiceImpl

    @BeforeEach
    public void setUp() {
        // Initialize mocks before each test
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        // Create a new Cargo object and set its properties
        Cargo cargo = new Cargo();
        cargo.setId(1);
        cargo.setName("Test Cargo");

        // Define the behavior of the mocked cargoRepository when findById is called
        when(cargoRepository.findById(1)).thenReturn(Optional.of(cargo));

        // Call the service method to get the cargo by id
        Optional<Cargo> foundCargo = cargoService.getCargoById(1);

        // Assert that the name of the found cargo is "Test Cargo"
        assertEquals("Test Cargo", foundCargo.get().getName());
    }
}
