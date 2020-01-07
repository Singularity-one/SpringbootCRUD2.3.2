package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CommonHeader;
import com.example.demo.dto.CustomerRequest;
import com.example.demo.dto.CustomerResponse;
import com.example.demo.dto.CustomerResponseBody;
import com.example.demo.dto.MerchantRequest;
import com.example.demo.dto.MerchantResponse;
import com.example.demo.dto.MerchantResponseBody;
import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Merchant;
import com.example.demo.respository.CustomerRespository;
import com.example.demo.respository.MerchantRespository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.MerchantService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/merchant")
public class MerchantController {

	@Autowired public MerchantService merchantService;
	
	@Autowired
	public MerchantRespository merchantRespository;
	

	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public MerchantResponse findAll() {
		System.out.println("findAll");

		MerchantResponse response = new MerchantResponse();
		List<Merchant> dataList = merchantService.findAll();
		MerchantResponseBody body = new MerchantResponseBody();
		body.setReturnCode("0000");
		body.setDataList(dataList);
		response.setBody(body);

		return response;
	}
	
	//名子查詢
	@PostMapping(value = "/findByName", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public MerchantResponse findByName(@RequestBody MerchantRequest request) {
				System.out.println("findByName");
				System.out.println(request.getBody().getName());

				MerchantResponse response = new MerchantResponse();

				List<Merchant> dataList = merchantService.findByName(request.getBody().getName());
				MerchantResponseBody body = new MerchantResponseBody();
				body.setReturnCode("0000");
				body.setDataList(dataList);
				response.setBody(body);

				return response;

	}
	
	
	
	//查詢ID
	@PostMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public MerchantResponse findById(@RequestBody MerchantRequest request) {
				System.out.println("findById");
				System.out.println(request.getBody().getMerchantId());

				MerchantResponse response = new MerchantResponse();

				List<Merchant> dataList = merchantRespository.findSQL(request.getBody().getMerchantId());
				
				Merchant merchant=dataList.get(0);
				String str = new String(merchant.getPic());//把byte[]轉回String
				
				MerchantResponseBody body = new MerchantResponseBody();
				body.setReturnCode("0000");
				body.setDataList(dataList);
				body.setPic(str);
				
				
				response.setBody(body);

				return response;

	}
	
	
	//新增
	@PostMapping(value = "/save2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public MerchantResponse save2(@RequestBody MerchantRequest request) {
		
		System.out.println(request);
		System.out.println("save2");
		
		System.out.println("指定id"+request.getBody().getMerchantId());
		System.out.println("指定id"+request.getBody().getName());
		System.out.println("指定img"+request.getBody().getPic());
		System.out.println("指定imgby"+request.getBody().getPic().getBytes());

		Merchant merchant = new Merchant();
		
		//String img ="PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNTAgMjUwIj4KICAgIDxwYXRoIGZpbGw9IiNERDAwMzEiIGQ9Ik0xMjUgMzBMMzEuOSA2My4ybDE0LjIgMTIzLjFMMTI1IDIzMGw3OC45LTQzLjcgMTQuMi0xMjMuMXoiIC8+CiAgICA8cGF0aCBmaWxsPSIjQzMwMDJGIiBkPSJNMTI1IDMwdjIyLjItLjFWMjMwbDc4LjktNDMuNyAxNC4yLTEyMy4xTDEyNSAzMHoiIC8+CiAgICA8cGF0aCAgZmlsbD0iI0ZGRkZGRiIgZD0iTTEyNSA1Mi4xTDY2LjggMTgyLjZoMjEuN2wxMS43LTI5LjJoNDkuNGwxMS43IDI5LjJIMTgzTDEyNSA1Mi4xem0xNyA4My4zaC0zNGwxNy00MC45IDE3IDQwLjl6IiAvPgogIDwvc3ZnPg==";
		
		//byte[] pic=null;
		byte[] pic =request.getBody().getPic().getBytes();
		
		String str = new String(pic);//把byte[]轉回String
		//System.out.println("確認是否正常"+str);
		
		merchant.setMerchantId(request.getBody().getMerchantId());
		merchant.setName(request.getBody().getName());
		merchant.setTel(request.getBody().getTel());
		merchant.setAddr(request.getBody().getAddr());
		
		merchant.setPic(pic);
		
		merchantService.save(merchant);
		
		MerchantResponse response = new MerchantResponse();
		MerchantResponseBody body = new MerchantResponseBody();
		body.setReturnCode("0000");
		response.setBody(body);
		body.setPic(str);

		return response;
	}
	
	
	//複合查詢
	@RequestMapping(value = "/findBySpecificColumn", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public MerchantResponse findBySpecificColumn(@RequestBody MerchantRequest request) {
		
		System.out.println(request);
		System.out.println("findBySpecificColumn");

		MerchantResponse response = new MerchantResponse();
		Merchant merchant = new Merchant();
		
		String merchantId = request.getBody().getMerchantId();
		
		if (merchantId == null || (merchantId.trim()).length() == 0) {
			merchant.setMerchantId("null");
		}else {
			merchant.setMerchantId(request.getBody().getMerchantId());
		}
		
		String name = request.getBody().getName();
		if (name == null || (name.trim()).length() == 0) {
			merchant.setName("null");
		}else {
			merchant.setName(request.getBody().getName());
		}
		
		String addr = request.getBody().getAddr();
		if (addr == null || (addr.trim()).length() == 0) {
			merchant.setAddr("null");
		}else {
			merchant.setAddr( request.getBody().getAddr());
		}
		
		String tel = request.getBody().getTel();
		if (tel == null || (tel.trim()).length() == 0) {
			merchant.setTel("null");
		}else {
			merchant.setTel(request.getBody().getTel());
		}
		
		System.out.println(merchant.getMerchantId());
		System.out.println(merchant.getName());
		System.out.println(merchant.getTel());
		System.out.println(merchant.getAddr());
		
		
		List<Merchant> dataList = merchantService.findBySpecificColumn(merchant);
		MerchantResponseBody body = new MerchantResponseBody();
		
		System.out.println("判斷空值"+CollectionUtils.isEmpty(dataList));
		
		body.setReturnCode("0000");
		body.setDataList(dataList);
		response.setBody(body);

		return response;

	}
	
	
	//查詢ID和Name
	@PostMapping(value = "/findByIdandName", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public MerchantResponse findByIdandName(@RequestBody MerchantRequest request) {
				System.out.println("findByIdandName");
				System.out.println(request.getBody().getMerchantId());

				MerchantResponse response = new MerchantResponse();

				List<Merchant> dataList = merchantRespository.findSQL2(request.getBody().getMerchantId(),request.getBody().getName());
				
				
				MerchantResponseBody body = new MerchantResponseBody();
				body.setReturnCode("0000");
				body.setDataList(dataList);
				
				response.setBody(body);

				return response;

	}
	
	
	
	


	
	

	
	
	


}
