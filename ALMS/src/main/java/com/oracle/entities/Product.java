package com.oracle.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="PRODUCT")
@Data
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // AUTO_INCREMENT equivalent
    @Column(name = "prod_id")
    private int prodId;

    @Column(name = "prod_type", nullable = false, length = 20)
    private String prodType;

    @Column(name = "description", length = 30)
    private String description;
    
    public Product() {}
}
