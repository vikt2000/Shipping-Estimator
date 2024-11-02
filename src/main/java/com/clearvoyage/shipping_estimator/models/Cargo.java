package com.clearvoyage.shipping_estimator.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {
    private Integer id;
    private String name;
    private Port loadingPort;
    private Port dischargePort;
    private Integer quantity;
    private String unit;
    private Double weight; // Changed to Double for fractional weights
}
