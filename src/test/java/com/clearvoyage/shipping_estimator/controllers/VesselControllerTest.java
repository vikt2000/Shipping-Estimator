public class VesselControllerTest {
    @Mock
    private VesselService vesselService;

    @InjectMocks
    private VesselController vesselController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetVesselDetails() {
        // Arrange
        Vessel expectedVessel = new Vessel("123", "Vessel A", 100);
        when(vesselService.getVesselDetails("123")).thenReturn(expectedVessel);

        // Act
        Vessel actualVessel = vesselController.getVesselDetails("123");

        // Assert
        assertEquals(expectedVessel, actualVessel);
        verify(vesselService).getVesselDetails("123");
    }
    
    @Test
    public void testAddVessel() {
        // Arrange
        Vessel vessel = new Vessel("123", "Vessel A", 100);
        when(vesselService.addVessel(any(Vessel.class))).thenReturn(vessel);

        // Act
        ResponseEntity<Vessel> response = vesselController.addVessel(vessel);

        // Assert
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(vessel, response.getBody());
        verify(vesselService).addVessel(any(Vessel.class));
    }
}
