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
import com.example.demo.entity.Merchant;

@Repository
public interface MerchantRespository extends JpaRepository<Merchant, Integer> {

	
	Merchant findByMerchantId(String merchantId);

	//用名子查
	List<Merchant> findByName(String name);
	
	
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
	@Query(value = "select * from MERCHANT  where MERCHANTID = ?", nativeQuery = true)
	List<Merchant> findSQL(@Param("merchantId") String merchantId);
	
	
	//用SQL找id和name
	@Query(value = "select * from MERCHANT m  where m.MERCHANTID = :merchantId AND m.name=:name", nativeQuery = true)
	List<Merchant> findSQL2(@Param("merchantId") String merchantId,@Param("name") String name);
	
	
	
	//複合查詢
	@Query(value ="select MERCHANTID, NAME, TEL, ADDR, PIC " +
			"from MERCHANT where " + 
			"MERCHANTID = (case when :merchantId = 'null' then MERCHANTID else :merchantId end)"
			+"AND (NAME = (case when :name = 'null' then NAME else :name end))"
			+"AND (TEL = (case when :tel = 'null' then TEL else :tel end))"
			+"AND (ADDR = (case when :addr = 'null' then ADDR else :addr end))" 
			, nativeQuery = true)
	List<Merchant> findBySpecificColumn(
			@Param("merchantId") String merchantId 
			, @Param("name") String name
			, @Param("tel") String tel
			, @Param("addr") String addr
	);
	
	
	


}
