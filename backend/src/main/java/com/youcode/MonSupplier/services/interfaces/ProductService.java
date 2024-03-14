package com.youcode.MonSupplier.services.interfaces;

import com.youcode.MonSupplier.models.Dtos.ProductDto.ProductDto;
import com.youcode.MonSupplier.models.Dtos.ProductDto.ProductDto;
import com.youcode.MonSupplier.models.Entities.Product;
import com.youcode.MonSupplier.models.Entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getProducts();

    Product createProduct(ProductDto ProductDto);
    
    Optional<Product> getProductById(Long id);

    Product updateProduct(ProductDto ProductDto);
    
    Boolean deleteProduct(Long id);
}
