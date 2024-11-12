package com.clearvoyage.shipping_estimator.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AppConfigTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void testRestTemplate() {
        // Verify that the RestTemplate bean is created and injected
        assertNotNull(restTemplate, "RestTemplate should not be null");
    }
}
