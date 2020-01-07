package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerRequest {
	
	@JsonProperty("header")
	public CommonHeader header;
	
	@JsonProperty("body")
	public CustomerRequestBody body;

	public CommonHeader getHeader() {
		return header;
	}

	public void setHeader(CommonHeader header) {
		this.header = header;
	}

	public CustomerRequestBody getBody() {
		return body;
	}

	public void setBody(CustomerRequestBody body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "CustomerRequest [header=" + header + ", body=" + body + "]";
	}
}
