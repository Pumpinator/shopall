package com.metaphorce.shopall.service;

import com.metaphorce.shopall.entity.Category;
import com.metaphorce.shopall.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category getById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category getByName(String name) {
        return categoryRepository.findByName(name);
    }

    public boolean deleteCategory(Integer id) {
        if (categoryRepository.findById(id) != null) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category updateCategory(Integer id, Category updatedCategory) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setName(updatedCategory.getName());
            return categoryRepository.save(category);
        }
        return null;
    }

}
