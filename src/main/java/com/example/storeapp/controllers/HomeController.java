package com.example.storeapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "¡Bienvenido a StoreApp! API funcionando correctamente.";
    }

    @GetMapping("/api/status")
    public String status() {
        return "API Status: OK";
    }
}
