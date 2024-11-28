package com.clearvoyage.shipping_estimator.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;

@Service
public class SeaRoutesApiClient {

    private final WebClient webClient;
    private final String apiUrl;
    private final String apiKey;

    public SeaRoutesApiClient(WebClient.Builder webClientBuilder,
                              @Value("https://api.searoutes.com/route/v2/sea/") String apiUrl,
                              @Value("${searoutes.api.key}") String apiKey) {
        this.webClient = webClientBuilder.build();
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
    }

    public Mono<String> fetchSeaRoutesData(String startLong, String startLat, String endLong, String endLat) {
        // Manually construct the exact URL with already-encoded path parameters
        String url = apiUrl + startLong + "%2C" + startLat + "%3B" + endLong + "%2C" + endLat +
                "?continuousCoordinates=true&allowIceAreas=false&avoidHRA=false&avoidSeca=false";

        return webClient.get()
                .uri(URI.create(url))
                .header("x-api-key", apiKey)
                .retrieve()
                .bodyToMono(String.class);
    }
}
