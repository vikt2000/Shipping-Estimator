import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CargoControllersTest {
    
    @Mock
    private CargoService cargoService;

    @InjectMocks
    private CargoController cargoController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCargoDetails() {
        // Arrange
        Cargo expectedCargo = new Cargo("123", "Electronics", 100);
        when(cargoService.getCargoDetails("123")).thenReturn(expectedCargo);

        // Act
        Cargo actualCargo = cargoController.getCargoDetails("123");

        // Assert
        assertEquals(expectedCargo, actualCargo);
        verify(cargoService).getCargoDetails("123");
    }
}

// Assuming Cargo class
class Cargo {
    private String id;
    private String description;
    private int weight;

    public Cargo(String id, String description, int weight) {
        this.id = id;
        this.description = description;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return weight == cargo.weight &&
                id.equals(cargo.id) &&
                description.equals(cargo.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, weight);
    }
}

// Assuming CargoController class
class CargoController {
    private CargoService cargoService;

    public Cargo getCargoDetails(String id) {
        return cargoService.getCargoDetails(id);
    }
}

// Assuming CargoService interface
interface CargoService {
    Cargo getCargoDetails(String id);
}
