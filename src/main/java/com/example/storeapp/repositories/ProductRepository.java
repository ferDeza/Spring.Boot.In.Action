package com.example.storeapp.repositories;

import com.example.storeapp.models.Category;
import com.example.storeapp.models.Product;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {
    List<Product> findByName(String name);
    List<Product> findByCategoryId(UUID categoryId);
    List<Product> findByStockGreaterThan(Integer amount);
}
