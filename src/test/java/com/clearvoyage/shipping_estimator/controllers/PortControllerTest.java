import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import com.clearvoyage.shipping_estimator.entities.Port;
import com.clearvoyage.shipping_estimator.services.PortService;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PortControllerTest {
    
    @Mock
    private PortService portService;

    @InjectMocks
    private PortController portController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreatePort() {
        // Arrange
        Port port = new Port();
        port.setId(1);
        port.setName("Port A");
        when(portService.savePort(any(Port.class))).thenReturn(port);

        // Act
        ResponseEntity<Port> response = portController.createPort(port);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(port, response.getBody());
        verify(portService).savePort(port);
    }

    @Test
    public void testGetPortById() {
        // Arrange
        Port port = new Port();
        port.setId(1);
        port.setName("Port A");
        when(portService.getPortById(1)).thenReturn(Optional.of(port));

        // Act
        ResponseEntity<Port> response = portController.getPortById(1);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(port, response.getBody());
        verify(portService).getPortById(1);
    }

    @Test
    public void testGetPortById_NotFound() {
        // Arrange
        when(portService.getPortById(1)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Port> response = portController.getPortById(1);

        // Assert
        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
        verify(portService).getPortById(1);
    }

    @Test
    public void testGetAllPorts() {
        // Arrange
        Port port1 = new Port();
        port1.setId(1);
        port1.setName("Port A");
        Port port2 = new Port();
        port2.setId(2);
        port2.setName("Port B");
        List<Port> ports = Arrays.asList(port1, port2);
        when(portService.getAllPorts()).thenReturn(ports);

        // Act
        ResponseEntity<List<Port>> response = portController.getAllPorts();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(ports, response.getBody());
        verify(portService).getAllPorts();
    }

    @Test
    public void testUpdatePort() {
        // Arrange
        Port port = new Port();
        port.setId(1);
        port.setName("Port A");
        when(portService.updatePort(eq(1), any(Port.class))).thenReturn(Optional.of(port));

        // Act
        ResponseEntity<Port> response = portController.updatePort(1, port);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(port, response.getBody());
        verify(portService).updatePort(1, port);
    }

    @Test
    public void testUpdatePort_NotFound() {
        // Arrange
        Port port = new Port();
        port.setId(1);
        port.setName("Port A");
        when(portService.updatePort(eq(1), any(Port.class))).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Port> response = portController.updatePort(1, port);

        // Assert
        assertEquals(404, response.getStatusCodeValue());
        verify(portService).updatePort(1, port);
    }

    @Test
    public void testDeletePort() {
        // Arrange
        when(portService.deletePort(1)).thenReturn(true);

        // Act
        ResponseEntity<Void> response = portController.deletePort(1);

        // Assert
        assertEquals(204, response.getStatusCodeValue());
        verify(portService).deletePort(1);
    }

    @Test
    public void testDeletePort_NotFound() {
        // Arrange
        when(portService.deletePort(1)).thenReturn(false);

        // Act
        ResponseEntity<Void> response = portController.deletePort(1);

        // Assert
        assertEquals(404, response.getStatusCodeValue());
        verify(portService).deletePort(1);
    }
}
