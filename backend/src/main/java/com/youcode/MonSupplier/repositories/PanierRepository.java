package com.youcode.MonSupplier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.youcode.MonSupplier.models.Entities.Panier;
import org.springframework.stereotype.Repository;


@Repository
public interface PanierRepository extends JpaRepository<Panier, Long> {
}
