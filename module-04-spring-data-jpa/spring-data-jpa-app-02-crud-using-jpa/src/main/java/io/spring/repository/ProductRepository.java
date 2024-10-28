package io.spring.repository;

import io.spring.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProductRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public ProductRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Product product) {
        entityManager.persist(product);
    }

    public Product findById(Integer productId) {
        return entityManager.find(Product.class, productId);
    }

    public Product updateProduct(Product product) {
        return entityManager.merge(product);
    }

    public void deleteProductById(Integer productId) {
        Product product = findById(productId);
        if (product != null) {
            entityManager.remove(product);
        }
    }
}
