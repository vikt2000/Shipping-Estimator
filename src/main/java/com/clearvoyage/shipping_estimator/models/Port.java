package com.clearvoyage.shipping_estimator.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Port {
    private Integer id;
    private String name;
    private Double latitude;
    private Double longitude;
}
