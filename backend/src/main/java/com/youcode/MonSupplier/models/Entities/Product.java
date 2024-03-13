package com.youcode.MonSupplier.models.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float prix;
    private int less_quantity;
    private int quantity;
    private String description;
    id_category ;
        id_supplier;
}
