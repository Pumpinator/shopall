package com.metaphorce.shopall.repository;

import com.metaphorce.shopall.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByName(String name);

}
