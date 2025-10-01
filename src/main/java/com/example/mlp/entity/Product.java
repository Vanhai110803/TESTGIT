package com.example.mlp.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity @Table(name="Product")
@Data @NoArgsConstructor @AllArgsConstructor
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productID;

    @Column(nullable=false)
    private Double price; // DB đang là DOUBLE => giữ Double

    @Column(precision = 6, scale = 2)        // DECIMAL(6,2)
    private BigDecimal weight;               // <-- đổi sang BigDecimal

    @Column(nullable=false)
    private Integer productCategoryID;
}
