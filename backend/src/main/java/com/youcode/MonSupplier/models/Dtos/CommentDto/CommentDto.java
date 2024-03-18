package com.youcode.MonSupplier.models.Dtos.CommentDto;

import com.youcode.MonSupplier.models.Entities.Buyer;
import com.youcode.MonSupplier.models.Entities.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private String comment;
    private Buyer buyer;
    private Product product;
}
