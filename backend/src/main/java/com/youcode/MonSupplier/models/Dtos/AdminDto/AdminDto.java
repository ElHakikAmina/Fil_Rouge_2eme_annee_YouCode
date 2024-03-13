package com.youcode.MonSupplier.models.Dtos.AdminDto;

import com.youcode.MonSupplier.models.Enums.RoleUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDto {
    private Long id;
    private String email;
    private String password;
    private RoleUser roleUser;
}
