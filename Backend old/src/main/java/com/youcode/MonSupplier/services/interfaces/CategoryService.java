package com.youcode.MonSupplier.services.interfaces;

import com.youcode.MonSupplier.models.Dtos.CategoryDto.CategoryDto;
import com.youcode.MonSupplier.models.Entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getCategories();

    Category CreateCategory(CategoryDto CategorieDto);
    Optional<Category> ReadCategoryById(Long id);

    Category UpdateCategory(CategoryDto CategorieDto);

    Boolean DeleteCategory(Long id);
}
