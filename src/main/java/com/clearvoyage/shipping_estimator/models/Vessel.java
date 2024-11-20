package com.clearvoyage.shipping_estimator.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vessel {
    private Long imo;
    private String name;
    private Double length;
    private Double width;
    private Double maxDraft;
}
