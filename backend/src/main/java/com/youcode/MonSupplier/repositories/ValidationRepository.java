package com.youcode.MonSupplier.repositories;

import com.youcode.MonSupplier.models.Entities.Validation;
import com.youcode.MonSupplier.models.Enums.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ValidationRepository extends JpaRepository<Validation, Long> {
    boolean existsByEmailAndCodeAndRoleUser(String email, long code, RoleUser roleUser);
}
