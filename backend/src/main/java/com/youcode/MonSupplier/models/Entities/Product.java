package com.youcode.MonSupplier.models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float prix;
    private int less_quantity;
    private int quantity;
    private String description;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private Category category;
}
