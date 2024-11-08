package com.clearvoyage.shipping_estimator.services;

import com.clearvoyage.shipping_estimator.entities.Vessel;
import com.clearvoyage.shipping_estimator.repositories.VesselRepository;
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

public class VesselServiceImplTest {

    @Mock
    private VesselRepository vesselRepository;

    @InjectMocks
    private VesselServiceImpl vesselService;

    @BeforeEach
    void setUp() {
        // Initialize mocks before each test
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDeleteVessel() {
        // Arrange: Set up the test data and mock behavior
        Long vesselImo = 1234567L;
        Vessel vessel = new Vessel();
        when(vesselRepository.findByImo(vesselImo)).thenReturn(Optional.of(vessel));

        // Act: Call the method under test
        boolean result = vesselService.deleteVessel(vesselImo);

        // Assert: Verify the results
        assertTrue(result); // Check that the result is true
        verify(vesselRepository, times(1)).delete(vessel); // Verify that the delete method was called once
    }

    @Test
    void testGetAllVessels() {
        // Arrange: Set up the test data and mock behavior
        List<Vessel> vessels = new ArrayList<>();
        vessels.add(new Vessel());
        when(vesselRepository.findAll()).thenReturn(vessels);

        // Act: Call the method under test
        List<Vessel> result = vesselService.getAllVessels();

        // Assert: Verify the results
        assertEquals(1, result.size()); // Check that the size of the result list is 1
        verify(vesselRepository, times(1)).findAll(); // Verify that the findAll method was called once
    }

    @Test
    void testGetVesselByImo() {
        // Arrange: Set up the test data and mock behavior
        Long vesselImo = 1234567L;
        Vessel vessel = new Vessel();
        when(vesselRepository.findByImo(vesselImo)).thenReturn(Optional.of(vessel));

        // Act: Call the method under test
        Optional<Vessel> result = vesselService.getVesselByImo(vesselImo);

        // Assert: Verify the results
        assertTrue(result.isPresent()); // Check that the result is present
        assertEquals(vessel, result.get()); // Check that the result matches the expected vessel
        verify(vesselRepository, times(1)).findByImo(vesselImo); // Verify that the findByImo method was called once
    }

    @Test
    void testSaveVessel() {
        // Arrange: Set up the test data and mock behavior
        Vessel vessel = new Vessel();
        when(vesselRepository.save(vessel)).thenReturn(vessel);

        // Act: Call the method under test
        Vessel result = vesselService.saveVessel(vessel);

        // Assert: Verify the results
        assertEquals(vessel, result); // Check that the result matches the expected vessel
        verify(vesselRepository, times(1)).save(vessel); // Verify that the save method was called once
    }

    @Test
    void testUpdateVessel() {
        // Arrange: Set up the test data and mock behavior
        Long vesselImo = 1234567L;
        Vessel existingVessel = new Vessel();
        Vessel vesselDetails = new Vessel();
        vesselDetails.setName("Updated Name");
        vesselDetails.setLength(300.0);
        vesselDetails.setWidth(50.0);
        vesselDetails.setMaxDraft(15.0);
        when(vesselRepository.findByImo(vesselImo)).thenReturn(Optional.of(existingVessel));
        when(vesselRepository.save(existingVessel)).thenReturn(existingVessel);

        // Act: Call the method under test
        Optional<Vessel> result = vesselService.updateVessel(vesselImo, vesselDetails);

        // Assert: Verify the results
        assertTrue(result.isPresent()); // Check that the result is present
        assertEquals("Updated Name", result.get().getName()); // Check that the name of the result matches the expected name
        assertEquals(300.0, result.get().getLength()); // Check that the length of the result matches the expected length
        assertEquals(50.0, result.get().getWidth()); // Check that the width of the result matches the expected width
        assertEquals(15.0, result.get().getMaxDraft()); // Check that the max draft of the result matches the expected max draft
        verify(vesselRepository, times(1)).findByImo(vesselImo); // Verify that the findByImo method was called once
        verify(vesselRepository, times(1)).save(existingVessel); // Verify that the save method was called once
    }
}
