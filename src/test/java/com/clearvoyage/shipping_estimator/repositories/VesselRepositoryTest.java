package com.clearvoyage.shipping_estimator.repositories;

import com.clearvoyage.shipping_estimator.entities.Vessel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VesselRepositoryTest {

    @Mock
    private VesselRepository vesselRepository;

    @InjectMocks
    private VesselRepositoryTest vesselRepositoryTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByImo() {
        Long imo = 1234567L;
        Vessel vessel = new Vessel();
        vessel.setImo(imo);

        when(vesselRepository.findByImo(imo)).thenReturn(Optional.of(vessel));

        Optional<Vessel> foundVessel = vesselRepository.findByImo(imo);
        assertTrue(foundVessel.isPresent());
        assertEquals(imo, foundVessel.get().getImo());

        verify(vesselRepository, times(1)).findByImo(imo);
    }

    @Test
    void testFindByNameContainingIgnoreCase() {
        String name = "test";
        Vessel vessel1 = new Vessel();
        vessel1.setName("Test Vessel 1");
        Vessel vessel2 = new Vessel();
        vessel2.setName("Another Test Vessel");

        when(vesselRepository.findByNameContainingIgnoreCase(name)).thenReturn(Arrays.asList(vessel1, vessel2));

        List<Vessel> foundVessels = vesselRepository.findByNameContainingIgnoreCase(name);
        assertEquals(2, foundVessels.size());
        assertTrue(foundVessels.stream().anyMatch(v -> v.getName().equals("Test Vessel 1")));
        assertTrue(foundVessels.stream().anyMatch(v -> v.getName().equals("Another Test Vessel")));

        verify(vesselRepository, times(1)).findByNameContainingIgnoreCase(name);
    }
}
