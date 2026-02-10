package com.example.storeapp.models;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED, force=true)
@Entity
@Table(name="orders")
public class ProductOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Temporal(TemporalType.TIMESTAMP)
    private Date placeAt;

    @ManyToOne

    @JoinColumn(name="user_id")
    private User user;
    @ManyToMany
    @JoinTable(
            name="order_products",
            joinColumns = @JoinColumn(name="order_id"),
            inverseJoinColumns=@JoinColumn(name="product_id")
    )
    private List<Product> products=new ArrayList<>();
    public void addProduct(Product product) {
        this.products.add(product);
    }
}
