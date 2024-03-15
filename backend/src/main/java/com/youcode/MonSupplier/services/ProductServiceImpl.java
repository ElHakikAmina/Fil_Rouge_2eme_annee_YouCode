package com.youcode.MonSupplier.services;

import com.youcode.MonSupplier.models.Dtos.ProductDto.ProductDto;
import com.youcode.MonSupplier.models.Entities.AchatProduct;
import com.youcode.MonSupplier.models.Entities.Buyer;
import com.youcode.MonSupplier.models.Entities.Product;
import com.youcode.MonSupplier.repositories.AchatProductRepository;
import com.youcode.MonSupplier.repositories.BuyerRepository;
import com.youcode.MonSupplier.repositories.ProductRepository;
import com.youcode.MonSupplier.services.interfaces.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final AchatProductRepository achatProductRepository;
    private final BuyerRepository buyerRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, AchatProductRepository achatProductRepository, BuyerRepository buyerRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.achatProductRepository = achatProductRepository;
        this.buyerRepository = buyerRepository;
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

    @Override
    public Boolean achatProduct(long idBuyer, long idProduct, int quantity) {
        if (productRepository.existsById(idProduct) && buyerRepository.existsById(idBuyer)){
            Optional<Product> product = productRepository.findById(idProduct);
            Buyer buyer = buyerRepository.findById(idBuyer).get();
            if (product.isPresent()){
                if (product.get().getQuantity() >= quantity && quantity >= product.get().getLess_quantity()){
                    product.get().setQuantity(product.get().getQuantity() - quantity);
                    productRepository.save(product.get());
                    AchatProduct achatProduct = new AchatProduct();
                    achatProduct.setBuyer(buyer);
                    achatProduct.setProduct(product.get());
                    achatProduct.setQuantity(quantity);
                    achatProductRepository.save(achatProduct);
                    return true;
                }
            }
        }
        return false;
    }
}
