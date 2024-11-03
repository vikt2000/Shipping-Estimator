import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PortTest {
    @Mock
    private PortService portService;

    @InjectMocks
    private PortController portController;

    private AutoCloseable closeable;

    @Before
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void testGetPort() {
        // Arrange
        Port expectedPort = new Port("123", "Port A", 100);
        when(portService.getPort("123")).thenReturn(expectedPort);

        // Act
        Port actualPort = portController.getPort("123");

        // Assert
        assertEquals(expectedPort, actualPort);
        verify(portService).getPort("123");
    }

    @Test
    public void testAddPort() {
        // Arrange
        Port port = new Port("123", "Port A", 100);
        when(portService.addPort(any(Port.class))).thenReturn(port);

        // Act
        ResponseEntity<Port> response = portController.addPort(port);

        // Assert
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(port, response.getBody());
        verify(portService).addPort(any(Port.class));
    }
}
