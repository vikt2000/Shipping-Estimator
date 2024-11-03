import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShippingControllerTest {
    @Mock
    private ShippingService shippingService;

    @InjectMocks
    private ShippingController shippingController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateShipping() {
        // Arrange
        when(shippingService.calculateShipping("departure", "arrival", "vesselType", 100.0)).thenReturn("Calculated shipping cost");

        // Act
        String response = shippingController.calculateShipping("departure", "arrival", "vesselType", 100.0);

        // Assert
        assertEquals("Calculated shipping cost", response);
        verify(shippingService).calculateShipping("departure", "arrival", "vesselType", 100.0);
    }
}
