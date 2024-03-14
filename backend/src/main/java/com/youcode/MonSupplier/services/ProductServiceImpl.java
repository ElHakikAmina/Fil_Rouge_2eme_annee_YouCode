package com.youcode.MonSupplier.services;

import com.youcode.MonSupplier.models.Dtos.ProductDto.ProductDto;
import com.youcode.MonSupplier.models.Entities.Product;
import com.youcode.MonSupplier.repositories.ProductRepository;
import com.youcode.MonSupplier.services.interfaces.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(ProductDto ProductDto) {
        Product product = modelMapper.map(ProductDto,Product.class);
        productRepository.save(product);
        return product;
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product updateProduct(ProductDto productDto) {
        return productDto.getId() != null ? createProduct(productDto) : null;

    }

    @Override
    public Boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
