import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EstimateTest {
    @Mock
    private EstimateService estimateService;

    @InjectMocks
    private EstimateController estimateController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetEstimate() {
        // Arrange
        Estimate expectedEstimate = new Estimate("123", "Estimate A", 100);
        when(estimateService.getEstimate("123")).thenReturn(expectedEstimate);

        // Act
        Estimate actualEstimate = estimateController.getEstimate("123");

        // Assert
        assertEquals(expectedEstimate, actualEstimate);
        verify(estimateService).getEstimate("123");
    }
}
