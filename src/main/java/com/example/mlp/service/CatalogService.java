package com.example.mlp.service;

import com.example.mlp.entity.*;
import com.example.mlp.repo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
public class CatalogService {
    private final ProductRepo productRepo;
    private final ProductTranslationRepo productTrRepo;
    private final ProductCategoryRepo categoryRepo;
    private final ProductCategoryTranslationRepo categoryTrRepo;
    private final LanguageRepo languageRepo;

    public CatalogService(ProductRepo productRepo,
                          ProductTranslationRepo productTrRepo,
                          ProductCategoryRepo categoryRepo,
                          ProductCategoryTranslationRepo categoryTrRepo,
                          LanguageRepo languageRepo) {
        this.productRepo = productRepo;
        this.productTrRepo = productTrRepo;
        this.categoryRepo = categoryRepo;
        this.categoryTrRepo = categoryTrRepo;
        this.languageRepo = languageRepo;
    }

    public List<Language> allLanguages() {
        return languageRepo.findAll();
    }

    public Map<String, String> categoryMap(String lang) {
        Map<String, String> map = new HashMap<>();
        for (ProductCategoryTranslation t : categoryTrRepo.findByLanguageID(lang)) {
            map.put(String.valueOf(t.getProductCategoryID()), t.getCategoryName());
        }
        return map;
    }

    // Dùng BigDecimal cho weight để khớp DECIMAL(6,2)
    public record LocalizedProduct(
            Integer id, Double price, BigDecimal weight,
            String categoryName, String name, String description) {}

    public List<LocalizedProduct> listProducts(String lang) {
        Map<String, String> catMap = categoryMap(lang);
        Map<Integer, ProductTranslation> trMap = new HashMap<>();
        for (ProductTranslation t : productTrRepo.findByLanguageID(lang)) {
            trMap.put(t.getProductID(), t);
        }

        List<LocalizedProduct> result = new ArrayList<>();
        for (Product p : productRepo.findAll()) {
            ProductTranslation t = trMap.get(p.getProductID());
            String cname = catMap.get(String.valueOf(p.getProductCategoryID()));

            BigDecimal w = (p.getWeight() == null) ? BigDecimal.ZERO : p.getWeight();

            result.add(new LocalizedProduct(
                    p.getProductID(),
                    p.getPrice(),
                    w,
                    (cname == null ? ("Cat#" + p.getProductCategoryID()) : cname),
                    (t == null ? ("Product#" + p.getProductID()) : t.getProductName()),
                    (t == null ? "" : Optional.ofNullable(t.getProductDescription()).orElse(""))
            ));
        }
        return result;
    }

    @Transactional
    public Product createProduct(Double price, Double weight, Integer categoryId,
                                 String lang, String name, String desc) {
        Product p = new Product();
        p.setPrice(price);
        // Entity Product.weight là BigDecimal ⇒ convert từ Double sang BigDecimal
        p.setWeight(weight == null ? null : BigDecimal.valueOf(weight));
        p.setProductCategoryID(categoryId);

        p = productRepo.save(p);

        ProductTranslation tr = new ProductTranslation(p.getProductID(), lang, name, desc);
        productTrRepo.save(tr);

        return p;
    }

    public List<ProductCategoryTranslation> categoriesByLang(String lang) {
        return categoryTrRepo.findByLanguageID(lang);
    }
}
