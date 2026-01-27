package com.example.storeapp.repositories;
import com.example.storeapp.models.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
