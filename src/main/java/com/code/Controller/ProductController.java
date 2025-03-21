package com.code.Controller;

import com.code.Entity.Product;
import com.code.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

// ProductController.java
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<Product> getProducts(@RequestParam(defaultValue = "0") int page) {
        return productService.getAllProducts(page);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductWithCategory(id);
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
       return productService.deleteProduct(id);
    }
}
