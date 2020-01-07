package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Merchant;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MerchantResponseBody {
	
	private String returnCode;

	private List<Merchant> dataList;
	
	private String pic;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public List<Merchant> getDataList() {
		return dataList;
	}

	public void setDataList(List<Merchant> dataList) {
		this.dataList = dataList;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Override
	public String toString() {
		return "MerchantResponseBody [returnCode=" + returnCode + ", dataList=" + dataList + ", pic=" + pic + "]";
	}

	

	

}
