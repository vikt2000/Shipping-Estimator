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
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        Estimate estimate = new Estimate();
        estimate.setId(1);
        when(estimateRepository.findById(1)).thenReturn(Optional.of(estimate));

        Optional<Estimate> foundEstimate = estimateRepository.findById(1);
        assertEquals(1, foundEstimate.get().getId());
    }

}
