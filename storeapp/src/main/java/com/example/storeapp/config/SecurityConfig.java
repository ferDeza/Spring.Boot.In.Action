package com.example.storeapp.config;
import com.example.storeapp.models.User;
import com.example.storeapp.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
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
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.
                authorizeHttpRequests(
                        authorizeRequests ->authorizeRequests
                                .anyRequest().authenticated()
                ).oauth2Login(oAuth2Login ->oAuth2Login
                        .loginPage("/oauth2/authorization/storeapp-admin-client")).
                oauth2Client(Customizer.withDefaults()).build();
    }
    /*@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/api/orders/**", "/api/products/**", "/api/users/**").
                        hasRole("USER")
                        .requestMatchers("/", "/login", "/register", "/css/**", "/js/**").
                        permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/oauth2/authorization/storeapp-admin-client")
                        // Esto asegura que si no hay sesión, use el cliente de OAuth2
                        .defaultSuccessUrl("/", true)
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                        .permitAll()
                )
                .build();
    }*/
}
