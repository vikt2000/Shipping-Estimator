package com.clearvoyage.shipping_estimator.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.clearvoyage.shipping_estimator.entities.Vessel;

public class VesselRepositoryTest {

    @Mock
    private VesselRepository vesselRepository;

    @InjectMocks
    private VesselRepositoryTest vesselRepositoryTest;

    @BeforeEach
    public void setUp() {
        // Initialize mocks before each test
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByImo() {
        // Arrange: Create a mock Vessel object and set its IMO number
        Vessel vessel = new Vessel();
        vessel.setImo(1234567L);
        
        // Mock the behavior of vesselRepository to return the mock Vessel when findByImo is called
        when(vesselRepository.findByImo(1234567L)).thenReturn(Optional.of(vessel));

        // Act: Call the findByImo method on the repository
        Optional<Vessel> foundVessel = vesselRepository.findByImo(1234567L);

        // Assert: Verify that the IMO number of the found Vessel matches the expected IMO number
        assertEquals(1234567L, foundVessel.get().getImo());
    }

    @Test
    public void testFindByNameContainingIgnoreCase() {
        // Arrange: Create a list of mock Vessel objects
        Vessel vessel1 = new Vessel();
        vessel1.setName("Test Vessel");
        Vessel vessel2 = new Vessel();
        vessel2.setName("Another Test Vessel");
        List<Vessel> vessels = new ArrayList<>();
        vessels.add(vessel1);
        vessels.add(vessel2);
        
        // Mock the behavior of vesselRepository to return the list of vessels when findByNameContainingIgnoreCase is called
        when(vesselRepository.findByNameContainingIgnoreCase("test")).thenReturn(vessels);

        // Act: Call the findByNameContainingIgnoreCase method on the repository
        List<Vessel> foundVessels = vesselRepository.findByNameContainingIgnoreCase("test");

        // Assert: Verify that the size of the found vessels list matches the expected size
        assertEquals(2, foundVessels.size());
    }
}

/** Explanation of the Tests:

setUp: Initializes the mocks before each test. This ensures that each test runs with a fresh set of mocks.
testFindByImo:
    Arrange: Sets up the test by creating a mock Vessel object and configuring the mock repository to return this object when findByImo is called.
    Act: Calls the findByImo method on the repository.
    Assert: Checks that the IMO number of the found Vessel matches the expected IMO number.
testFindByNameContainingIgnoreCase:
    Arrange: Sets up the test by creating a list of mock Vessel objects and configuring the mock repository to return this list when findByNameContainingIgnoreCase is called.
    Act: Calls the findByNameContainingIgnoreCase method on the repository.
    Assert: Checks that the size of the found vessels list matches the expected size.*/