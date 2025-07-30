package io.spring.controller;

import io.spring.entity.Product;
import io.spring.response.ApiResponse;
import io.spring.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/manager/products")
    public ResponseEntity<ApiResponse<Product>> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Product created", productService.create(product)));
    }

    @GetMapping("/employee/products")
    public ResponseEntity<ApiResponse<List<Product>>> getProducts() {
        return ResponseEntity.ok(new ApiResponse<>(true, "Products retrieved", productService.getAll()));
    }

    @DeleteMapping("/admin/products/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Product deleted", null));
    }

    @PutMapping("/manager/products/{id}")
    public ResponseEntity<ApiResponse<Product>> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Product updated", productService.update(id, product)));
    }
}
