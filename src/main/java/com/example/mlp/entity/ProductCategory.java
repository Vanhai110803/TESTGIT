package com.example.mlp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name="ProductCategory")
@Data @NoArgsConstructor @AllArgsConstructor
public class ProductCategory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productCategoryID;

    @Column(nullable=false)
    private Boolean canBeShipped = true;
}
