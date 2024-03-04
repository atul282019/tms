package com.gov.nha.bis.server.requestResponse;

public class TempInvestigationDetails {
	private String image;
	private String fileName;
	private String aattachName;
	private String txnId;
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

}
