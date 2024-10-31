package io.spring.repository;

import io.spring.entity.Product;
import jakarta.persistence.EntityManager;
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

    public List<Product> findAllProducts() {
        Query query = entityManager.createNativeQuery("SELECT * FROM products", Product.class);
        return query.getResultList();
    }
}
