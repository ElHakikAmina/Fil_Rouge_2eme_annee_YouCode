package com.youcode.MonSupplier.models.Dtos.Panier;

import com.youcode.MonSupplier.models.Entities.Buyer;
import com.youcode.MonSupplier.models.Entities.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PanierDto {
    private Long id;
    private Product product;
    private Buyer buyer;
    private int quantity;
}
