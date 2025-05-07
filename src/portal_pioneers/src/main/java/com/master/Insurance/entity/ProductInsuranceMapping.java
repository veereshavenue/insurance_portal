package com.master.Insurance.entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Id;

@Entity
@Data
public class ProductInsuranceMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "insurance_id", nullable = false)
    private Provider insurance;

    private String url;
    private String requestJson;
    private String responseJson;
    private String country;
    private boolean isActive = true;

    // Getters and Setters
}

