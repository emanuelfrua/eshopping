package com.hackerrank.eshopping.product.dashboard.repository;

import com.hackerrank.eshopping.product.dashboard.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findProductsByCategory(String category);

    List<Product> findProductsByCategoryAndAvailability(String category, boolean availability);
}
