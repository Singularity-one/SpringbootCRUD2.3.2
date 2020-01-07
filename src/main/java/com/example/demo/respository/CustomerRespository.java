package com.example.demo.respository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Customer;

@Repository
public interface CustomerRespository extends JpaRepository<Customer, Integer> {

//	@Query(value ="select CUSTOMER_ID, NAME, ADDR, AGE, TEL " +
//			"from CUSTOMER_NEW where " + 
//			"CUSTOMER_ID = (case when :customerId = '' then CUSTOMER_ID else :customerId end)"+ 
//			"and (NAME = (case when :name = '' then NAME else :name end))" +
//			"and (ADDR = (case when :addr = '' then ADDR else :addr end))" +
//			"and (AGE = (case when :age = '' then AGE else :age end))" +
//			"and (TEL = (case when :tel = '' then TEL else :tel end))"
//			, nativeQuery = true)
//	List<Customer> findBySpecificColumn(
//			@Param("customerId") String customerId 
//			, @Param("name") String name
//			, @Param("addr") String addr
//			, @Param("age") String age
//			, @Param("tel") String tel
//			);
	
	
	@Query(value ="select CUSTOMER_ID, NAME, ADDR, AGE, TEL " +
			"from CUSTOMER_NEW where " + 
			"CUSTOMER_ID = (case when :customerId = 'null' then CUSTOMER_ID else :customerId end)"+ 
			"and (NAME = (case when :name = 'null' then NAME else :name end))" +
			"and (ADDR = (case when :addr = 'null' then ADDR else :addr end))" +
			"and (AGE = (case when :age = 'null' then AGE else :age end))" +
			"and (TEL = (case when :tel = 'null' then TEL else :tel end))"
			, nativeQuery = true)
	List<Customer> findBySpecificColumn(
			@Param("customerId") String customerId 
			, @Param("name") String name
			, @Param("addr") String addr
			, @Param("age") String age
			, @Param("tel") String tel
			);

	@Query(value= "select customer_ID,NAME,ADDR,AGE,TEL"
			+ " from CUSTOMER_NEW where AGE >= :ageUp and AGE <= :ageDown"
			,nativeQuery=true)
	List<Customer> findByAge(
			@Param("ageUp")Integer ageUp
			, @Param("ageDown")Integer ageDown);
	
	


	//用名子查
	List<Customer> findByName(String name);
	
	
	//用名子模糊查
	List<Customer> findByNameLike(String name);
	
	//@Query查詢
	@Query(value = "select * from CUSTOMER_NEW  where name = ? and addr = ?", nativeQuery = true)
	List<Customer> findBySQL(@Param("name") String name,  @Param("addr") String addr);
	
	
	//@Query查詢
	@Transactional
	@Modifying
	@Query(value = "delete from CUSTOMER_NEW where CUSTOMER_ID = ?", nativeQuery = true)
	void deleteBySQL(@Param("customerId") String customerId);
	
	
	//登入@Query
	@Query(value = "select * from CUSTOMER_NEW  where name = ? and tel = ?", nativeQuery = true)
	Customer findBySQL2(@Param("name") String name,  @Param("tel") String tel);
	
	//最後一筆
	@Query(value = "SELECT CUSTOMER_ID,NAME,ADDR,AGE,TEL FROM CUSTOMER_NEW ORDER BY CUSTOMER_ID DESC LIMIT 0 , 1", nativeQuery = true)
	Customer findByEnd();
	
	
	//用SQL找id
	@Query(value = "select * from CUSTOMER_NEW  where CUSTOMER_ID = ?", nativeQuery = true)
	List<Customer> findSQL(@Param("customerId") String customerId);
	


}
