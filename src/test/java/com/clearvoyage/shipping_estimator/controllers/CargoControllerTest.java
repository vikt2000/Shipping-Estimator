package com.clearvoyage.shipping_estimator.controllers;

import com.clearvoyage.shipping_estimator.entities.Cargo;
import com.clearvoyage.shipping_estimator.services.CargoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CargoController.class) // Annotation to test only the web layer of CargoController
public class CargoControllerTest {

    @Autowired
    private MockMvc mockMvc; // MockMvc to simulate HTTP requests

    @MockBean
    private CargoService cargoService; // MockBean to mock the CargoService

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks before each test
    }

    @Test
    void testCreateCargo() throws Exception {
        Cargo cargo = new Cargo(); // Create a new Cargo object
        cargo.setId(1); // Set the ID of the Cargo

        // Mock the saveCargo method to return the created Cargo
        when(cargoService.saveCargo(any(Cargo.class))).thenReturn(cargo);

        // Perform a POST request to create a new Cargo
        mockMvc.perform(post("/api/cargos")
                .contentType(MediaType.APPLICATION_JSON) // Set content type to JSON
                .content("{\"id\": 1}")) // Example JSON payload
                .andExpect(status().isOk()) // Expect HTTP 200 OK status
                .andExpect(jsonPath("$.id").value(1)); // Expect the returned Cargo to have ID 1
    }

    @Test
    void testGetCargoById() throws Exception {
        Cargo cargo = new Cargo(); // Create a new Cargo object
        cargo.setId(1); // Set the ID of the Cargo

        // Mock the getCargoById method to return the created Cargo
        when(cargoService.getCargoById(anyInt())).thenReturn(Optional.of(cargo));

        // Perform a GET request to retrieve the Cargo by ID
        mockMvc.perform(get("/api/cargos/1"))
                .andExpect(status().isOk()) // Expect HTTP 200 OK status
                .andExpect(jsonPath("$.id").value(1)); // Expect the returned Cargo to have ID 1
    }

    @Test
    void testGetAllCargos() throws Exception {
        Cargo cargo = new Cargo(); // Create a new Cargo object
        cargo.setId(1); // Set the ID of the Cargo

        // Mock the getAllCargos method to return a list containing the created Cargo
        when(cargoService.getAllCargos()).thenReturn(Collections.singletonList(cargo));

        // Perform a GET request to retrieve all Cargos
        mockMvc.perform(get("/api/cargos"))
                .andExpect(status().isOk()) // Expect HTTP 200 OK status
                .andExpect(jsonPath("$[0].id").value(1)); // Expect the first Cargo in the list to have ID 1
    }

    @Test
    void testUpdateCargo() throws Exception {
        Cargo updatedCargo = new Cargo(); // Create a new Cargo object
        updatedCargo.setId(1); // Set the ID of the Cargo

        // Mock the updateCargo method to return the updated Cargo
        when(cargoService.updateCargo(anyInt(), any(Cargo.class))).thenReturn(Optional.of(updatedCargo));

        // Perform a PUT request to update the Cargo
        mockMvc.perform(put("/api/cargos/1")
                .contentType(MediaType.APPLICATION_JSON) // Set content type to JSON
                .content("{\"id\": 1}")) // Example JSON payload
                .andExpect(status().isOk()) // Expect HTTP 200 OK status
                .andExpect(jsonPath("$.id").value(1)); // Expect the returned Cargo to have ID 1
    }

    @Test
    void testDeleteCargo() throws Exception {
        // Mock the deleteCargo method to return true
        when(cargoService.deleteCargo(anyInt())).thenReturn(true);

        // Perform a DELETE request to delete the Cargo by ID
        mockMvc.perform(delete("/api/cargos/1"))
                .andExpect(status().isNoContent()); // Expect HTTP 204 No Content status
    }
}
