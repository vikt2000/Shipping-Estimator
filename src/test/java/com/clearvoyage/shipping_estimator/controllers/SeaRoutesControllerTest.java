public class SeaRoutesControllerTest {
    @Mock
    private SeaRoutesApiClient seaRoutesApiClient;

    @InjectMocks
    private SeaRoutesController seaRoutesController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSeaRoutes() {
        // Arrange
        Mono<String> seaRoutesData = Mono.just("SeaRoutesData");
        when(seaRoutesApiClient.fetchSeaRoutesData("9.965629577636719", "53.53296196255539", "0.45069694519042963", "51.503039451809734")).thenReturn(seaRoutesData);

        // Act
        Mono<String> response = seaRoutesController.getSeaRoutes("9.965629577636719", "53.53296196255539", "0.45069694519042963", "51.503039451809734");

        // Assert
        assertEquals(seaRoutesData.block(), response.block());
        verify(seaRoutesApiClient).fetchSeaRoutesData("9.965629577636719", "53.53296196255539", "0.45069694519042963", "51.503039451809734");
    }
}
