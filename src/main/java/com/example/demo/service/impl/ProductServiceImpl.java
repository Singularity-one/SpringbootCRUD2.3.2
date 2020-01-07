package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.respository.ProductRespository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	public ProductRespository productRespository;

	@Override
	public Product findByProductId(Integer productId) {
		Optional<Product> prodOpt = productRespository.findById(productId);
		return prodOpt.orElse(new Product());
	}

	@Override
	public void save(Product product) {
		productRespository.save(product);
		
	}

	@Override
	public void update(Product product) {
		productRespository.save(product);
	}

	@Override
	public void delete(Integer productId) {
		productRespository.deleteById(productId);
		
	}
}
