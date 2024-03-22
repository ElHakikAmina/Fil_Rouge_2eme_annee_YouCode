package com.youcode.MonSupplier.services.interfaces;

import com.youcode.MonSupplier.models.Dtos.UserDto.UserDto;
import com.youcode.MonSupplier.models.Dtos.ValidationDto.ValidationDto;
import com.youcode.MonSupplier.models.Enums.RoleUser;

import java.util.Optional;

public interface UserService {
    Optional Login (UserDto userDto);
    Boolean activateAccount (ValidationDto validationDto);

    Boolean sendCodeForgetPassword(UserDto userDto);

    Boolean updatePassword(ValidationDto validationDto, String newPassword);

    Boolean signUp(Object userObject, RoleUser roleUser);
}
