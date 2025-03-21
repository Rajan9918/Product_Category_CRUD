package com.code.Service;

import com.code.Entity.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
     Product createProduct(Product product);
     Product getProductById(Long id);
     Page<Product> getAllProducts(int page);
     String updateProduct(Long id, Product productDetails);
     String deleteProduct(Long id);
     Product getProductWithCategory(Long id);
}
