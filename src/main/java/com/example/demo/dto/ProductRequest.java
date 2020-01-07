package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductRequest {
	
	@JsonProperty("header")
	public CommonHeader header;
	
	@JsonProperty("body")
	public ProductRequestBody body;

	public CommonHeader getHeader() {
		return header;
	}

	public void setHeader(CommonHeader header) {
		this.header = header;
	}

	public ProductRequestBody getBody() {
		return body;
	}

	public void setBody(ProductRequestBody body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "ProductRequest [header=" + header + ", body=" + body + "]";
	}
}
