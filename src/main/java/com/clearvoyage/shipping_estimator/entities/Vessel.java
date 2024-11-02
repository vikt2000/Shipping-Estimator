package com.clearvoyage.shipping_estimator.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vessels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vessel {
    @Id
    @Column(name = "imo", nullable = false, updatable = false)
    private Long imo;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "length")
    private Double length;

    @Column(name = "width")
    private Double width;

    @Column(name = "max_draft")
    private Double maxDraft;
}
