package com.example.storeapp;

import com.example.storeapp.models.Category;
import com.example.storeapp.models.Product;
import com.example.storeapp.models.User;
import com.example.storeapp.repositories.CategoryRepository;
import com.example.storeapp.repositories.ProductRepository;
import com.example.storeapp.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@SpringBootApplication
public class StoreAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreAppApplication.class, args);
        System.out.println("Hello World");
    }
    @Bean
    public CommandLineRunner dataLoader(
            UserRepository userRepo,
            CategoryRepository categoryRepo,
            ProductRepository productRepo,
            PasswordEncoder passwordEncoder) {
        return args -> {
            // 1. CARGAR CATEGORÍAS (Solo si no existen)
            if (categoryRepo.count() == 0) {
                Category perifericos = categoryRepo.save(new Category(null, "Perifericos"));
                Category monitores = categoryRepo.save(new Category(null, "Monitores"));

                // 2. CARGAR PRODUCTOS (Relacionados con las categorías creadas arriba)
                productRepo.save(new Product(null, "Teclado Mecánico RGB", 75.50, 20, perifericos));
                productRepo.save(new Product(null, "Monitor 4K 27\"", 350.00, 10, monitores));
                productRepo.save(new Product(null, "Monitor 4k 21\"", 300.00, 10, perifericos));
                productRepo.save(new Product(null, "Teclado switch blue", 50.00, 10, monitores));

                System.out.println("Categorías y Productos cargados correctamente.");
            }

            // 3. CARGAR USUARIO (Solo si no existe)
            if (userRepo.findByUsername("fer_aqp").isEmpty()) {
                User user = new User(null, "fer_aqp", passwordEncoder.encode("password123"), "fer@mail.com");
                userRepo.save(user);
            }
        };
    }

}
