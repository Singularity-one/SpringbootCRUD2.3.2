package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Customer;

public interface CustomerService {

	Customer findByCustomerId(Integer customerId);

	void save(Customer costomer);
	
	void delete (Integer customerId);

	List<Customer> findAll();
	
	List<Customer> findBySpecificColumn(Customer costomer);

	List<Customer> findByAge(Map<String,String> map);

	//名字查詢
	List<Customer> findByName(String name);
	
	//名字模糊查詢
	List<Customer> findByNameLike(String name);
		
	//查詢SQL
	List<Customer> findBySQL(String name,String addr);

	//刪除SQL
	void deleteBySQL(String customerId);
	
	
	//登入@Query
	Customer findBySQL2(String name,String tel);
	
	//查最後一筆
	Customer findByEnd();
	
	//用SQL找id
	List<Customer> findSQL(String customerId);


}
