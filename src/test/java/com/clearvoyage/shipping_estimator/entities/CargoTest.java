import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.clearvoyage.shipping_estimator.entities.Cargo;
import com.clearvoyage.shipping_estimator.entities.Port;

public class CargoTest {

    private Cargo cargo;
    private Port loadingPort;
    private Port dischargePort;

    @Before
    public void setUp() {
        loadingPort = new Port();
        loadingPort.setName("Loading Port");

        dischargePort = new Port();
        dischargePort.setName("Discharge Port");

        cargo = new Cargo();
        cargo.setId(1);
        cargo.setName("Test Cargo");
        cargo.setLoadingPort(loadingPort);
        cargo.setDischargePort(dischargePort);
        cargo.setQuantity(100);
        cargo.setUnit("kg");
        cargo.setWeight(200.0);
    }

    @Test
    public void testCargoFields() {
        assertEquals(Integer.valueOf(1), cargo.getId());
        assertEquals("Test Cargo", cargo.getName());
        assertEquals(loadingPort, cargo.getLoadingPort());
        assertEquals(dischargePort, cargo.getDischargePort());
        assertEquals(Integer.valueOf(100), cargo.getQuantity());
        assertEquals("kg", cargo.getUnit());
        assertEquals(Double.valueOf(200.0), cargo.getWeight(), 0.0);
    }

    @Test
    public void testCargoEquality() {
        Cargo anotherCargo = new Cargo(1, "Test Cargo", loadingPort, dischargePort, 100, "kg", 200.0);
        assertEquals(cargo, anotherCargo);
    }
}
