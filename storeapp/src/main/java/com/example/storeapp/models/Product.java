package com.example.storeapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

//(id, name, price, stock
@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED, force=true)
@Table(name="products")
public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name ;
        private Double price;
        private Integer stock ;
        @ManyToOne
        @JoinColumn(name = "category_id")
        private Category category;

}
