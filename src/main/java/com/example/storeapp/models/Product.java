package com.example.storeapp.models;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

//(id, name, price, stock
@Data
@AllArgsConstructor

@NoArgsConstructor(access= AccessLevel.PROTECTED, force=true)
@Table("products")
public class Product {
    @PrimaryKey

        private UUID id=UUID.randomUUID();
        private String name ;
        private Double price;
        private Integer stock ;
        private UUID categoryId;
}
