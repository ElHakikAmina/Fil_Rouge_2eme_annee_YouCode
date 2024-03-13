package com.youcode.MonSupplier.repositories;

import com.youcode.MonSupplier.models.Entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Optional<Supplier> findByEmailAndPassword(String email, String password);
    Boolean existsByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);

    Optional<Supplier> findByEmail(String email);
}
