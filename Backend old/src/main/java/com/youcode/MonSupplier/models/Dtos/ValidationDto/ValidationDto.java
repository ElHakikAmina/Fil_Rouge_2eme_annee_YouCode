package com.youcode.MonSupplier.models.Dtos.ValidationDto;

import com.youcode.MonSupplier.models.Enums.RoleUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationDto {
    private Long id;
    private Long code;
    private String email;
    private RoleUser roleUser;
}
