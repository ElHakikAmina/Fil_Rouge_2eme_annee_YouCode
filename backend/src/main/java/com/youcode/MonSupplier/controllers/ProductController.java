package com.youcode.MonSupplier.controllers;

import com.youcode.MonSupplier.models.Dtos.ProductDto.ProductDto;
import com.youcode.MonSupplier.models.Entities.Product;
import com.youcode.MonSupplier.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/Product")
public class ProductController {
    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAllProducts")
    public Object getAllProducts(){
        return productService.getProducts();
    }

    @GetMapping("/searchByPrice/{price}")
    public List<Product> searchByPrice(@PathVariable float price){
        return productService.searchByPrice(price);
    }

    @GetMapping("/searchByNameOrDescription/{search}")
    public List<Product> searchByPrice(@PathVariable String search){
        return productService.searchByNameOrDescription(search);
    }

    @GetMapping("/getProduct/{id}")
    public Object getProduct(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping("/createProduct")
    public Object createProduct(@RequestBody ProductDto product){
        return productService.createProduct(product);
    }

    @PutMapping("/updateProduct")
    public Object updateProduct(@RequestBody ProductDto product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public boolean deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }

    @PostMapping("/achatProduct/{idBuyer}/{idProduct}/{quantity}")
    public boolean achatProduct(@PathVariable Long idBuyer, @PathVariable Long idProduct, @PathVariable int quantity){
        return productService.achatProduct(idBuyer, idProduct, quantity);
    }

    @PostMapping("/ajouteraupanier/{idBuyer}/{idProduct}/{quantity}")
    public boolean ajouterAuPanier(@PathVariable Long idBuyer, @PathVariable Long idProduct, @PathVariable int quantity){
        return productService.ajouterAuPanier(idBuyer, idProduct, quantity);
    }

    @GetMapping("/getPanierProductsByBuyerId/{buyerId}")
    public List<Product> getPanierProductsByBuyerId(@PathVariable Long buyerId) {
        return productService.getPanierProductsByBuyerId(buyerId);
    }


}
