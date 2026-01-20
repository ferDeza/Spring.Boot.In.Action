package com.example.storeapp.repositories;

import com.example.storeapp.models.Product;
import com.example.storeapp.models.ProductOrder;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.UUID;

public interface OrderRepository extends CrudRepository<ProductOrder, UUID> {
    List<ProductOrder> findAllByOrderByIdDesc();

    List<ProductOrder> id(UUID id);
}
