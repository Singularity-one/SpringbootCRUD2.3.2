package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerResponse {
	
	@JsonProperty("header")
	public CommonHeader header;
	
	@JsonProperty("body")
	public CustomerResponseBody body;

	public CommonHeader getHeader() {
		return header;
	}

	public void setHeader(CommonHeader header) {
		this.header = header;
	}

	public CustomerResponseBody getBody() {
		return body;
	}

	public void setBody(CustomerResponseBody body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "CustomerResponse [header=" + header + ", body=" + body + "]";
	}
}
