package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.entity.Category;
import com.metaphorce.shopall.entity.Product;
import com.metaphorce.shopall.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@Tag(name = "Categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Operation(summary = "Create a new category")
    @PostMapping("/create")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @Operation(summary = "Get a category by ID")
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        return categoryService.getById(id);
    }

    @Operation(summary = "Find a category by name")
    @GetMapping("/findByName")
    public Category getBuyerByEmail(@RequestParam String name) {
        return categoryService.getByName(name);
    }

    @Operation(summary = "Delete a category by ID")
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }

    @Operation(summary = "Get all categories")
    @GetMapping("/getAll")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @Operation(summary = "Update a category by ID")
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Integer id, @RequestBody Category updatedCategory) {
        return categoryService.updateCategory(id, updatedCategory);
    }

    @Operation
    @GetMapping("/{id}/product_list")
    public ResponseEntity<?> getBuyerShopList(@PathVariable Integer id) {
        Category category = categoryService.getById(id);
        if(category != null) {
            List<Product> products = category.getProductList();
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).body("Category not found");
        }
    }

}
