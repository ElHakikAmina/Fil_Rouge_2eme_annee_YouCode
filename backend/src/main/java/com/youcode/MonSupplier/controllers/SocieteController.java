package com.youcode.MonSupplier.controllers;

import com.youcode.MonSupplier.models.Dtos.SupplierDto.SupplierDto;
import com.youcode.MonSupplier.services.interfaces.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/Societe")
public class SocieteController {
    private final SupplierService supplierService;

    public SocieteController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

}
