package com.example.storeapp.models;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String email;
    public User toUser(PasswordEncoder passwordEncoder) {
        return new User (UUID.randomUUID(),username,
                passwordEncoder.encode(password),email);
    }
}
