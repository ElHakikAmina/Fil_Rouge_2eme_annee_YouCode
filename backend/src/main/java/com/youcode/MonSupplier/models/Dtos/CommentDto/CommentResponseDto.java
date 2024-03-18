package com.youcode.MonSupplier.models.Dtos.CommentDto;

import com.youcode.MonSupplier.models.Entities.Buyer;
import com.youcode.MonSupplier.models.Entities.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponseDto {
    private Long id;
    private String comment;
}
