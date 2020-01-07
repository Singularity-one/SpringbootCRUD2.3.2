package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Merchant;
import com.example.demo.entity.Product;
import com.example.demo.respository.MerchantRespository;
import com.example.demo.respository.ProductRespository;
import com.example.demo.service.MerchantService;
import com.example.demo.service.ProductService;

@Service
public class MerchantServiceImpl implements MerchantService {
	
	@Autowired
	public MerchantRespository merchantRespository;


	@Override
	public void save(Merchant merchant) {
		merchantRespository.save(merchant);
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer productId) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Merchant> findAll() {
		return merchantRespository.findAll();
	}

	@Override
	public List<Merchant> findByName(String name) {
		return merchantRespository.findByName(name);
	}

	@Override
	public Merchant findByMerchantId(String merchantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Merchant> findSQL(String merchantId) {
		return merchantRespository.findSQL(merchantId);
	}

	@Override
	public List<Merchant> findBySpecificColumn(Merchant merchant) {
		
		return merchantRespository.findBySpecificColumn(
				merchant.getMerchantId()
				,merchant.getName()
				,merchant.getTel()
				,merchant.getAddr());
		
	}

	@Override
	public List<Merchant> findSQL2(String merchantId, String name) {
		return merchantRespository.findSQL2(merchantId,name);
	}
	
	

	
}
