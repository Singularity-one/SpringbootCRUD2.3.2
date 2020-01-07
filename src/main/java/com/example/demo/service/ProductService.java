package com.example.demo.service;

import com.example.demo.entity.Product;

public interface ProductService {

	Product findByProductId(Integer productId);
	
	void save(Product product);
	
	void update(Product product);
	
	void delete(Integer productId);
}
