package com.clearvoyage.shipping_estimator.repositories;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.clearvoyage.shipping_estimator.entities.Port;
import com.clearvoyage.shipping_estimator.services.PortService;





public class PortRepositoryTest {

    @Mock
    private PortRepository portRepository;

    @InjectMocks
    private PortService portService; // Assuming you have a service layer

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        Port port = new Port();
        port.setId(1);
        port.setName("Test Port");

        when(portRepository.findById(1)).thenReturn(Optional.of(port));

        Optional<Port> foundPort = portRepository.findById(1);

        assertTrue(foundPort.isPresent());
        assertEquals("Test Port", foundPort.get().getName());
    }

    @Test
    public void testSavePort() {
        Port port = new Port();
        port.setId(1);
        port.setName("Test Port");

        when(portRepository.save(port)).thenReturn(port);

        Port savedPort = portRepository.save(port);

        assertNotNull(savedPort);
        assertEquals("Test Port", savedPort.getName());
    }

    @Test
    public void testDeletePort() {
        Port port = new Port();
        port.setId(1);
        port.setName("Test Port");

        doNothing().when(portRepository).deleteById(1);

        portRepository.deleteById(1);

        verify(portRepository, times(1)).deleteById(1);
    }
}
