package com.example.mlp.repo;
import com.example.mlp.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepo extends JpaRepository<Language, String> {}
