package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonHeader {

	@JsonProperty("msgId")
	public String msgId;
	
	@JsonProperty("txnSeq")
	public String txnSeq;
	
	@JsonProperty("branchId")
	public String branchId;
	
	@JsonProperty("clientIp")
	public String clientIp;

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getTxnSeq() {
		return txnSeq;
	}

	public void setTxnSeq(String txnSeq) {
		this.txnSeq = txnSeq;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	@Override
	public String toString() {
		return "CommonHeader [msgId=" + msgId + ", txnSeq=" + txnSeq + ", branchId=" + branchId + ", clientIp="
				+ clientIp + "]";
	}
}
