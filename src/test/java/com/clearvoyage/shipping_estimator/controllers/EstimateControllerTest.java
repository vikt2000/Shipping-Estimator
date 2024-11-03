import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import com.clearvoyage.shipping_estimator.entities.Estimate;
import com.clearvoyage.shipping_estimator.services.EstimateService;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class EstimateControllerTest {

    @InjectMocks
    private EstimateController estimateController;

    @Mock
    private EstimateService estimateService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateEstimate() {
        // Arrange
        Estimate estimate = new Estimate();
        estimate.setId(1);
        estimate.setDescription("Test Estimate");
        when(estimateService.saveEstimate(any(Estimate.class))).thenReturn(estimate);

        // Act
        ResponseEntity<Estimate> response = estimateController.createEstimate(estimate);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(estimate, response.getBody());
        verify(estimateService).saveEstimate(estimate);
    }

    @Test
    public void testGetEstimateById() {
        // Arrange
        Estimate estimate = new Estimate();
        estimate.setId(1);
        estimate.setDescription("Test Estimate");
        when(estimateService.getEstimateById(1)).thenReturn(Optional.of(estimate));

        // Act
        ResponseEntity<Estimate> response = estimateController.getEstimateById(1);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(estimate, response.getBody());
        verify(estimateService).getEstimateById(1);
    }

    @Test
    public void testGetEstimateById_NotFound() {
        // Arrange
        when(estimateService.getEstimateById(1)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Estimate> response = estimateController.getEstimateById(1);

        // Assert
        assertEquals(404, response.getStatusCodeValue());
        verify(estimateService).getEstimateById(1);
    }

    @Test
    public void testGetAllEstimates() {
        // Arrange
        Estimate estimate1 = new Estimate();
        estimate1.setId(1);
        estimate1.setDescription("Test Estimate 1");
        Estimate estimate2 = new Estimate();
        estimate2.setId(2);
        estimate2.setDescription("Test Estimate 2");
        List<Estimate> estimates = Arrays.asList(estimate1, estimate2);
        when(estimateService.getAllEstimates()).thenReturn(estimates);

        // Act
        ResponseEntity<List<Estimate>> response = estimateController.getAllEstimates();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(estimates, response.getBody());
        verify(estimateService).getAllEstimates();
    }

    @Test
    public void testUpdateEstimate() {
        // Arrange
        Estimate estimate = new Estimate();
        estimate.setId(1);
        estimate.setDescription("Updated Estimate");
        when(estimateService.updateEstimate(eq(1), any(Estimate.class))).thenReturn(Optional.of(estimate));

        // Act
        ResponseEntity<Estimate> response = estimateController.updateEstimate(1, estimate);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(estimate, response.getBody());
        verify(estimateService).updateEstimate(1, estimate);
    }

    @Test
    public void testUpdateEstimate_NotFound() {
        // Arrange
        Estimate estimate = new Estimate();
        estimate.setId(1);
        estimate.setDescription("Updated Estimate");
        when(estimateService.updateEstimate(eq(1), any(Estimate.class))).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Estimate> response = estimateController.updateEstimate(1, estimate);

        // Assert
        assertEquals(404, response.getStatusCodeValue());
        verify(estimateService).updateEstimate(1, estimate);
    }

    @Test
    public void testDeleteEstimate() {
        // Arrange
        when(estimateService.deleteEstimate(1)).thenReturn(true);

        // Act
        ResponseEntity<Void> response = estimateController.deleteEstimate(1);

        // Assert
        assertEquals(204, response.getStatusCodeValue());
        verify(estimateService).deleteEstimate(1);
    }

    @Test
    public void testDeleteEstimate_NotFound() {
        // Arrange
        when(estimateService.deleteEstimate(1)).thenReturn(false);

        // Act
        ResponseEntity<Void> response = estimateController.deleteEstimate(1);

        // Assert
        assertEquals(404, response.getStatusCodeValue());
        verify(estimateService).deleteEstimate(1);
    }
}
