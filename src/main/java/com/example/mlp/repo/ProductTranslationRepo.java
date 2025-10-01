package com.example.mlp.repo;
import com.example.mlp.entity.ProductTranslation;
import com.example.mlp.entity.ProductTranslationId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductTranslationRepo extends JpaRepository<ProductTranslation, ProductTranslationId> {
    List<ProductTranslation> findByLanguageID(String languageID);
}
