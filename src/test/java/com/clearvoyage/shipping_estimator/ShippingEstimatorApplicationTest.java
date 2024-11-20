package com.clearvoyage.shipping_estimator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class ShippingEstimatorApplicationTest {

    @Test
    void testMain() {
        assertDoesNotThrow(() -> ShippingEstimatorApplication.main(new String[] {}));
    }

    @Test
    void contextLoads() {
        // This test will automatically fail if the application context cannot start
    }
}
