package com.youcode.MonSupplier.services;

import com.youcode.MonSupplier.models.Dtos.CategoryDto.CategoryDto;
import com.youcode.MonSupplier.models.Entities.Category;
import com.youcode.MonSupplier.repositories.CategoryRepository;
import com.youcode.MonSupplier.services.interfaces.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category CreateCategory(CategoryDto CategorieDto) {
        Category category = modelMapper.map(CategorieDto,Category.class);
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Optional<Category> ReadCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category UpdateCategory(CategoryDto categoryDto) {
        return categoryDto.getId() != null ? CreateCategory(categoryDto) : null;
    }

    @Override
    public Boolean DeleteCategory(Long id) {
        if (categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
