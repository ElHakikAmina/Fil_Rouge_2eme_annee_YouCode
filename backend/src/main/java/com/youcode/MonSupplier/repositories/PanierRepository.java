package com.youcode.MonSupplier.repositories;

import com.youcode.MonSupplier.models.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import com.youcode.MonSupplier.models.Entities.Panier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PanierRepository extends JpaRepository<Panier, Long> {

    @Query("SELECT p.product FROM Panier p WHERE p.buyer.id = :buyerId")
    List<Product> findProductsByBuyerId(Long buyerId);


}
