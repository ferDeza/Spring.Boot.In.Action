package com.example.storeapp.controllers;

import com.example.storeapp.models.ProductOrder;
import com.example.storeapp.models.User;
import com.example.storeapp.repositories.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderRepository orderRepository;
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<ProductOrder> getAllOrders() {
    return orderRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductOrder> processOrder(@Valid @RequestBody ProductOrder order,
                               BindingResult bindingResult, @AuthenticationPrincipal User user) {
        order.setUsername(user.getUsername());
        if (bindingResult.hasErrors()) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ProductOrder savedOrder = orderRepository.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductOrder> getOrderById(@PathVariable Long id) {
    return orderRepository.findById(id).
            map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable Long id) {
    if(orderRepository.existsById(id)) {
        orderRepository.deleteById(id);
        return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
