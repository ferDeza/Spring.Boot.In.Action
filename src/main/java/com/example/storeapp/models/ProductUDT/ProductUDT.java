package com.example.storeapp.models.ProductUDT;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;
@Data
@AllArgsConstructor
@UserDefinedType("product")
public class ProductUDT {
    private String name;
    private Double price;
}
