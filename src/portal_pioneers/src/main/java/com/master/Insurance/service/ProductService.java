package com.master.Insurance.service;

import com.master.Insurance.entity.Product;
import com.master.Insurance.exception.ResourceNotFoundException;
import com.master.Insurance.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) throws ResourceNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) throws ResourceNotFoundException {
        Product product = getProductById(id);
        product.setName(productDetails.getName());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) throws ResourceNotFoundException {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}

