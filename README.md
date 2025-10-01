# Multi-language Product Demo (Spring Boot + MySQL)

Features (2+):
1) List products in a selected language (JOIN: Product + ProductTranslation + ProductCategoryTranslation).
2) Create a product and its translation in the chosen language.

## Run locally (IntelliJ)
1. Create DB:
   ```sql
   CREATE DATABASE mlp_demo CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   USE mlp_demo;
   SOURCE src/main/resources/schema.sql;
   SOURCE src/main/resources/data.sql;
   ```
2. Update `src/main/resources/application.properties` with your MySQL user/pass.
3. In IntelliJ: Open as Maven project -> Run `MultiLangProductDemoApplication`.
4. Visit: http://localhost:8088/products?lang=en  (switch to `vi` in dropdown).

## Tech
- Java 17, Spring Boot 3, Thymeleaf, Spring Data JPA, MySQL.
- Entities mirror the 5-table schema.
- `CatalogService` composes localized view models.

## Notes
- DDL uses simple FKs; in JPA entities we keep ids to reduce mapping complexity for a small demo.
- Add other languages by inserting into `Language` and translation tables.
