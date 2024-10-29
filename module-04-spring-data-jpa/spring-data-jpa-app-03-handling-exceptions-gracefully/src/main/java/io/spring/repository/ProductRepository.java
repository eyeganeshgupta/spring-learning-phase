package io.spring.repository;

import io.spring.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Product product) {
        try {
            entityManager.persist(product);
        } catch (PersistenceException e) {
            throw new RuntimeException("Error saving product: " + e.getMessage(), e);
        }
    }

    public Product findById(Integer productId) {
        try {
            return entityManager.find(Product.class, productId);
        } catch (PersistenceException e) {
            throw new RuntimeException("Error finding product with ID " + productId + ": " + e.getMessage(), e);
        }
    }

    public Product update(Product product) {
        try {
            return entityManager.merge(product);
        } catch (PersistenceException e) {
            throw new RuntimeException("Error updating product: " + e.getMessage(), e);
        }
    }

    public boolean deleteById(Integer productId) {
        try {
            Product product = findById(productId);
            if (product != null) {
                entityManager.remove(product);
                return true;
            }
            return false;
        } catch (PersistenceException e) {
            throw new RuntimeException("Error deleting product with ID " + productId + ": " + e.getMessage(), e);
        }
    }
}
