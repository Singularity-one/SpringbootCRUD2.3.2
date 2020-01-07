package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerResponseBody {
	
	private String returnCode;

	private List<Customer> dataList;
	
	private String page;
	private String size;
	private String totalPages;
	
	
	public String getReturnCode() {
		return returnCode;
	}
	
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	
	public List<Customer> getDataList() {
		return dataList;
	}
	
	public void setDataList(List<Customer> dataList) {
		this.dataList = dataList;
	}
	
	public String getPage() {
		return page;
	}
	
	public void setPage(String page) {
		this.page = page;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public String getTotalPages() {
		return totalPages;
	}
	
	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}
	
	@Override
	public String toString() {
		return "CustomerResponseBody [returnCode=" + returnCode + ", dataList=" + dataList + ", page=" + page
				+ ", size=" + size + ", totalPages=" + totalPages + "]";
	}
	
	

	

}
