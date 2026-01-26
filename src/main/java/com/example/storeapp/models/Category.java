package com.example.storeapp.models;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@AllArgsConstructor

@NoArgsConstructor(access= AccessLevel.PROTECTED, force=true)
@Table("categories")
public class Category {
    @PrimaryKey
    private UUID id= UUID.randomUUID() ;
    private String name;
}
