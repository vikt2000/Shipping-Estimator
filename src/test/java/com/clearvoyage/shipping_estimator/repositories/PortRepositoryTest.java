package com.clearvoyage.shipping_estimator.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.clearvoyage.shipping_estimator.entities.Port;

public class PortRepositoryTest {

    @Mock
    private PortRepository portRepository;

    @InjectMocks
    private PortRepositoryTest portRepositoryTest;

    @BeforeEach
    public void setUp() {
        // Initialize mocks before each test
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        // Arrange: Create a mock Port object and set its ID
        Port port = new Port();
        port.setId(1);
        
        // Mock the behavior of portRepository to return the mock Port when findById is called
        when(portRepository.findById(1)).thenReturn(Optional.of(port));

        // Act: Call the findById method on the repository
        Optional<Port> foundPort = portRepository.findById(1);

        // Assert: Verify that the ID of the found Port matches the expected ID
        assertEquals(1, foundPort.get().getId());
    }
}
