/*package com.example.storeapp.services;
import com.example.storeapp.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.example.storeapp.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.beans.Encoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Bean
public class UserDetailsService userDetailsService(UserRepository userRepository) {
    return username -> {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user; // Ahora funciona porque tu User implementa UserDetails
        }
        throw new UsernameNotFoundException("Usuario '" + username + "' no encontrado");
    };
}
*/
