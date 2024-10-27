package com.clearvoyage.shipping_estimator.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shipping")
public class ShippingController {

    @GetMapping("/calculate")
    public String calculateShipping(
        @RequestParam String departure,
        @RequestParam String arrival,
        @RequestParam String vesselType,
        @RequestParam double weight
    ) {
        // Your logic for calculating shipping costs goes here.
        return "Calculated shipping cost"; // Placeholder
    }
}
