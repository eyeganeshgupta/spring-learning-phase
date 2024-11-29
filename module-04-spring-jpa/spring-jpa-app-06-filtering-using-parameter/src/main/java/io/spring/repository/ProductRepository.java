package io.spring.repository;

import io.spring.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
        Query query = entityManager.createNativeQuery("SELECT * FROM products", Product.class);
        return query.getResultList();
    }

    /**
     * Finds a product by its name.
     *
     * @param productName the name of the product to search for.
     * @return the found product or null if not found.
     */
    public Product findByName(String productName) {
        Query query = entityManager.createNativeQuery("SELECT * FROM products WHERE product_name = ?", Product.class);
        query.setParameter(1, productName);
        try {
            return (Product) query.getSingleResult();
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
        Query query = entityManager.createNativeQuery("SELECT product_id, description, price FROM products WHERE product_name = ?");
        query.setParameter(1, productName);

        try {
            Object[] result = (Object[]) query.getSingleResult();

            Map<String, Object> details = new HashMap<>();
            details.put("productId", result[0]);
            details.put("description", result[1]);
            details.put("price", result[2]);

            return details; // Return the details map
        } catch (NoResultException e) {
            return Collections.emptyMap(); // Return empty map if no product is found
        }
    }
}
