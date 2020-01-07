package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerRequest;
import com.example.demo.dto.CustomerResponse;
import com.example.demo.dto.CustomerResponseBody;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class login {
	
	@Autowired
	public CustomerService customerService;
	

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public  CustomerResponse login(@RequestBody CustomerRequest request) {
		
		
		
		System.out.println("login");
		System.out.println(request.getBody().getName());
		System.out.println(request.getBody().getTel());
		
		CustomerResponse response = new CustomerResponse();
		CustomerResponseBody body = new CustomerResponseBody();
		List<Customer> dataList = customerService.findByName(request.getBody().getName());
		
		Customer customer =dataList.get(0);
		
		if(dataList.isEmpty()) {
			body.setReturnCode("查無此人");
		}else{
			if(request.getBody().getTel().equals(customer.getTel())) {
				body.setReturnCode("0000");
			}else {
				body.setReturnCode("電話不對");
			}
		}
		
		
		body.setDataList(dataList);
		response.setBody(body);

		return response;
	}
	

}
