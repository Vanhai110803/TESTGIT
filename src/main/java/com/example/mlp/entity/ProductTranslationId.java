package com.example.mlp.entity;

import lombok.*;
import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductTranslationId implements Serializable {
    private Integer productID;
    private String languageID;
}
