package com.hackerrank.eshopping.product.dashboard.service;

import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList();
        productRepository.findAll().forEach(product -> products.add(product));
        return products;
    }

    public Product getProductById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(Product product) {
        productRepository.save(product);
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> products = new ArrayList();
        productRepository.findProductsByCategory(category).forEach(product -> products.add(product));
        return products;
    }

    public void delete(long id) {
        productRepository.deleteById(id);
    }

}
