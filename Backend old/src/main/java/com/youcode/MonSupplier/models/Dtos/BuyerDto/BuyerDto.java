package com.youcode.MonSupplier.models.Dtos.BuyerDto;

import com.youcode.MonSupplier.models.Enums.RoleUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyerDto {
    private Long id;
    private String email;
    private String password;
    private String Nom;
    private String Prenom;
    private RoleUser roleUser;
    private Boolean isVerifie;
}
