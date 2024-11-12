package com.clearvoyage.shipping_estimator.controllers;

import com.clearvoyage.shipping_estimator.service.SeaRoutesApiClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.anyString;

@WebFluxTest(controllers = SeaRoutesController.class)
public class SeaRoutesControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private SeaRoutesApiClient seaRoutesApiClient;

    @Test
    void testTestSeaRoutes() {
        // Mock the response from SeaRoutesApiClient
        Mockito.when(seaRoutesApiClient.fetchSeaRoutesData(anyString(), anyString(), anyString(), anyString()))
                .thenReturn(Mono.just("Mocked Sea Routes Data"));

        // Perform the GET request and verify the response
        webTestClient.get().uri("/api/sea-routes/test-searoutes")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Mocked Sea Routes Data");
    }
}
