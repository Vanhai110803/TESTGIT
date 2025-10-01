-- Seed data
INSERT INTO Language(LanguageID, Language) VALUES
('en','English'),
('vi','Tiếng Việt');

INSERT INTO ProductCategory(ProductCategoryID, CanBeShipped) VALUES
(1, b'1'),
(2, b'1'),
(3, b'0');

INSERT INTO ProductCategoryTranslation(ProductCategoryID, LanguageID, CategoryName) VALUES
(1,'en','OTC'),
(1,'vi','Không kê đơn'),
(2,'en','Prescription'),
(2,'vi','Kê đơn'),
(3,'en','Supplement'),
(3,'vi','Thực phẩm chức năng');

INSERT INTO Product(ProductID, Price, Weight, ProductCategoryID) VALUES
(1, 2.50, 0.10, 1),
(2, 10.00, 0.20, 2),
(3, 5.75, 0.15, 3);

INSERT INTO ProductTranslation(ProductID, LanguageID, ProductName, ProductDescription) VALUES
(1,'en','Paracetamol 500mg','Pain & fever relief'),
(1,'vi','Paracetamol 500mg','Giảm đau, hạ sốt'),
(2,'en','Amoxicillin 500mg','Antibiotic'),
(2,'vi','Amoxicillin 500mg','Kháng sinh'),
(3,'en','Vitamin C 1000mg','Immune support'),
(3,'vi','Vitamin C 1000mg','Hỗ trợ miễn dịch');
