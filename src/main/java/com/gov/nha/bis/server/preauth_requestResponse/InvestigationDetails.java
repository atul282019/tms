package com.gov.nha.bis.server.preauth_requestResponse;

import org.springframework.web.multipart.MultipartFile;

public class InvestigationDetails {
	 private String image;
	 private String fileName;
	 private String aattachName;
	 
	 
	public MultipartFile invfile;
	private String txnId;
	private String procedureCode;
	private String investid;
	private String tempId;
		
		
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getAattachName() {
		return aattachName;
	}
	public void setAattachName(String aattachName) {
		this.aattachName = aattachName;
	}
	
	public MultipartFile getInvfile() {
		return invfile;
	}
	public void setInvfile(MultipartFile invfile) {
		this.invfile = invfile;
	}
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public String getTempId() {
		return tempId;
	}
	public void setTempId(String tempId) {
		this.tempId = tempId;
	}
	public String getProcedureCode() {
		return procedureCode;
	}
	public void setProcedureCode(String procedureCode) {
		this.procedureCode = procedureCode;
	}
	@Override
	public String toString() {
		return "InvestigationDetails [image=" + image + ", fileName=" + fileName + ", aattachName=" + aattachName
				+ ", invfile=" + invfile + ", txnId=" + txnId + ", procedureCode=" + procedureCode + ", tempId="
				+ tempId + "]";
	}
	public String getInvestid() {
		return investid;
	}
	public void setInvestid(String investid) {
		this.investid = investid;
	}
	
}
