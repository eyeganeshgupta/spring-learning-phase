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
        productRepository.save(product);
    }

    public Product read(int productId) {
        return productRepository.findById(productId);
    }

    public Product update(Product product) {
        return productRepository.update(product);
    }

    public boolean delete(int productId) {
        return productRepository.deleteById(productId);
    }
}
