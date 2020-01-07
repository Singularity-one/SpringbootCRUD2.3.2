package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductRequestBody {
	
	@JsonProperty("productId")
	public Integer productId;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "ProductRequestBody [productId=" + productId + "]";
	}
}
