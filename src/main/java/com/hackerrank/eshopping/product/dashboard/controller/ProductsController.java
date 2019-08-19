package com.hackerrank.eshopping.product.dashboard.controller;

import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
public class ProductsController {

    // TODO: SERIALIZATION, COMPARATOR
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    private ResponseEntity<Object> getAllProducts() {

        List<Product> products = productService.getAllProducts();
//        Collections.sort(products);

        return new ResponseEntity<>(
                   null ,
                    HttpStatus.OK);
    }
    @RequestMapping(value = "/products/{product_id}", method = RequestMethod.GET)
    private ResponseEntity<Object> getProduct(@PathVariable("product_id") long id) {

        Product product = productService.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>(
                    "Product Id doesn't exist",
                    HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(
                    product,
                    HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/products?category={category}", method = RequestMethod.GET)
    private ResponseEntity<Object> getProductsByCategory(@PathVariable("category") String category) {

        Product product = productService.getProductById(2);
        if (product == null) {
            return new ResponseEntity<>(
                    "Product Id doesn't exist",
                    HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(
                    product,
                    HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/products/{product_id}", method = RequestMethod.PUT)
    private ResponseEntity<Object> updateProduct(@RequestBody Product newProduct, @PathVariable("product_id") long id) {

        Product oldProduct = productService.getProductById(id);
        if (oldProduct == null) {
            return new ResponseEntity<>(
                    "Product Id doesn't exist. Nothing to update",
                    HttpStatus.BAD_REQUEST);
        } else {
            double newRetailPrice = newProduct.getRetail_price();
            double newdiscountedPrice = newProduct.getDiscounted_price();
            boolean newAvailability = newProduct.getAvailability();

            oldProduct.setRetail_price(newRetailPrice);
            oldProduct.setDiscounted_price(newdiscountedPrice);
            oldProduct.setAvailability(newAvailability);
            productService.saveOrUpdate(oldProduct);

            return new ResponseEntity<>(
                    "Product updated successfully",
                    HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    private ResponseEntity<Object> create(@RequestBody Product product) {

        if (productService.getProductById(product.getId()) == null) {
            productService.saveOrUpdate(product);
            return new ResponseEntity<>(
                    "New product created successfully",
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(
                    "Product Id already exists",
                    HttpStatus.BAD_REQUEST);
        }
    }


}
