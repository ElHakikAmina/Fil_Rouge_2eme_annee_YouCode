package com.youcode.MonSupplier.repositories;

import com.youcode.MonSupplier.models.Entities.AchatProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Panier extends JpaRepository<AchatProduct, Long> {
}
