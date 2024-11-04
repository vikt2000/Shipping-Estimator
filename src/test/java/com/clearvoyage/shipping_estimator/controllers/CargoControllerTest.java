package com.clearvoyage.shipping_estimator.controllers;

import com.clearvoyage.shipping_estimator.entities.Cargo;
import com.clearvoyage.shipping_estimator.services.CargoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

@SuppressWarnings("unused")
@WebMvcTest(CargoController.class)
public class CargoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CargoService cargoService;

    @Test
    void testCreateCargo() throws Exception {
        Cargo cargo = new Cargo(); // Assume appropriate constructor or setters
        cargo.setId(1);

        when(cargoService.saveCargo(any(Cargo.class))).thenReturn(cargo);

        mockMvc.perform(post("/api/cargos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 1}")) // Example JSON payload
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void testGetCargoById() throws Exception {
        Cargo cargo = new Cargo();
        cargo.setId(1);

        when(cargoService.getCargoById(anyInt())).thenReturn(Optional.of(cargo));

        mockMvc.perform(get("/api/cargos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void testGetAllCargos() throws Exception {
        Cargo cargo = new Cargo();
        cargo.setId(1);

        when(cargoService.getAllCargos()).thenReturn(Collections.singletonList(cargo));

        mockMvc.perform(get("/api/cargos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1));
    }

    @Test
    void testUpdateCargo() throws Exception {
        Cargo updatedCargo = new Cargo();
        updatedCargo.setId(1);

        when(cargoService.updateCargo(anyInt(), any(Cargo.class))).thenReturn(Optional.of(updatedCargo));

        mockMvc.perform(put("/api/cargos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 1}")) // Example JSON payload
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void testDeleteCargo() throws Exception {
        when(cargoService.deleteCargo(anyInt())).thenReturn(true);

        mockMvc.perform(delete("/api/cargos/1"))
                .andExpect(status().isNoContent());
    }
}