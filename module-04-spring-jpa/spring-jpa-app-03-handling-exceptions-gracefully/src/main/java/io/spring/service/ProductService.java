package io.spring.service;

import io.spring.entity.Product;
import io.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void create(Product product) {
        try {
            productRepository.save(product);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public Product read(int productId) {
        try {
            return productRepository.findById(productId);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Product update(Product product) {
        try {
            return productRepository.update(product);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean delete(int productId) {
        try {
            return productRepository.deleteById(productId);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
