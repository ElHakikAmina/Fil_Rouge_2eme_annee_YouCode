package com.youcode.MonSupplier.services;

import com.youcode.MonSupplier.exceptions.ApiRequestException;
import com.youcode.MonSupplier.models.Dtos.AdminDto.AdminDto;
import com.youcode.MonSupplier.models.Dtos.BuyerDto.BuyerDto;
import com.youcode.MonSupplier.models.Dtos.SupplierDto.SupplierDto;
import com.youcode.MonSupplier.models.Dtos.UserDto.UserDto;
import com.youcode.MonSupplier.models.Dtos.ValidationDto.ValidationDto;
import com.youcode.MonSupplier.models.Entities.*;
import com.youcode.MonSupplier.models.Enums.RoleUser;
import com.youcode.MonSupplier.repositories.*;
import com.youcode.MonSupplier.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserServiceImpl implements UserService {
    private final AdminRepository adminRepository;
    private final BuyerRepository buyerRepository;
    private final EmailService emailService;
    private final SupplierRepository supplierRepository;
    private final ValidationRepository validationRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(AdminRepository adminRepository, ValidationRepository validationRepository, EmailService emailService, SupplierRepository supplierRepository, BuyerRepository buyerRepository, ModelMapper modelMapper) {
        this.adminRepository = adminRepository;
        this.modelMapper = modelMapper;
        this.emailService = emailService;
        this.buyerRepository = buyerRepository;
        this.validationRepository = validationRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Optional Login(UserDto userDto) {
        String email = userDto.getEmail();
        String password = userDto.getPassword();
        if(!adminRepository.existsByEmailAndPassword(email, password)){
                if(!buyerRepository.existsByEmailAndPassword(email, password)){
                    if(!supplierRepository.existsByEmailAndPassword(email, password)){
                        return Optional.empty();
                    } else {
                        Supplier supplier = supplierRepository.findByEmailAndPassword(email, password).orElse(null);
                        return Optional.ofNullable(modelMapper.map(supplier, SupplierDto.class));
                    }
                } else {
                    Buyer buyer = buyerRepository.findByEmailAndPassword(email, password).orElse(null);
                    return Optional.ofNullable(modelMapper.map(buyer, BuyerDto.class));
                }
        } else {
            Admin admin = adminRepository.findByEmailAndPassword(email, password).orElse(null);
            return Optional.ofNullable(modelMapper.map(admin, AdminDto.class));
        }
    }

    @Override
    public Boolean activateAccount(ValidationDto validationDto) {
        String email = validationDto.getEmail();
        RoleUser roleUser = validationDto.getRoleUser();
        long code = validationDto.getCode();
        if(validationRepository.existsByEmailAndCodeAndRoleUser(email, code, roleUser)){
            if (roleUser == RoleUser.Admin) {
                Admin admin = adminRepository.findByEmail(email).orElse(null);
                if (admin == null) throw new AssertionError();
                adminRepository.save(admin);
                return true;
            } else if (roleUser == RoleUser.Buyer) {
                Buyer buyer = buyerRepository.findByEmail(email).orElse(null);
                if (buyer == null) throw new AssertionError();
                buyer.setIsVerifie(true);
                buyerRepository.save(buyer);
                return true;
            } else if (roleUser == RoleUser.Supplier) {
                Supplier supplier = supplierRepository.findByEmail(email).orElse(null);
                if (supplier == null) throw new AssertionError();
                supplier.setIsVerifie(true);
                supplierRepository.save(supplier);
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean sendCodeForgetPassword(UserDto userDto) {
        if (userDto.getRoleUser() == RoleUser.Admin) {
            Admin admin = adminRepository.findByEmail(userDto.getEmail()).orElse(null);
            if (admin == null) {
                throw new ApiRequestException("Admin not found");
            }
            return sendCodeVerifyAccount(userDto,"reset your password");
        } else if (userDto.getRoleUser() == RoleUser.Buyer) {
            Buyer buyer = buyerRepository.findByEmail(userDto.getEmail()).orElse(null);
            if (buyer == null) {
                throw new ApiRequestException("Agent not found");
            }
            return sendCodeVerifyAccount(userDto,"reset your password");
        } else if (userDto.getRoleUser() == RoleUser.Supplier) {
            Supplier supplier = supplierRepository.findByEmail(userDto.getEmail()).orElse(null);
            if (supplier == null) {
                throw new ApiRequestException("Societe not found");
            }
            return sendCodeVerifyAccount(userDto,"reset your password");
        }
        return false;
    }

    @Override
    public Boolean updatePassword(ValidationDto validationDto, String newPassword) {
        if (validationRepository.existsByEmailAndCodeAndRoleUser(validationDto.getEmail(), validationDto.getCode(), validationDto.getRoleUser())) {
            if (validationDto.getRoleUser() == RoleUser.Admin) {
                Admin admin = adminRepository.findByEmail(validationDto.getEmail()).orElse(null);
                if (admin == null) throw new AssertionError();
                admin.setPassword(newPassword);
                adminRepository.save(admin);
                return true;
            } else if (validationDto.getRoleUser() == RoleUser.Buyer) {
                Buyer buyer = buyerRepository.findByEmail(validationDto.getEmail()).orElse(null);
                if (buyer == null) throw new AssertionError();
                buyer.setPassword(newPassword);
                buyerRepository.save(buyer);
                return true;
            } else if (validationDto.getRoleUser() == RoleUser.Supplier) {
                Supplier supplier = supplierRepository.findByEmail(validationDto.getEmail()).orElse(null);
                if (supplier == null) throw new AssertionError();
                supplier.setPassword(newPassword);
                supplierRepository.save(supplier);
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean signUp(Object userObject) {
        String userObjectString = userObject.toString();
        String[] userObjectArray = userObjectString.split("roleUser=");
        RoleUser roleUser = RoleUser.valueOf(userObjectArray[1].substring(0, userObjectArray[1].length() - 1));

        if (roleUser == RoleUser.Admin) {
            Admin admin = modelMapper.map(userObject, Admin.class);
            adminRepository.save(admin);
            UserDto userDto = new UserDto();
            userDto.setEmail(admin.getEmail());
            userDto.setRoleUser(admin.getRoleUser());
            this.sendCodeVerifyAccount(userDto,"activate your account");
            return true;
        } else if (roleUser == RoleUser.Buyer) {
            Buyer buyer = modelMapper.map(userObject, Buyer.class);
            buyerRepository.save(buyer);
            UserDto userDto = new UserDto();
            userDto.setEmail(buyer.getEmail());
            userDto.setRoleUser(buyer.getRoleUser());
            this.sendCodeVerifyAccount(userDto,"activate your account");
            return true;
        } else if (roleUser == RoleUser.Supplier) {
            Supplier supplier = modelMapper.map(userObject, Supplier.class);
            supplierRepository.save(supplier);
            UserDto userDto = new UserDto();
            userDto.setEmail(supplier.getEmail());
            userDto.setRoleUser(supplier.getRoleUser());
            this.sendCodeVerifyAccount(userDto,"activate your account");
            return true;
        }
        return false;
    }

    public Boolean sendCodeVerifyAccount(UserDto userDto,String subject) {
        String email = userDto.getEmail();
        RoleUser roleUser = userDto.getRoleUser();
        long code = generateCode();
        emailService.sendEmail(email,
                subject,
                subject+"'s code is: " + code);
        Validation validation = new Validation();
        validation.setCode(code);
        validation.setEmail(email);
        validation.setRoleUser(roleUser);
        validationRepository.save(validation);
        return true;
    }

    public long generateCode() {
        return ThreadLocalRandom.current().nextLong(100000, 999999);
    }
}
