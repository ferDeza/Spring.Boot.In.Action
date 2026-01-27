package com.example.storeapp.config;
import com.example.storeapp.models.User;
import com.example.storeapp.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return (String username) -> {
            return userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException(
                            "User '" + username + "' not found"));
        };
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth->auth.
                requestMatchers("/api/orders/**","/api/products/**").hasRole("USER")
                        .requestMatchers("/", "/login", "/register", "/**").permitAll()
                .anyRequest().authenticated()
    ).formLogin(login->login.
                loginPage("/login").
                        defaultSuccessUrl("/",true).
                        permitAll()).
                oauth2Login(oauth2->
                        oauth2.
                                loginPage("/login").
                                permitAll())
        .logout(logout->
                logout.logoutSuccessUrl("/").
                        permitAll()).
                build();
    }
}
