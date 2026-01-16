package com.example.storeapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED, force=true)
public class ProductOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date placeAt;
    @PrePersist
    protected void onCreate() {
        placeAt = new Date();
    }
    @ManyToOne(cascade = CascadeType.MERGE)
    private User user;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private List<Product> products=new ArrayList<>();
    public void addProduct(Product product) {
        products.add(product);
    }
}
