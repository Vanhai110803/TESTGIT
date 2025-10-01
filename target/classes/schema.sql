-- MySQL schema for Multi-language Product demo
DROP TABLE IF EXISTS ProductTranslation;
DROP TABLE IF EXISTS ProductCategoryTranslation;
DROP TABLE IF EXISTS Product;
DROP TABLE IF EXISTS ProductCategory;
DROP TABLE IF EXISTS Language;

CREATE TABLE Language (
  LanguageID CHAR(2) PRIMARY KEY,
  Language VARCHAR(20) NOT NULL
);

CREATE TABLE ProductCategory (
  ProductCategoryID INT AUTO_INCREMENT PRIMARY KEY,
  CanBeShipped BIT NOT NULL
);

CREATE TABLE Product (
  ProductID INT AUTO_INCREMENT PRIMARY KEY,
  Price DOUBLE NOT NULL,
  Weight DECIMAL(6,2),
  ProductCategoryID INT NOT NULL,
  FOREIGN KEY (ProductCategoryID) REFERENCES ProductCategory(ProductCategoryID)
);

CREATE TABLE ProductTranslation (
  ProductID INT NOT NULL,
  LanguageID CHAR(2) NOT NULL,
  ProductName VARCHAR(100) NOT NULL,
  ProductDescription VARCHAR(100),
  PRIMARY KEY (ProductID, LanguageID),
  FOREIGN KEY (ProductID) REFERENCES Product(ProductID),
  FOREIGN KEY (LanguageID) REFERENCES Language(LanguageID)
);

CREATE TABLE ProductCategoryTranslation (
  ProductCategoryID INT NOT NULL,
  LanguageID CHAR(2) NOT NULL,
  CategoryName VARCHAR(100) NOT NULL,
  PRIMARY KEY (ProductCategoryID, LanguageID),
  FOREIGN KEY (ProductCategoryID) REFERENCES ProductCategory(ProductCategoryID),
  FOREIGN KEY (LanguageID) REFERENCES Language(LanguageID)
);
