package com.youcode.MonSupplier.models.Entities;

import com.youcode.MonSupplier.models.Entities.Buyer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "achatProduct")
public class AchatProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Buyer buyer;
}
