package com.youcode.MonSupplier.models.Dtos.SupplierDto;

import com.youcode.MonSupplier.models.Enums.RoleUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierDto {
    private Long id;
    private String email;
    private String image;
    private String Nom;
    private String password;
    private RoleUser roleUser;
    private Boolean isVerifie;
}
