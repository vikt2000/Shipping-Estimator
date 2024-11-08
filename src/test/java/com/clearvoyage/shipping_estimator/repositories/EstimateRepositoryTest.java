package com.clearvoyage.shipping_estimator.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.clearvoyage.shipping_estimator.entities.Estimate;

public class EstimateRepositoryTest {

    @Mock
    private EstimateRepository estimateRepository;

    @InjectMocks
    private EstimateRepositoryTest estimateRepositoryTest;

    @BeforeEach
    public void setUp() {
        // Initialize mocks before each test
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        // Arrange: Create a mock Estimate object and set its ID
        Estimate estimate = new Estimate();
        estimate.setId(1);
        
        // Mock the behavior of estimateRepository to return the mock Estimate when findById is called
        when(estimateRepository.findById(1)).thenReturn(Optional.of(estimate));

        // Act: Call the findById method on the repository
        Optional<Estimate> foundEstimate = estimateRepository.findById(1);

        // Assert: Verify that the ID of the found Estimate matches the expected ID
        assertEquals(1, foundEstimate.get().getId());
    }
}
