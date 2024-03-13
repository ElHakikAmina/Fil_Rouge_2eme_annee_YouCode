package com.youcode.MonSupplier.services.interfaces;


import com.youcode.MonSupplier.models.Enums.RoleUser;

import java.util.List;

public interface AdminService{
    List getAll(RoleUser roleUser);

    void deleteById(RoleUser roleUser, Long id);

    Object getById(RoleUser roleUser, Long id);

    Object create(RoleUser roleUser, Object object);

    Object update(RoleUser roleUser, Object object);
}
