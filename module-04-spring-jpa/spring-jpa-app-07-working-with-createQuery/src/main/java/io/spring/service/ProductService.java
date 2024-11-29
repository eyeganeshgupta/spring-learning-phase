package io.spring.service;

import io.spring.entity.Product;
import io.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductByName(String productName) {
        return productRepository.findByName(productName);
    }

    public Map<String, Object> getProductDetailsByName(String productName) {
        return productRepository.findProductDetailsByName(productName);
    }

    public List<Product> getProductsByPriceGreaterThan(double price) {
        return productRepository.findProductsByPriceGreaterThan(price);
    }

    public int updateProduct(Product product) {
        return productRepository.updateProduct(product);
    }
}
