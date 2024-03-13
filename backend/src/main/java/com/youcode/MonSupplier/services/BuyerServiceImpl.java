package com.youcode.MonSupplier.services;

import com.youcode.MonSupplier.models.Dtos.BuyerDto.BuyerDto;
import com.youcode.MonSupplier.models.Dtos.UserDto.UserDto;
import com.youcode.MonSupplier.models.Entities.Buyer;
import com.youcode.MonSupplier.models.Enums.RoleUser;
import com.youcode.MonSupplier.repositories.*;
import com.youcode.MonSupplier.services.interfaces.BuyerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl implements BuyerService {
    private BuyerRepository buyerRepository;
    private AdminRepository adminRepository;
    private SupplierRepository supplierRepository;
    private UserServiceImpl userService;
    private final ModelMapper modelMapper;

    public BuyerServiceImpl(BuyerRepository buyerRepository, ModelMapper modelMapper, UserServiceImpl userService, AdminRepository adminRepository, SupplierRepository supplierRepository) {
        this.buyerRepository = buyerRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.adminRepository = adminRepository;
        this.supplierRepository = supplierRepository;
    }
}
