package com.example.mlp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name="ProductCategoryTranslation")
@Data @NoArgsConstructor @AllArgsConstructor
@IdClass(ProductCategoryTranslationId.class)
public class ProductCategoryTranslation {
    @Id
    private Integer productCategoryID;

    @Id
    @Column(length=2)
    private String languageID;

    @Column(length=100, nullable=false)
    private String categoryName;
}
