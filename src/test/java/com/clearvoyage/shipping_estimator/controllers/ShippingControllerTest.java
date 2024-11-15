package com.clearvoyage.shipping_estimator.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShippingControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCalculateShipping() {
        String departure = "New York";
        String arrival = "Los Angeles";
        String vesselType = "Cargo";
        double weight = 1000;

        String url = String.format("/api/shipping/calculate?departure=%s&arrival=%s&vesselType=%s&weight=%f",
                departure, arrival, vesselType, weight);

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println("TEST111"+response.getStatusCode());
        //assertEquals(200, response.getStatusCode());

        //assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo("Calculated shipping cost");
    }
}
