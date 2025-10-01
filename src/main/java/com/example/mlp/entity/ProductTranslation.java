package com.example.mlp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name="ProductTranslation")
@Data @NoArgsConstructor @AllArgsConstructor
@IdClass(ProductTranslationId.class)
public class ProductTranslation {
    @Id
    private Integer productID;
    @Id
    @Column(length=2)
    private String languageID;

    @Column(length=100, nullable=false)
    private String productName;

    @Column(length=100)
    private String productDescription;
}
