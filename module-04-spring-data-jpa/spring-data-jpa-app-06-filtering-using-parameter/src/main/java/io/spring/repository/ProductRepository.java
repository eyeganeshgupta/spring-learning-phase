package io.spring.repository;

import io.spring.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
