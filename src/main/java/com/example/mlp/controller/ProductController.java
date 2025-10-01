package com.example.mlp.controller;

import com.example.mlp.entity.ProductCategoryTranslation;
import com.example.mlp.service.CatalogService;
import jakarta.validation.constraints.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Validated
public class ProductController {
    private final CatalogService svc;
    public ProductController(CatalogService svc){ this.svc = svc; }

    @GetMapping({"/", "/products"})
    public String products(@RequestParam(name = "lang", defaultValue = "en") String lang,
                           Model model){
        model.addAttribute("lang", lang);
        model.addAttribute("languages", svc.allLanguages());
        model.addAttribute("items", svc.listProducts(lang));
        return "products";
    }

    @GetMapping("/products/new")
    public String newForm(@RequestParam(name = "lang", defaultValue = "en") String lang, Model model){
        List<ProductCategoryTranslation> cats = svc.categoriesByLang(lang);
        model.addAttribute("lang", lang);
        model.addAttribute("categories", cats);
        return "product_form";
    }

    public static record NewProduct(
            @NotNull Double price,
            @NotNull Double weight,
            @NotNull Integer categoryId,
            @NotBlank String lang,
            @NotBlank String name,
            String desc){}

    @PostMapping("/products")
    public String create(@ModelAttribute NewProduct form){
        svc.createProduct(form.price(), form.weight(), form.categoryId(),
                form.lang(), form.name(), form.desc());
        return "redirect:/products?lang=" + form.lang();
    }
}
