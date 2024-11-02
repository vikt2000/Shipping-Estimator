package com.clearvoyage.shipping_estimator.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estimate {
    private Integer id;
    private Cargo cargo;
    private Integer vesselId;
    private Double weight;
}
