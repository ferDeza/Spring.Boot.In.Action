package com.example.storeapp;

import com.example.storeapp.models.User;
import com.example.storeapp.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class StoreAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreAppApplication.class, args);
        System.out.println("Hello World");
    }
    @Bean
    public CommandLineRunner dataLoader(
            UserRepository userRepo) {
        return args -> {
            // Cassandra genera el ID automáticamente si lo definiste en el modelo
            // Ejemplo para un usuario
            userRepo.save(new User(UUID.randomUUID(), "fer_aqp", "password123", "fer@mail.com"));
        };
    }

}
