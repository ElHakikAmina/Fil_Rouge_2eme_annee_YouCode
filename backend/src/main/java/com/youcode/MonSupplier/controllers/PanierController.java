package com.youcode.MonSupplier.controllers;

import com.youcode.MonSupplier.models.Entities.Product;
import com.youcode.MonSupplier.repositories.PanierRepository;
import com.youcode.MonSupplier.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/panier")
public class PanierController {

   /* private final ProductService productService;

    @Autowired
    public PanierController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getProducts/{buyerId}")
    public List<Product> getProductsInPanier(@PathVariable Long buyerId) {
        return productService.getPanierProductsByBuyerId(buyerId);
    }*/
}
