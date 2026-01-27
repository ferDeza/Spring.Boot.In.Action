package com.example.storeapp.repositories;

import com.example.storeapp.models.Product;
import com.example.storeapp.models.ProductOrder;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<ProductOrder, Long> {
    List<ProductOrder> findAllByOrderByIdDesc();

    List<ProductOrder> findProductOrderById(Long id);
}
