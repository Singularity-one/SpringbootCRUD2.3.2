package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MerchantRequest {
	
	@JsonProperty("header")
	public CommonHeader header;
	
	@JsonProperty("body")
	public MerchantRequestBody body;

	public CommonHeader getHeader() {
		return header;
	}

	public void setHeader(CommonHeader header) {
		this.header = header;
	}

	public MerchantRequestBody getBody() {
		return body;
	}

	public void setBody(MerchantRequestBody body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "MerchantRequest [header=" + header + ", body=" + body + "]";
	}
}
