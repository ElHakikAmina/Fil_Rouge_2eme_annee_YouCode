package com.youcode.MonSupplier.models.Dtos.ProductDto;

import com.youcode.MonSupplier.models.Entities.Category;
import com.youcode.MonSupplier.models.Entities.Supplier;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private float prix;
    private int less_quantity;
    private int quantity;
    private String description;
    private String image;
    private Category category;
    private Supplier supplier;
}
