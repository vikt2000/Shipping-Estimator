// package com.clearvoyage.shipping_estimator.service;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.ArgumentCaptor;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.web.reactive.function.client.WebClient;
// import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
// import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
// import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
// import reactor.core.publisher.Mono;

// import java.net.URI;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.ArgumentMatchers.eq;
// import static org.mockito.Mockito.*;

// public class SeaRoutesApiClientTest {

//     // Mocked WebClient.Builder and WebClient instances
//     private WebClient.Builder webClientBuilder;
//     private WebClient webClient;
//     private SeaRoutesApiClient seaRoutesApiClient;

//     // API URL and key values injected from properties
//     @Value("${searoutes.api.url}")
//     private String apiUrl = "http://example.com/api";

//     @Value("${searoutes.api.key}")
//     private String apiKey = "test-api-key";

//     // Set up mocks and the SeaRoutesApiClient instance before each test
//     @BeforeEach
//     void setUp() {
//         webClientBuilder = mock(WebClient.Builder.class);
//         webClient = mock(WebClient.class);
//         when(webClientBuilder.build()).thenReturn(webClient);
//         seaRoutesApiClient = new SeaRoutesApiClient(webClientBuilder, apiUrl, apiKey);
//     }

//     // Test method for fetchSeaRoutesData
//     @Test
//     @SuppressWarnings("unchecked")
//     void testFetchSeaRoutesData() {
//         // Define test parameters and expected response
//         String startLong = "10.0";
//         String startLat = "20.0";
//         String endLong = "30.0";
//         String endLat = "40.0";
//         String expectedResponse = "response";

//         // Mock the WebClient request and response flow
//         RequestHeadersUriSpec<?> uriSpecMock = mock(RequestHeadersUriSpec.class);
//         RequestHeadersSpec<?> headersSpecMock = mock(RequestHeadersSpec.class);
//         ResponseSpec responseSpecMock = mock(ResponseSpec.class);

//         // Define the behavior of the mocked WebClient methods
//         when(webClient.get()).<RequestHeadersUriSpec<?>>thenReturn(uriSpecMock);
//         when(uriSpecMock.uri(any(URI.class))).<RequestHeadersSpec<?>>thenReturn(headersSpecMock);
//         when(headersSpecMock.header(eq("x-api-key"), eq(apiKey))).thenReturn(headersSpecMock);
//         when(headersSpecMock.retrieve()).thenReturn(responseSpecMock);
//         when(responseSpecMock.bodyToMono(eq(String.class))).thenReturn(Mono.just(expectedResponse));

//         // Call the method under test
//         Mono<String> result = seaRoutesApiClient.fetchSeaRoutesData(startLong, startLat, endLong, endLat);

//         // Assert that the response matches the expected response
//         assertEquals(expectedResponse, result.block());

//         // Capture the URI used in the request and verify it matches the expected URL
//         ArgumentCaptor<URI> uriCaptor = ArgumentCaptor.forClass(URI.class);
//         verify(uriSpecMock).uri(uriCaptor.capture());
//         URI capturedUri = uriCaptor.getValue();
//         String expectedUrl = apiUrl + "/" + startLong + "%2C" + startLat + "%3B" + endLong + "%2C" + endLat +
//                 "?continuousCoordinates=true&allowIceAreas=false&avoidHRA=false&avoidSeca=false";
//         assertEquals(expectedUrl, capturedUri.toString());
//     }
// }
