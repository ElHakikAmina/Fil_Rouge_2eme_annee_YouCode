package com.youcode.MonSupplier.models.Dtos.ProductDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private Long id;
    private String name;
    private float prix;
    private int less_quantity;
    private int quantity;
    private String description;
    private String image;
}
