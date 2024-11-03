import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.clearvoyage.shipping_estimator.models.Vessel;

public class VesselTest {
    
    private Vessel vessel;

    @BeforeEach
    public void setUp() {
        vessel = new Vessel(1234567L, "Test Vessel", 300.0, 50.0, 15.0);
    }

    @Test
    public void testVesselNotNull() {
        assertNotNull(vessel);
    }

    @Test
    public void testGetImo() {
        assertEquals(1234567L, vessel.getImo());
    }

    @Test
    public void testGetName() {
        assertEquals("Test Vessel", vessel.getName());
    }

    @Test
    public void testGetLength() {
        assertEquals(300.0, vessel.getLength());
    }

    @Test
    public void testGetWidth() {
        assertEquals(50.0, vessel.getWidth());
    }

    @Test
    public void testGetMaxDraft() {
        assertEquals(15.0, vessel.getMaxDraft());
    }

    @Test
    public void testSetImo() {
        vessel.setImo(7654321L);
        assertEquals(7654321L, vessel.getImo());
    }

    @Test
    public void testSetName() {
        vessel.setName("New Vessel");
        assertEquals("New Vessel", vessel.getName());
    }

    @Test
    public void testSetLength() {
        vessel.setLength(350.0);
        assertEquals(350.0, vessel.getLength());
    }

    @Test
    public void testSetWidth() {
        vessel.setWidth(55.0);
        assertEquals(55.0, vessel.getWidth());
    }

    @Test
    public void testSetMaxDraft() {
        vessel.setMaxDraft(16.0);
        assertEquals(16.0, vessel.getMaxDraft());
    }
}
