package com.example.storeapp.repositories;

import com.example.storeapp.models.Category;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends CrudRepository<Category, UUID> {
    List<Category> findByName(String name);
}
