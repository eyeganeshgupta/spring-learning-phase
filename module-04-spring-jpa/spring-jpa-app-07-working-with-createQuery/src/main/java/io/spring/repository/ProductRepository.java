package io.spring.repository;

import io.spring.entity.Product;
import jakarta.persistence.*;

import java.util.Collections;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Fetches all products from the database.
     *
     * @return List of products.
     */
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p", Product.class);
        return query.getResultList();
    }

    /**
     * Finds a product by its name.
     *
     * @param productName the name of the product to search for.
     * @return the found product or null if not found.
     */
    public Product findByName(String productName) {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p WHERE p.productName = :productName", Product.class);
        query.setParameter("productName", productName);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No product found with name: " + productName);
            return null;
        }
    }

    /**
     * Retrieves detailed information about a product by its name.
     *
     * @param productName the name of the product to search for.
     * @return a Map with product details or empty map if not found.
     */
    public Map<String, Object> findProductDetailsByName(String productName) {
        TypedQuery<Object[]> query = entityManager.createQuery("SELECT p.id, p.description, p.price FROM Product p WHERE p.productName = :productName", Object[].class);
        query.setParameter("productName", productName);

        try {
            Object[] result = query.getSingleResult();

            Map<String, Object> details = new HashMap<>();
            details.put("productId", result[0]);
            details.put("description", result[1]);
            details.put("price", result[2]);

            return details; // Return the details map
        } catch (NoResultException e) {
            return Collections.emptyMap(); // Return empty map if no product is found
        }
    }

    /**
     * Finds all products with a price greater than the specified amount.
     *
     * @param price the price threshold to compare against.
     * @return a list of products with a price greater than the specified amount, or an empty list if none are found.
     */
    public List<Product> findProductsByPriceGreaterThan(double price) {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p WHERE p.price > :price", Product.class);
        query.setParameter("price", price);
        return query.getResultList(); // Returns an empty list if no products are found
    }

    /**
     * Updates an existing product in the database using a JPQL update query.
     *
     * @param product the product entity with updated values.
     * @return the number of updated records.
     */
    public int updateProduct(Product product) {
        String jpql = "UPDATE Product p SET p.productName = :productName, p.description = :description, p.price = :price WHERE p.id = :id";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("productName", product.getProductName());
        query.setParameter("description", product.getDescription());
        query.setParameter("price", product.getPrice());
        query.setParameter("id", product.getId());

        return query.executeUpdate(); // Returns the number of updated records
    }
}
