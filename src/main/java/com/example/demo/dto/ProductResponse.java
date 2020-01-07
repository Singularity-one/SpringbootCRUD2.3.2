package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductResponse {
	
	@JsonProperty("header")
	public CommonHeader header;
	
	@JsonProperty("body")
	public ProductResponseBody body;

	public CommonHeader getHeader() {
		return header;
	}

	public void setHeader(CommonHeader header) {
		this.header = header;
	}

	public ProductResponseBody getBody() {
		return body;
	}

	public void setBody(ProductResponseBody body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "ProductResponse [header=" + header + ", body=" + body + "]";
	}
}
