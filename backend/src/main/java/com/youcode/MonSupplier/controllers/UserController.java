package com.youcode.MonSupplier.controllers;

import com.youcode.MonSupplier.exceptions.ApiRequestException;
import com.youcode.MonSupplier.models.Dtos.UserDto.UserDto;
import com.youcode.MonSupplier.models.Dtos.ValidationDto.ValidationDto;
import com.youcode.MonSupplier.models.Enums.RoleUser;
import com.youcode.MonSupplier.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/User")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("login")
    public Optional Login(@RequestBody UserDto userDto) {
        if(Optional.ofNullable(userService.Login(userDto)).isEmpty())
            throw new ApiRequestException("User not found");
        return userService.Login(userDto);
    }
    @PostMapping("signUp/{roleUser}")
    public Boolean signUp(@RequestBody Object userObject, @PathVariable RoleUser roleUser) {
        return userService.signUp(userObject,roleUser);
    }
    @PutMapping("activateAccount")
    public Boolean activateAccount(@RequestBody ValidationDto validationDto) {
        if(Optional.ofNullable(userService.activateAccount(validationDto)).isEmpty())
            throw new ApiRequestException("Code not found");
        return userService.activateAccount(validationDto);
    }
    @PostMapping("forgetPassword")
    public Boolean forgetPassword(@RequestBody UserDto userDto) {
        if(Optional.ofNullable(userService.sendCodeForgetPassword(userDto)).isEmpty())
            throw new ApiRequestException("User not found");
        return userService.sendCodeForgetPassword(userDto);
    }
    @PutMapping("forgetPassword/{newPassword}")
    public Boolean forgetPassword(@RequestBody ValidationDto validationDto , @PathVariable String newPassword) {
        if(Optional.ofNullable(userService.updatePassword(validationDto,newPassword)).isEmpty())
            throw new ApiRequestException("Code not found");
        return userService.updatePassword(validationDto,newPassword);
    }

}
