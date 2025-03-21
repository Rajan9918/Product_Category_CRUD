package com.code.Service;

import com.code.Entity.Product;
import com.code.Exceptions.ResourceNotFoundException;
import com.code.Repository.CategoryRepository;
import com.code.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
            return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product Id = "+id+" is not found!!!!"));
    }

    public Page<Product> getAllProducts(int page) {
        return productRepository.findAll(PageRequest.of(page, 5));
    }

    public String updateProduct(Long id, Product productDetails) {
        if(productRepository.existsById(id)){
            Product product = getProductById(id);
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            product.setCategory(productDetails.getCategory());
            productRepository.save(product);
            return "Product Id = "+id+" Update Successfully......";
        }else{
            return "Update UnSuccessfull!!!!!!!\n Product Id = "+id+" Not Persent in Database";
        }

    }

    public String deleteProduct(Long id) {
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return "Product Id = "+id+" Delected  Successfully....";
        }
        else{
            return "Prodcut Id = "+id+" Delecte Unsuccessfully!!!!!";
        }
    }

    public Product getProductWithCategory(Long id) {
        Product product = getProductById(id);
        return product;
    }
}
