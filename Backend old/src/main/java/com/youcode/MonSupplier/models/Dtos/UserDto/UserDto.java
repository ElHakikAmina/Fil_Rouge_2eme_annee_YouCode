package com.youcode.MonSupplier.models.Dtos.UserDto;

import com.youcode.MonSupplier.models.Enums.RoleUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String email;
    private String password;
    private RoleUser roleUser;
}
