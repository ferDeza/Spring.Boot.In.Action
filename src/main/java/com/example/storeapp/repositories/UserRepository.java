package com.example.storeapp.repositories;

import com.example.storeapp.models.User;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
    User findByUsername(String username);
}
