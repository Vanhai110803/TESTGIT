package com.example.mlp.repo;
import com.example.mlp.entity.ProductCategoryTranslation;
import com.example.mlp.entity.ProductCategoryTranslationId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductCategoryTranslationRepo extends JpaRepository<ProductCategoryTranslation, ProductCategoryTranslationId> {
    List<ProductCategoryTranslation> findByLanguageID(String languageID);
}
