package com.example.storeapp.controllers;

import com.example.storeapp.models.User;
import com.example.storeapp.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserController(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public List<User> getAllUsers() {return
            userRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id).
                map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
    return userRepository.findById(id).map(
            user->{
                user.setEmail(userDetails.getEmail());
                user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
                user.setEmail(userDetails.getEmail());
                return ResponseEntity.ok(userRepository.save(user));
            }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    if(userRepository.existsById(id)) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
    }
}
