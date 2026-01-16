package com.example.storeapp.models;

import jakarta.persistence.*;
import lombok.*;

//(id, name, price, stock
@Data
@Entity
@AllArgsConstructor

@NoArgsConstructor(access= AccessLevel.PROTECTED, force=true)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name ;
        private Double price;
        private Integer stock ;
        @ManyToOne
        private Category category ;

}
