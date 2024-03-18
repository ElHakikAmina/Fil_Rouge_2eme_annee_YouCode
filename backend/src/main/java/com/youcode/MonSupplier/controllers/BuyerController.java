package com.youcode.MonSupplier.controllers;

import com.youcode.MonSupplier.services.interfaces.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/Agent")
public class BuyerController {
    private final BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }
}