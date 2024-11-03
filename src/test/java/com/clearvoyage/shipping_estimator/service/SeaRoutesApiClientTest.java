import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SeaRoutesApiClientTest {
    
    @MockBean
    private WebClient.Builder webClientBuilder;

    @MockBean
    private WebClient webClient;

    @MockBean
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @MockBean
    private WebClient.RequestHeadersSpec requestHeadersSpec;

    @MockBean
    private WebClient.ResponseSpec responseSpec;

    private SeaRoutesApiClient seaRoutesApiClient;

    @Value("${searoutes.api.url}")
    private String apiUrl;

    @Value("${searoutes.api.key}")
    private String apiKey;

    @BeforeEach
    public void setUp() {
        when(webClientBuilder.build()).thenReturn(webClient);
        seaRoutesApiClient = new SeaRoutesApiClient(webClientBuilder, apiUrl, apiKey);
    }

    @Test
    public void testFetchSeaRoutesData() {
        String startLong = "10.0";
        String startLat = "20.0";
        String endLong = "30.0";
        String endLat = "40.0";
        String expectedResponse = "Sea route data";

        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(any(URI.class))).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.header(eq("x-api-key"), eq(apiKey))).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(String.class)).thenReturn(Mono.just(expectedResponse));

        Mono<String> result = seaRoutesApiClient.fetchSeaRoutesData(startLong, startLat, endLong, endLat);

        StepVerifier.create(result)
                .expectNext(expectedResponse)
                .verifyComplete();
    }
}
