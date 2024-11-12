package com.clearvoyage.shipping_estimator.controllers;

import com.clearvoyage.shipping_estimator.entities.Vessel;
import com.clearvoyage.shipping_estimator.services.VesselService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class VesselControllerTest {

    // Mock the VesselService to simulate its behavior
    @Mock
    private VesselService vesselService;

    // Inject the mocked VesselService into the VesselController
    @InjectMocks
    private VesselController vesselController;

    // Initialize the mocks before each test
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Test for the createVessel method
    @Test
    void testCreateVessel() {
        Vessel vessel = new Vessel();
        // Simulate the saveVessel method of VesselService
        when(vesselService.saveVessel(any(Vessel.class))).thenReturn(vessel);

        // Call the createVessel method of VesselController
        ResponseEntity<Vessel> response = vesselController.createVessel(vessel);

        // Verify the response status and body
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(vessel, response.getBody());
        // Verify that saveVessel was called once
        verify(vesselService, times(1)).saveVessel(vessel);
    }

    // Test for the deleteVessel method
    @Test
    void testDeleteVessel() {
        // Simulate the deleteVessel method of VesselService
        when(vesselService.deleteVessel(anyLong())).thenReturn(true);

        // Call the deleteVessel method of VesselController
        ResponseEntity<Void> response = vesselController.deleteVessel(1L);

        // Verify the response status
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        // Verify that deleteVessel was called once
        verify(vesselService, times(1)).deleteVessel(1L);
    }

    // Test for the getAllVessels method
    @Test
    void testGetAllVessels() {
        List<Vessel> vessels = Arrays.asList(new Vessel(), new Vessel());
        // Simulate the getAllVessels method of VesselService
        when(vesselService.getAllVessels()).thenReturn(vessels);

        // Call the getAllVessels method of VesselController
        ResponseEntity<List<Vessel>> response = vesselController.getAllVessels();

        // Verify the response status and body
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(vessels, response.getBody());
        // Verify that getAllVessels was called once
        verify(vesselService, times(1)).getAllVessels();
    }

    // Test for the getVesselByImo method
    @Test
    void testGetVesselByImo() {
        Vessel vessel = new Vessel();
        // Simulate the getVesselByImo method of VesselService
        when(vesselService.getVesselByImo(anyLong())).thenReturn(Optional.of(vessel));

        // Call the getVesselByImo method of VesselController
        ResponseEntity<Vessel> response = vesselController.getVesselByImo(1L);

        // Verify the response status and body
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(vessel, response.getBody());
        // Verify that getVesselByImo was called once
        verify(vesselService, times(1)).getVesselByImo(1L);
    }

    // Test for the updateVessel method
    @Test
    void testUpdateVessel() {
        Vessel vessel = new Vessel();
        // Simulate the updateVessel method of VesselService
        when(vesselService.updateVessel(anyLong(), any(Vessel.class))).thenReturn(Optional.of(vessel));

        // Call the updateVessel method of VesselController
        ResponseEntity<Vessel> response = vesselController.updateVessel(1L, vessel);

        // Verify the response status and body
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(vessel, response.getBody());
        // Verify that updateVessel was called once
        verify(vesselService, times(1)).updateVessel(1L, vessel);
    }
}
