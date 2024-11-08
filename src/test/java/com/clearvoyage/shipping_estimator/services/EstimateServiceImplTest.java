package com.clearvoyage.shipping_estimator.services;

import com.clearvoyage.shipping_estimator.entities.Cargo;
import com.clearvoyage.shipping_estimator.entities.Estimate;
import com.clearvoyage.shipping_estimator.entities.Vessel;
import com.clearvoyage.shipping_estimator.repositories.CargoRepository;
import com.clearvoyage.shipping_estimator.repositories.EstimateRepository;
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

public class EstimateServiceImplTest {

    @Mock
    private EstimateRepository estimateRepository;

    @Mock
    private CargoRepository cargoRepository;

    @Mock
    private VesselRepository vesselRepository;

    @InjectMocks
    private EstimateServiceImpl estimateService;

    @BeforeEach
    void setUp() {
        // Initialize mocks before each test
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDeleteEstimate() {
        // Arrange: Set up the test data and mock behavior
        Integer estimateId = 1;
        Estimate estimate = new Estimate();
        when(estimateRepository.findById(estimateId)).thenReturn(Optional.of(estimate));

        // Act: Call the method under test
        boolean result = estimateService.deleteEstimate(estimateId);

        // Assert: Verify the results
        assertTrue(result); // Check that the result is true
        verify(estimateRepository, times(1)).delete(estimate); // Verify that the delete method was called once
    }

    @Test
    void testGetAllEstimates() {
        // Arrange: Set up the test data and mock behavior
        List<Estimate> estimates = new ArrayList<>();
        estimates.add(new Estimate());
        when(estimateRepository.findAll()).thenReturn(estimates);

        // Act: Call the method under test
        List<Estimate> result = estimateService.getAllEstimates();

        // Assert: Verify the results
        assertEquals(1, result.size()); // Check that the size of the result list is 1
        verify(estimateRepository, times(1)).findAll(); // Verify that the findAll method was called once
    }

    @Test
    void testGetEstimateById() {
        // Arrange: Set up the test data and mock behavior
        Integer estimateId = 1;
        Estimate estimate = new Estimate();
        when(estimateRepository.findById(estimateId)).thenReturn(Optional.of(estimate));

        // Act: Call the method under test
        Optional<Estimate> result = estimateService.getEstimateById(estimateId);

        // Assert: Verify the results
        assertTrue(result.isPresent()); // Check that the result is present
        assertEquals(estimate, result.get()); // Check that the result matches the expected estimate
        verify(estimateRepository, times(1)).findById(estimateId); // Verify that the findById method was called once
    }

    @Test
    void testSaveEstimate() {
        // Arrange: Set up the test data and mock behavior
        Estimate estimate = new Estimate();
        Cargo cargo = new Cargo();
        cargo.setId(1);
        estimate.setCargo(cargo);
        Vessel vessel = new Vessel();
        vessel.setImo(1234567L);
        estimate.setVessel(vessel);
        when(cargoRepository.findById(1)).thenReturn(Optional.of(cargo));
        when(vesselRepository.findById(1234567L)).thenReturn(Optional.of(vessel));
        when(estimateRepository.save(estimate)).thenReturn(estimate);

        // Act: Call the method under test
        Estimate result = estimateService.saveEstimate(estimate);

        // Assert: Verify the results
        assertEquals(estimate, result); // Check that the result matches the expected estimate
        verify(cargoRepository, times(1)).findById(1); // Verify that the findById method was called once for cargo
        verify(vesselRepository, times(1)).findById(1234567L); // Verify that the findById method was called once for vessel
        verify(estimateRepository, times(1)).save(estimate); // Verify that the save method was called once
    }

    @Test
    void testUpdateEstimate() {
        // Arrange: Set up the test data and mock behavior
        Integer estimateId = 1;
        Estimate existingEstimate = new Estimate();
        Estimate estimateDetails = new Estimate();
        estimateDetails.setWeight(1000.0);
        Cargo cargo = new Cargo();
        cargo.setId(1);
        estimateDetails.setCargo(cargo);
        Vessel vessel = new Vessel();
        vessel.setImo(1234567L);
        estimateDetails.setVessel(vessel);
        when(estimateRepository.findById(estimateId)).thenReturn(Optional.of(existingEstimate));
        when(cargoRepository.findById(1)).thenReturn(Optional.of(cargo));
        when(vesselRepository.findById(1234567L)).thenReturn(Optional.of(vessel));
        when(estimateRepository.save(existingEstimate)).thenReturn(existingEstimate);

        // Act: Call the method under test
        Optional<Estimate> result = estimateService.updateEstimate(estimateId, estimateDetails);

        // Assert: Verify the results
        assertTrue(result.isPresent()); // Check that the result is present
        assertEquals(1000.0, result.get().getWeight()); // Check that the weight of the result matches the expected weight
        verify(estimateRepository, times(1)).findById(estimateId); // Verify that the findById method was called once for estimate
        verify(cargoRepository, times(1)).findById(1); // Verify that the findById method was called once for cargo
        verify(vesselRepository, times(1)).findById(1234567L); // Verify that the findById method was called once for vessel
        verify(estimateRepository, times(1)).save(existingEstimate); // Verify that the save method was called once
    }
}

//testDeleteEstimate
//Arrange Sets up the test data by creating a mock Estimate object and configuring the mock repository to return this object when findById is called.
//Act Calls the deleteEstimate method on the service.
//Assert Verifies that the method returns true and that the delete method on the repository is called exactly once.

//testGetAllEstimates
//Arrange Sets up the test data by creating a list of mock Estimate objects and configuring the mock repository to return this list when findAll is called.
//Act Calls the getAllEstimates method on the service.
//Assert Verifies that the size of the returned list is 1 and that the findAll method on the repository is called exactly once.

//testGetEstimateById
//Arrange Sets up the test data by creating a mock Estimate object and configuring the mock repository to return this object when findById is called.
//Act Calls the getEstimateById method on the service.
//Assert Verifies that the returned Optional contains the expected Estimate and that the findById method on the repository is called exactly once.

//testSaveEstimate
//Arrange Sets up the test data by creating a mock Estimate object with associated Cargo and Vessel objects. Configures the mock repositories to return these objects when findById is called.
//Act Calls the saveEstimate method on the service.
//Assert Verifies that the returned Estimate matches the expected Estimate and that the findById and save methods on the repositories are called exactly once.

//testUpdateEstimate
//Arrange Sets up the test data by creating a mock Estimate object and configuring the mock repository to return this object when findById is called. Also sets up the Cargo and Vessel objects and configures the mock repositories to return these objects when findById is called.
//Act Calls the updateEstimate method on the service.
//Assert Verifies that the returned Optional contains the updated Estimate with the expected weight and that the findById and save methods on the repositories are called exactly once.
