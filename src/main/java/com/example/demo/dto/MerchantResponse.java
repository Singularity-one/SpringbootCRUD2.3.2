package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MerchantResponse {
	
	@JsonProperty("header")
	public CommonHeader header;
	
	@JsonProperty("body")
	public MerchantResponseBody body;

	public CommonHeader getHeader() {
		return header;
	}

	public void setHeader(CommonHeader header) {
		this.header = header;
	}

	public MerchantResponseBody getBody() {
		return body;
	}

	public void setBody(MerchantResponseBody body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "MerchantResponse [header=" + header + ", body=" + body + "]";
	}
}
