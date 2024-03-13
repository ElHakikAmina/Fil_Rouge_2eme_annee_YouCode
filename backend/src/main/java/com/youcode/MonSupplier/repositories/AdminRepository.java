package com.youcode.MonSupplier.repositories;

import com.youcode.MonSupplier.models.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByEmailAndPassword(String email, String password);
    Boolean existsByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);

    Optional<Admin> findByEmail(String email);
}
