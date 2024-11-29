package io.spring.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    public static final String COLUMN_PRODUCT_ID = "product_id";
    public static final String COLUMN_PRODUCT_NAME = "product_name";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_CATEGORY_ID = "category_id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_PRODUCT_ID)
    private int productId;

    @Column(name = COLUMN_PRODUCT_NAME, nullable = false, length = 100)
    private String productName;

    @Column(name = COLUMN_DESCRIPTION, columnDefinition = "TEXT")
    private String description;

    @Column(name = COLUMN_PRICE, nullable = false)
    private double price;

    @Column(name = COLUMN_QUANTITY, nullable = false)
    private int quantity;

    @Column(name = COLUMN_CATEGORY_ID)
    private int categoryId;

    public Product() {
    }

    public Product(String productName, String description, double price, int quantity, int categoryId) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    // Getters and Setters
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product Details:\n" +
                "------------------------------\n" +
                "Product ID     : " + productId + "\n" +
                "Name           : " + productName + "\n" +
                "Description    : " + description + "\n" +
                "Price          : " + String.format("%.2f", price) + "₹\n" +
                "Quantity       : " + quantity + "\n" +
                "Category ID    : " + categoryId + "\n" +
                "------------------------------";
    }
}
