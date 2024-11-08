package com.clearvoyage.shipping_estimator.services;

import com.clearvoyage.shipping_estimator.entities.Port;
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

public class PortServiceImplTest {

    @Mock
    private PortRepository portRepository;

    @InjectMocks
    private PortServiceImpl portService;

    @BeforeEach
    void setUp() {
        // Initialize mocks before each test
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDeletePort() {
        // Arrange: Set up the test data and mock behavior
        Integer portId = 1;
        Port port = new Port();
        when(portRepository.findById(portId)).thenReturn(Optional.of(port));

        // Act: Call the method under test
        boolean result = portService.deletePort(portId);

        // Assert: Verify the results
        assertTrue(result); // Check that the result is true
        verify(portRepository, times(1)).delete(port); // Verify that the delete method was called once
    }

    @Test
    void testGetAllPorts() {
        // Arrange: Set up the test data and mock behavior
        List<Port> ports = new ArrayList<>();
        ports.add(new Port());
        when(portRepository.findAll()).thenReturn(ports);

        // Act: Call the method under test
        List<Port> result = portService.getAllPorts();

        // Assert: Verify the results
        assertEquals(1, result.size()); // Check that the size of the result list is 1
        verify(portRepository, times(1)).findAll(); // Verify that the findAll method was called once
    }

    @Test
    void testGetPortById() {
        // Arrange: Set up the test data and mock behavior
        Integer portId = 1;
        Port port = new Port();
        when(portRepository.findById(portId)).thenReturn(Optional.of(port));

        // Act: Call the method under test
        Optional<Port> result = portService.getPortById(portId);

        // Assert: Verify the results
        assertTrue(result.isPresent()); // Check that the result is present
        assertEquals(port, result.get()); // Check that the result matches the expected port
        verify(portRepository, times(1)).findById(portId); // Verify that the findById method was called once
    }

    @Test
    void testSavePort() {
        // Arrange: Set up the test data and mock behavior
        Port port = new Port();
        when(portRepository.save(port)).thenReturn(port);

        // Act: Call the method under test
        Port result = portService.savePort(port);

        // Assert: Verify the results
        assertEquals(port, result); // Check that the result matches the expected port
        verify(portRepository, times(1)).save(port); // Verify that the save method was called once
    }

    @Test
    void testUpdatePort() {
        // Arrange: Set up the test data and mock behavior
        Integer portId = 1;
        Port existingPort = new Port();
        Port portDetails = new Port();
        portDetails.setName("Updated Name");
        portDetails.setLatitude(10.0);
        portDetails.setLongitude(20.0);
        when(portRepository.findById(portId)).thenReturn(Optional.of(existingPort));
        when(portRepository.save(existingPort)).thenReturn(existingPort);

        // Act: Call the method under test
        Optional<Port> result = portService.updatePort(portId, portDetails);

        // Assert: Verify the results
        assertTrue(result.isPresent()); // Check that the result is present
        assertEquals("Updated Name", result.get().getName()); // Check that the name of the result matches the expected name
        assertEquals(10.0, result.get().getLatitude()); // Check that the latitude of the result matches the expected latitude
        assertEquals(20.0, result.get().getLongitude()); // Check that the longitude of the result matches the expected longitude
        verify(portRepository, times(1)).findById(portId); // Verify that the findById method was called once
        verify(portRepository, times(1)).save(existingPort); // Verify that the save method was called once
    }
}
