package com.example.demo.controller;

import java.util.List;
import java.util.Map;

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
import com.example.demo.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	public CustomerService customerService;
	
	@Autowired
	public CustomerRespository customerRespository;
	
	//新增
	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public CustomerResponse save(@RequestBody CustomerRequest request) {
		System.out.println(request);

		CustomerResponse response = new CustomerResponse();
		Customer costomer = new Customer();
		BeanUtils.copyProperties(request.getBody(), costomer);
		customerService.save(costomer);
		CustomerResponseBody body = new CustomerResponseBody();
		body.setReturnCode("0000");
		response.setBody(body);

		return response;
	}

	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public CustomerResponse findAll() {
		System.out.println("findAll");

		CustomerResponse response = new CustomerResponse();
		List<Customer> dataList = customerService.findAll();
		CustomerResponseBody body = new CustomerResponseBody();
		body.setReturnCode("0000");
		body.setDataList(dataList);
		response.setBody(body);

		return response;
	}

//	@RequestMapping(value = "/findBySpecificColumn", method = { RequestMethod.GET, RequestMethod.POST })
//	@ResponseBody
//	public CustomerResponse findBySpecificColumn(@RequestBody CustomerRequest request) {
//
//		CustomerResponse response = new CustomerResponse();
//		Customer customer = new Customer();
//		BeanUtils.copyProperties(request.getBody(), customer);
//
//		List<Customer> dataList = customerService.findBySpecificColumn(customer);
//		CustomerResponseBody body = new CustomerResponseBody();
//		body.setReturnCode("0000");
//		body.setDataList(dataList);
//		response.setBody(body);
//
//		return response;
//
//	}

	@RequestMapping(value = "/findByAge", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public CustomerResponse findByAge(@RequestBody Map<String, String> request) {
		
		CustomerResponse response = new CustomerResponse();

		List<Customer> dataList = customerService.findByAge(request);
		CustomerResponseBody body = new CustomerResponseBody();
		body.setReturnCode("0000");
		body.setDataList(dataList);
		response.setBody(body);

		return response;

	}
	
	
	//名子查詢
	@PostMapping(value = "/findByName", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public CustomerResponse findByName(@RequestBody CustomerRequest request) {
			System.out.println("findByName");
			System.out.println(request.getBody().getName());

			CustomerResponse response = new CustomerResponse();

			List<Customer> dataList = customerService.findByName(request.getBody().getName());
			CustomerResponseBody body = new CustomerResponseBody();
			body.setReturnCode("0000");
			body.setDataList(dataList);
			response.setBody(body);

			return response;

	}
	
	
	//名子模糊查詢
	@RequestMapping(value = "/findByNameLike", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public CustomerResponse findByNameLike(@RequestBody CustomerRequest request) {
		System.out.println(request.getBody().getName());

		CustomerResponse response = new CustomerResponse();
			
		String name =request.getBody().getName();
		System.out.println(name);

		List<Customer> dataList = customerService.findByNameLike("%"+name+"%");
		CustomerResponseBody body = new CustomerResponseBody();
		body.setReturnCode("0000");
		body.setDataList(dataList);
		response.setBody(body);

		return response;

	}
	
	
	
	
	//查詢SQL
	@RequestMapping(value = "/findBySQL", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public CustomerResponse findBySQL(@RequestBody CustomerRequest request) {
		System.out.println(request.getBody().getName());
		System.out.println(request.getBody().getAddr());

		CustomerResponse response = new CustomerResponse();
			
		String name =request.getBody().getName();
		System.out.println(name);
		
		String addr =request.getBody().getAddr();
		System.out.println(addr);
		
		List<Customer> dataList = customerService.findBySQL(name,addr);
		CustomerResponseBody body = new CustomerResponseBody();
		body.setReturnCode("0000");
		body.setDataList(dataList);
		response.setBody(body);

		return response;

	}
	
	
	//刪除SQL
	@RequestMapping(value = "/deleteBySQL", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public CustomerResponse deleteBySQL(@RequestBody CustomerRequest request) {
		System.out.println(request.getBody().getCustomerId());

		CustomerResponse response = new CustomerResponse();
			
		
		customerService.deleteBySQL(request.getBody().getCustomerId());
		CustomerResponseBody body = new CustomerResponseBody();
		body.setReturnCode("0000");
		response.setBody(body);

		return response;

	}
	
	
	//修改
	@PostMapping(value = "/updata", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public CustomerResponse updata(@RequestBody CustomerRequest request) {
		System.out.println(request);
		System.out.println("updata");
		System.out.println("得到id"+request.getBody().getCustomerId());

		CustomerResponse response = new CustomerResponse();
		Customer costomer = new Customer();
		BeanUtils.copyProperties(request.getBody(), costomer);
		customerService.save(costomer);
		CustomerResponseBody body = new CustomerResponseBody();
		body.setReturnCode("0000");
		response.setBody(body);

		return response;
	}
	
	
	//新增2
	@PostMapping(value = "/save2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public CustomerResponse save2(@RequestBody CustomerRequest request) {
		System.out.println("save2");
		System.out.println(request);

		CustomerResponse response = new CustomerResponse();
		Customer costomer = new Customer();
		
		//得到最後一筆ID
		Customer costomer2 = new Customer();
		costomer2 = customerService.findByEnd();
		int id = Integer.valueOf(costomer2.getCustomerId());
		System.out.println(id);
		String customerId =String.valueOf(id+1);
		System.out.println(customerId);
		
		costomer.setCustomerId(customerId);
		costomer.setName(request.getBody().getName());
		costomer.setAddr(request.getBody().getAddr());
		costomer.setAge(request.getBody().getAge());
		costomer.setTel(request.getBody().getTel());
		
		
		
		customerService.save(costomer);
		CustomerResponseBody body = new CustomerResponseBody();
		body.setReturnCode("0000");
		response.setBody(body);

		return response;
	}
	
	
	//用SQL找id
	@RequestMapping(value = "/findSQL", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public CustomerResponse findSQL(@RequestBody CustomerRequest request) {
		System.out.println("findSQL");
		
		System.out.println(request.getBody().getCustomerId());

		CustomerResponse response = new CustomerResponse();
			
		String customerId =request.getBody().getCustomerId();
		System.out.println(customerId);
		
		
		List<Customer> dataList = customerService.findSQL(customerId);
		CustomerResponseBody body = new CustomerResponseBody();
		body.setReturnCode("0000");
		body.setDataList(dataList);
		response.setBody(body);

		return response;

	}
	
	
	//修改2
	@PostMapping(value = "/updata2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public CustomerResponse updata2(@RequestBody CustomerRequest request) {
		System.out.println(request);
		System.out.println("updata");
		System.out.println("得到id"+request.getBody().getCustomerId());

		CustomerResponse response = new CustomerResponse();
		
		List<Customer> dataList = customerService.findSQL(request.getBody().getCustomerId());
		
		Customer costomer = new Customer();
		costomer = dataList.get(0);
		
		//因為沒有填傳進來是空字串
		if(request.getBody().getName().trim().length() != 0) {
			costomer.setName(request.getBody().getName());
		}
		
		if(request.getBody().getAge().trim().length() != 0){
			costomer.setAge(request.getBody().getAge());
		}
		
		if(request.getBody().getTel().trim().length() != 0) {
			costomer.setTel(request.getBody().getTel());
		}
		
		if(request.getBody().getAddr().trim().length() != 0) {
			costomer.setAddr(request.getBody().getAddr());
		}
		
		System.out.println(costomer);

		customerService.save(costomer);
		CustomerResponseBody body = new CustomerResponseBody();
		body.setReturnCode("0000");
		response.setBody(body);
		

		return response;
	}
	
//	//得到頁數原始資訊
//	@PostMapping(value = "/page0", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ResponseBody
//	public Page<Customer> page0() {
//		
//		Page<Customer> pageCustomer = customerRespository.findAll(new PageRequest(0,2));
//		
//		List<Customer> dataList =pageCustomer.getContent() ;
//		
//		int number = pageCustomer.getNumber();//所在頁數
//		int size = pageCustomer.getSize();//每頁筆數
//		int totalPages = pageCustomer.getTotalPages();//總頁數
//		
//		System.out.println("Number:"+number);
//		System.out.println("Size:"+size);
//		System.out.println("TotalPages:"+totalPages);
//
//		return pageCustomer;
//	}
	
	
	
	
	//得到頁數
	@PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public CustomerResponse page() {
		
		Page<Customer> pageCustomer = customerRespository.findAll(PageRequest.of(0,2));
		
		List<Customer> dataList =pageCustomer.getContent() ;
		
		int number = pageCustomer.getNumber();//頁碼從零開始
		int size = pageCustomer.getSize();//每頁多少筆
		int totalPages = pageCustomer.getTotalPages();//總頁數
		
		System.out.println("Number:"+number);
		System.out.println("Size:"+size);
		System.out.println("TotalPages:"+totalPages);
		
		CustomerResponse response = new CustomerResponse();
		CustomerResponseBody body = new CustomerResponseBody();
		body.setReturnCode("0000");
		response.setBody(body);
		body.setDataList(dataList);
		body.setPage(String.valueOf(number));
		body.setSize(String.valueOf(size));
		body.setTotalPages(String.valueOf(totalPages));
		
		return response;
	}
	
	
	//得到頁數2
	@PostMapping(value = "/page2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public CustomerResponse page2(@RequestBody CustomerRequest request) {
		
		System.out.println(request);
		System.out.println("page2");
		System.out.println("得到page"+request.getBody().getPage());
		System.out.println("得到size"+request.getBody().getSize());
		
		int page=Integer.parseInt(request.getBody().getPage());
		//int size=Integer.parseInt(request.getBody().getSize());
		int size=2;
		
		Page<Customer> pageCustomer = customerRespository.findAll(PageRequest.of(page,size));
			
		List<Customer> dataList =pageCustomer.getContent() ;
		
		int number = pageCustomer.getNumber();//頁碼從零開始
		int totalPages = pageCustomer.getTotalPages();//總頁數
		
		System.out.println("Number:"+number);
		System.out.println("Size:"+size);
		System.out.println("TotalPages:"+totalPages);
		
		CustomerResponse response = new CustomerResponse();
		CustomerResponseBody body = new CustomerResponseBody();
		body.setReturnCode("0000");
		response.setBody(body);
		body.setDataList(dataList);
		body.setPage(String.valueOf(number));
		body.setSize(String.valueOf(size));
		body.setTotalPages(String.valueOf(totalPages));
		
		return response;
	}
	
	
	//得到頁數和用年齡排序
	@PostMapping(value = "/page3", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	 public CustomerResponse page3(@RequestBody CustomerRequest request) {
		
		System.out.println(request);
		System.out.println("page3");
		System.out.println("得到age"+request.getBody().getAge());
		System.out.println("得到page"+request.getBody().getPage());
		System.out.println("得到size"+request.getBody().getSize());
		

		int page=Integer.parseInt(request.getBody().getPage());
		//int size=Integer.parseInt(request.getBody().getSize());
		int size=4;
			

	        
	        //大到小Sort.Direction.DESC,"age"
			//小到大Sort.Direction.ASC,"age"
			Page<Customer> pageCustomer = customerRespository.findAll(PageRequest.of(page,size, Sort.Direction.DESC,"age"));
		
	        List<Customer> dataList =pageCustomer.getContent() ;
			
			int number = pageCustomer.getNumber();//頁碼從零開始
			int totalPages = pageCustomer.getTotalPages();//總頁數
			
			System.out.println("Number:"+number);
			System.out.println("Size:"+size);
			System.out.println("TotalPages:"+totalPages);
			
			CustomerResponse response = new CustomerResponse();
			CustomerResponseBody body = new CustomerResponseBody();
			body.setReturnCode("0000");
			response.setBody(body);
			body.setDataList(dataList);
			body.setPage(String.valueOf(number));
			body.setSize(String.valueOf(size));
			body.setTotalPages(String.valueOf(totalPages));
			
			return response;
	    
	    }
	
	
	//複合查詢
	@RequestMapping(value = "/findBySpecificColumn", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public CustomerResponse findBySpecificColumn(@RequestBody CustomerRequest request) {
			
			System.out.println(request);
			System.out.println("findBySpecificColumn");

			CustomerResponse response = new CustomerResponse();
			Customer costomer = new Customer();
			
			String customerId = request.getBody().getCustomerId();
			
			if (customerId == null || (customerId.trim()).length() == 0) {
				costomer.setCustomerId("null");
			}else {
				costomer.setCustomerId(customerId);
			}
			
			String name = request.getBody().getName();
			if (name == null || (name.trim()).length() == 0) {
				costomer.setName("null");
			}else {
				costomer.setName(name);
			}
			
			String addr = request.getBody().getAddr();
			if (addr == null || (addr.trim()).length() == 0) {
				costomer.setAddr("null");
			}else {
				costomer.setAddr(addr);
			}
			
			String tel = request.getBody().getTel();
			if (tel == null || (tel.trim()).length() == 0) {
				costomer.setTel("null");
			}else {
				costomer.setTel(tel);
			}
			
			String age = request.getBody().getAge();
			if (age == null || (age.trim()).length() == 0) {
				costomer.setAge("null");
			}else {
				costomer.setAge(age);
			}
			
			
			
			System.out.println(costomer.getCustomerId());
			System.out.println(costomer.getName());
			System.out.println(costomer.getAge());
			System.out.println(costomer.getTel());
			System.out.println(costomer.getAddr());
			
			
			List<Customer> dataList = customerService.findBySpecificColumn(costomer);
			CustomerResponseBody body = new CustomerResponseBody();
			
			System.out.println("判斷空值"+CollectionUtils.isEmpty(dataList));
			
			body.setReturnCode("0000");
			body.setDataList(dataList);
			response.setBody(body);

			return response;

	}


}
