package com.example.storeapp.models;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.example.storeapp.models.ProductUDT.ProductUDT;
import com.example.storeapp.models.UserUDT.UserUDT;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
@Data
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED, force=true)
@Table("orders")
public class ProductOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @PrimaryKey
    private UUID id = Uuids.timeBased();
    private String username;
    private Date placeAt;
    private UserUDT user;
    private List<ProductUDT> products=new ArrayList<>();
    public void addProduct(ProductUDT product) {
        this.products.add(product);
    }
}
