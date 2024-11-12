package com.clearvoyage.shipping_estimator.controllers;

import com.clearvoyage.shipping_estimator.entities.Port;
import com.clearvoyage.shipping_estimator.services.PortService;
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
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class PortControllerTest {

    // Mock the PortService to simulate its behavior
    @Mock
    private PortService portService;

    // Inject the mocked PortService into the PortController
    @InjectMocks
    private PortController portController;

    // Initialize the mocks before each test
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Test for the createPort method
    @Test
    void testCreatePort() {
        Port port = new Port();
        // Simulate the savePort method of PortService
        when(portService.savePort(any(Port.class))).thenReturn(port);

        // Call the createPort method of PortController
        ResponseEntity<Port> response = portController.createPort(port);

        // Verify the response status and body
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(port, response.getBody());
        // Verify that savePort was called once
        verify(portService, times(1)).savePort(port);
    }

    // Test for the deletePort method
    @Test
    void testDeletePort() {
        // Simulate the deletePort method of PortService
        when(portService.deletePort(anyInt())).thenReturn(true);

        // Call the deletePort method of PortController
        ResponseEntity<Void> response = portController.deletePort(1);

        // Verify the response status
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        // Verify that deletePort was called once
        verify(portService, times(1)).deletePort(1);
    }

    // Test for the getAllPorts method
    @Test
    void testGetAllPorts() {
        List<Port> ports = Arrays.asList(new Port(), new Port());
        // Simulate the getAllPorts method of PortService
        when(portService.getAllPorts()).thenReturn(ports);

        // Call the getAllPorts method of PortController
        ResponseEntity<List<Port>> response = portController.getAllPorts();

        // Verify the response status and body
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ports, response.getBody());
        // Verify that getAllPorts was called once
        verify(portService, times(1)).getAllPorts();
    }

    // Test for the getPortById method
    @Test
    void testGetPortById() {
        Port port = new Port();
        // Simulate the getPortById method of PortService
        when(portService.getPortById(anyInt())).thenReturn(Optional.of(port));

        // Call the getPortById method of PortController
        ResponseEntity<Port> response = portController.getPortById(1);

        // Verify the response status and body
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(port, response.getBody());
        // Verify that getPortById was called once
        verify(portService, times(1)).getPortById(1);
    }

    // Test for the updatePort method
    @Test
    void testUpdatePort() {
        Port port = new Port();
        // Simulate the updatePort method of PortService
        when(portService.updatePort(anyInt(), any(Port.class))).thenReturn(Optional.of(port));

        // Call the updatePort method of PortController
        ResponseEntity<Port> response = portController.updatePort(1, port);

        // Verify the response status and body
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(port, response.getBody());
        // Verify that updatePort was called once
        verify(portService, times(1)).updatePort(1, port);
    }
}
