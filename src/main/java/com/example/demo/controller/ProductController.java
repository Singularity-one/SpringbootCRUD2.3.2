package com.example.demo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CommonHeader;
import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.dto.ProductResponseBody;
//import com.example.demo.dto.ProductSaveRequest;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	public ProductService productService;
	
	@PostMapping(value = "/prod", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ProductResponse prod(@RequestBody ProductRequest request) {
		System.out.println(request);
		
		ProductResponse response = new ProductResponse();
		ProductResponseBody responseBody = new ProductResponseBody();
		
		CommonHeader header = new CommonHeader();
		BeanUtils.copyProperties(request.getHeader(), header);
		response.setHeader(header);
		
		Product product = productService.findByProductId(request.getBody().getProductId());
		BeanUtils.copyProperties(product, responseBody);
		
		response.setBody(responseBody);
		return response;
	}
	
//	@PostMapping(value = "/prod/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ResponseBody
//	public ProductResponse save(@RequestBody ProductSaveRequest request) {
//		System.out.println(request);
//		
//		ProductResponse response = new ProductResponse();
//		ProductResponseBody responseBody = new ProductResponseBody();
//		
//		CommonHeader header = new CommonHeader();
//		BeanUtils.copyProperties(request.getHeader(), header);
//		response.setHeader(header);
//		
//		Product product = new Product();
//		BeanUtils.copyProperties(request.getBody(), product);
//		
//		productService.save(product);
//		return response;
//	}
	
//	@PostMapping(value = "/prod/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ResponseBody
//	public ProductResponse update(@RequestBody ProductSaveRequest request) {
//		System.out.println(request);
//		
//		ProductResponse response = new ProductResponse();
//		ProductResponseBody responseBody = new ProductResponseBody();
//		
//		CommonHeader header = new CommonHeader();
//		BeanUtils.copyProperties(request.getHeader(), header);
//		response.setHeader(header);
//		
//		Product product = new Product();
//		BeanUtils.copyProperties(request.getBody(), product);
//		
//		productService.save(product);
//		return response;
//	}
	
	@PostMapping(value = "/prod/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ProductResponse delete(@RequestBody ProductRequest request) {
		System.out.println(request);
		
		ProductResponse response = new ProductResponse();
		
		CommonHeader header = new CommonHeader();
		BeanUtils.copyProperties(request.getHeader(), header);
		response.setHeader(header);
		
		productService.delete(request.getBody().getProductId());

		return response;
	}
}
