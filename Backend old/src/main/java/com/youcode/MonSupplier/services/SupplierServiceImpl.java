package com.youcode.MonSupplier.services;

import com.youcode.MonSupplier.models.Dtos.SupplierDto.SupplierDto;
import com.youcode.MonSupplier.models.Dtos.UserDto.UserDto;
import com.youcode.MonSupplier.models.Entities.Supplier;
import com.youcode.MonSupplier.models.Enums.RoleUser;
import com.youcode.MonSupplier.repositories.*;
import com.youcode.MonSupplier.services.interfaces.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class SupplierServiceImpl implements SupplierService {
    private final BuyerRepository buyerRepository;
    private final AdminRepository adminRepository;
    private final SupplierRepository supplierRepository;
    private final UserServiceImpl userService;
    private final ModelMapper modelMapper;

    public SupplierServiceImpl(BuyerRepository buyerRepository, AdminRepository adminRepository, SupplierRepository supplierRepository, UserServiceImpl userService, ModelMapper modelMapper) {
        this.buyerRepository = buyerRepository;
        this.adminRepository = adminRepository;
        this.supplierRepository = supplierRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }
}
