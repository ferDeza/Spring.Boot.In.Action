package com.example.storeapp.repositories;

import com.example.storeapp.models.Product;
import com.example.storeapp.models.ProductOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<ProductOrder, Long> {
    List<ProductOrder> findAllByOrderByIdDesc();
}
