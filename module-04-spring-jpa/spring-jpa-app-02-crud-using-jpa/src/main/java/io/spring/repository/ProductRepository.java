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
    private EntityManager entityManager;

    public void save(Product product) {
        entityManager.persist(product);
    }

    public Product findById(Integer productId) {
        return entityManager.find(Product.class, productId);
    }

    public Product update(Product product) {
        return entityManager.merge(product);
    }

    public boolean deleteById(Integer productId) {
        Product product = findById(productId);
        if (product != null) {
            entityManager.remove(product);
            return true;
        }
        return false;
    }
}
