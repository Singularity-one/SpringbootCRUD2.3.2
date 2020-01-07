package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MerchantRequestBody {

	@JsonProperty("merchantId")
	public String merchantId;

	@JsonProperty("name")
	public String name;

	@JsonProperty("addr")
	public String addr;

	@JsonProperty("tel")
	public String tel;

	@JsonProperty("pic")
	public String pic;

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Override
	public String toString() {
		return "MerchantRequestBody [merchantId=" + merchantId + ", name=" + name + ", addr=" + addr + ", tel=" + tel
				+ ", pic=" + pic + "]";
	}

	
	
	
	
	

	

}
