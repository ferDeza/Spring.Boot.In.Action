package com.example.storeapp.models;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;


import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED, force=true)
@Table("users")
public class User {
    @PrimaryKey
    private UUID id=UUID.randomUUID();
    @NotBlank
    @Size(min=5, message = "Como minimo 5 caracteres")
    private String username;
    @NotBlank
    @Size(min=6,message = "Como minimo 6 caracteres")
    private String password;
    @Email(message = "Un  Email Valido")
    private String email;
}
