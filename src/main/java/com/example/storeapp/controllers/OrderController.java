package com.example.storeapp.controllers;

import com.example.storeapp.models.ProductOrder;
import com.example.storeapp.models.User;
import com.example.storeapp.repositories.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
private OrderRepository orderRepository;

@GetMapping
    public List<ProductOrder> getAllOrders() {return (List<ProductOrder>) orderRepository.findAll(); }

    /*@PostMapping
@ResponseStatus(HttpStatus.CREATED)
    public ProductOrder addOrder(@RequestBody ProductOrder order) {
    return orderRepository.save(order);
}*/
@PostMapping
public String processOrder(@Valid ProductOrder order,
                           Errors errors, @AuthenticationPrincipal User user) {
    if(errors.hasErrors()) {
     return "orderForm";
    }
    order.setUsername(user.getUsername());
    orderRepository.save(order);
    return "redirect:/";
}
@GetMapping("/{id}")
    public ProductOrder getOrderById(@PathVariable UUID id) { return orderRepository.findById(id).orElse(null); }
@DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable UUID id) {orderRepository.deleteById(id);}
}
