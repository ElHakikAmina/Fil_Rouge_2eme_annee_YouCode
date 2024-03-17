package com.youcode.MonSupplier.models.Dtos.AchatProductDto;

import com.youcode.MonSupplier.models.Entities.Buyer;
import com.youcode.MonSupplier.models.Entities.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AchatProductDto {
    private Long id;
    private Product product;
    private Buyer buyer;
    private int quantity;
}
