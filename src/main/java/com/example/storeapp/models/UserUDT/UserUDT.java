package com.example.storeapp.models.UserUDT;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Data
@AllArgsConstructor
@UserDefinedType("user")
public class UserUDT {
    private String username;
    private String password;
}
