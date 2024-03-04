package com.gov.nha.bis.server.preauth_requestResponse;

public class SecondaryDiagnosis {
	private String icdCode;
	private String icdDesc;
	private String icdURI;
	private String tempId;
	private String txnid;
	
	
	
	public String getTxnid() {
		return txnid;
	}
	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}
	public String getTempId() {
		return tempId;
	}
	public void setTempId(String tempId) {
		this.tempId = tempId;
	}
	public String getIcdCode() {
		return icdCode;
	}
	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}
	public String getIcdDesc() {
		return icdDesc;
	}
	public void setIcdDesc(String icdDesc) {
		this.icdDesc = icdDesc;
	}
	public String getIcdURI() {
		return icdURI;
	}
	public void setIcdURI(String icdURI) {
		this.icdURI = icdURI;
	}
	@Override
	public String toString() {
		return "SecondaryDiagnosis [icdCode=" + icdCode + ", icdDesc=" + icdDesc + ", icdURI=" + icdURI + "]";
	}
	

	
}
