package com.example.mlp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name="Language")
@Data @NoArgsConstructor @AllArgsConstructor
public class Language {
    @Id
    @Column(length=2)
    private String languageID; // e.g., 'en', 'vi'

    @Column(length=20, nullable=false)
    private String language;
}
