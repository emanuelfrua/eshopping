package com.hackerrank.eshopping.product.dashboard.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/products")
public class ProductsController {
    
   
	@RequestMapping(value = "/", method = RequestMethod.POST) 
	public String createProduct() {
	    return "201";
	}
	
}
