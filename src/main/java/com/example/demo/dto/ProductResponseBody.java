package com.example.demo.dto;

import java.math.BigDecimal;

public class ProductResponseBody {

	public Integer productId;
	
	public String code;
	
	public String name;
	
	public BigDecimal unitprice;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(BigDecimal unitprice) {
		this.unitprice = unitprice;
	}

	@Override
	public String toString() {
		return "ProductResponseBody [productId=" + productId + ", code=" + code + ", name=" + name + ", unitprice="
				+ unitprice + "]";
	}
}
