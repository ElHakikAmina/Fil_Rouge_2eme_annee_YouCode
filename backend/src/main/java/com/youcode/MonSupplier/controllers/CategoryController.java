package com.youcode.MonSupplier.controllers;

import com.youcode.MonSupplier.models.Dtos.CategoryDto.CategoryDto;
import com.youcode.MonSupplier.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/Category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAllCategories")
    public Object getAllCategories(){
        return categoryService.getCategories();
    }
    @GetMapping("/getCategory/{id}")
    public Object getCategory(@PathVariable Long id){
         return categoryService.ReadCategoryById(id);
    }
    @PostMapping("/createCategory")
    public Object createCategory(@RequestBody CategoryDto category){
        return categoryService.CreateCategory(category);
    }
    @PutMapping("/updateCategory")
    public Object updateCategory(@RequestBody CategoryDto category){
        return categoryService.UpdateCategory(category);
    }
    @DeleteMapping("/deleteCategory/{id}")
    public boolean deleteCategory(@PathVariable Long id){
        return categoryService.DeleteCategory(id);
    }
}
