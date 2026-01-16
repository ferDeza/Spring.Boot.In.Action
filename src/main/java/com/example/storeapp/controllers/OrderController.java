package com.example.storeapp.controllers;

import com.example.storeapp.models.ProductOrder;
import com.example.storeapp.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
private OrderRepository orderRepository;

@GetMapping
    public List<ProductOrder> getAllOrders() {return orderRepository.findAll(); }
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
    public ProductOrder addOrder(@RequestBody ProductOrder order) {
    return orderRepository.save(order);
}
@GetMapping("/{id}")
    public ProductOrder getOrderById(@PathVariable Long id) { return orderRepository.findById(id).orElse(null); }
@DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id) {orderRepository.deleteById(id);}
}
