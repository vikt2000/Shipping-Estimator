package com.clearvoyage.shipping_estimator.controllers;

import com.clearvoyage.shipping_estimator.entities.Estimate;
import com.clearvoyage.shipping_estimator.services.EstimateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;




public class EstimateControllerTest {

    @Mock
    private EstimateService estimateService;

    @InjectMocks
    private EstimateController estimateController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testCreateEstimate() {
        Estimate estimate = new Estimate();
        when(estimateService.saveEstimate(any(Estimate.class))).thenReturn(estimate);

        ResponseEntity<Estimate> response = estimateController.createEstimate(estimate);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(estimate, response.getBody());
        verify(estimateService, times(1)).saveEstimate(any(Estimate.class));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testGetEstimateById() {
        Estimate estimate = new Estimate();
        when(estimateService.getEstimateById(anyInt())).thenReturn(Optional.of(estimate));

        ResponseEntity<Estimate> response = estimateController.getEstimateById(1);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(estimate, response.getBody());
        verify(estimateService, times(1)).getEstimateById(anyInt());
    }

    @Test
    public void testGetEstimateById_NotFound() {
        when(estimateService.getEstimateById(anyInt())).thenReturn(Optional.empty());

        ResponseEntity<Estimate> response = estimateController.getEstimateById(1);

        assertEquals(404, response.getStatusCode().value());
        verify(estimateService, times(1)).getEstimateById(anyInt());
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testGetAllEstimates() {
        List<Estimate> estimates = Arrays.asList(new Estimate(), new Estimate());
        when(estimateService.getAllEstimates()).thenReturn(estimates);

        ResponseEntity<List<Estimate>> response = estimateController.getAllEstimates();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(estimates, response.getBody());
        verify(estimateService, times(1)).getAllEstimates();
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testUpdateEstimate() {
        Estimate estimate = new Estimate();
        when(estimateService.updateEstimate(anyInt(), any(Estimate.class))).thenReturn(Optional.of(estimate));

        ResponseEntity<Estimate> response = estimateController.updateEstimate(1, estimate);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(estimate, response.getBody());
        verify(estimateService, times(1)).updateEstimate(anyInt(), any(Estimate.class));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testUpdateEstimate_NotFound() {
        when(estimateService.updateEstimate(anyInt(), any(Estimate.class))).thenReturn(Optional.empty());

        ResponseEntity<Estimate> response = estimateController.updateEstimate(1, new Estimate());

        assertEquals(404, response.getStatusCodeValue());
        verify(estimateService, times(1)).updateEstimate(anyInt(), any(Estimate.class));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testDeleteEstimate() {
        when(estimateService.deleteEstimate(anyInt())).thenReturn(true);

        ResponseEntity<Void> response = estimateController.deleteEstimate(1);

        assertEquals(204, response.getStatusCodeValue());
        verify(estimateService, times(1)).deleteEstimate(anyInt());
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testDeleteEstimate_NotFound() {
        when(estimateService.deleteEstimate(anyInt())).thenReturn(false);

        ResponseEntity<Void> response = estimateController.deleteEstimate(1);

        assertEquals(404, response.getStatusCodeValue());
        verify(estimateService, times(1)).deleteEstimate(anyInt());
    }
}
