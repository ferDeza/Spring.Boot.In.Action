package com.example.storeapp.repositories;

import com.example.storeapp.models.Category;
import com.example.storeapp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
    List<Product> findByCategory(Category category);
    List<Product> findByStockGreaterThan(Integer amount);
}
