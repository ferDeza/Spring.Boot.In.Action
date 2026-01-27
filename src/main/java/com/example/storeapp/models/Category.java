package com.example.storeapp.models;

import jakarta.persistence.*;
import lombok.*;


import java.util.UUID;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED, force=true)
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
