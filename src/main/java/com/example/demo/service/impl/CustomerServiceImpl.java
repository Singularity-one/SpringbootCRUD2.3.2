package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.respository.CustomerRespository;
import com.example.demo.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	public CustomerRespository customerRespository;

	@Override
	public Customer findByCustomerId(Integer customerId) {
		Optional<Customer> customerOpt = customerRespository.findById(customerId);
		return customerOpt.orElse(new Customer());
	}

	@Override
	public void save(Customer costomer) {
		
		customerRespository.save(costomer);
		
	}

	@Override
	public void delete(Integer customerId) {
		customerRespository.deleteById(customerId);
		
	}

	@Override
	public List<Customer> findBySpecificColumn(Customer costomer) {

		return customerRespository.findBySpecificColumn(
				costomer.getCustomerId(), costomer.getName(), costomer.getAddr()
				, costomer.getAge(),costomer.getTel());
	}

	@Override
	public List<Customer> findAll() {
		return customerRespository.findAll();
	}

	@Override
	public List<Customer> findByAge(Map<String, String> map) {
		return customerRespository.findByAge(
				Integer.parseInt(map.get("ageUp"))
				,Integer.parseInt(map.get("ageDown")));
	}
	
	
	
	//名字查詢
	@Override
	public List<Customer> findByName(String name) {
			return customerRespository.findByName(name);
	}
	
	
	//名字模糊查詢
	@Override
	public List<Customer> findByNameLike(String name) {
		return customerRespository.findByNameLike(name);
	}

	//查詢SQL
	@Override
	public List<Customer> findBySQL(String name, String addr) {
		return customerRespository.findBySQL(name,addr);
	}

	//刪除SQL
	@Override
	public void deleteBySQL(String customerId) {
		customerRespository.deleteBySQL(customerId);
		
	}
	
	
	//登入查詢SQL
	@Override
	public Customer findBySQL2(String name, String tel) {
			return customerRespository.findBySQL2(name,tel);
	}

	
	//最後一筆
	@Override
	public Customer findByEnd() {
		Customer customer = customerRespository.findByEnd();
		return customer;
	}
	
	
	//最後一筆
	@Override
	public List<Customer> findSQL(String customerId) {
		return customerRespository.findSQL(customerId);
	}

	







}
