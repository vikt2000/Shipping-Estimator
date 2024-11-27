package com.clearvoyage.shipping_estimator.controllers;

import com.clearvoyage.shipping_estimator.services.SeaRoutesApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/sea-routes")
public class SeaRoutesController {

    private final SeaRoutesApiClient seaRoutesApiClient;

    @Autowired
    public SeaRoutesController(SeaRoutesApiClient seaRoutesApiClient) {
        this.seaRoutesApiClient = seaRoutesApiClient;
    }

    @GetMapping("/test-searoutes")
    public Mono<String> testSeaRoutes() {
        return seaRoutesApiClient.fetchSeaRoutesData("9.965629577636719", "53.53296196255539", "0.45069694519042963", "51.503039451809734");
    }
}
