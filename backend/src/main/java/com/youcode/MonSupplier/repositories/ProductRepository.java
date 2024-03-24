package com.youcode.MonSupplier.repositories;

import com.youcode.MonSupplier.models.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByPrix(float price);

    List<Product> findAllByNameOrDescription(String name, String description);



}
