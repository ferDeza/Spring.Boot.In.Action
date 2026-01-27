package com.example.storeapp.repositories;

import com.example.storeapp.models.Category;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByName(String name);
}
