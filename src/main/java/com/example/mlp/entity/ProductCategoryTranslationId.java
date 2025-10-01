package com.example.mlp.entity;

import lombok.*;
import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductCategoryTranslationId implements Serializable {
    private Integer productCategoryID;
    private String languageID;
}
