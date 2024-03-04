package com.gov.nha.bis.server.requestResponse;

import java.io.Serializable;

public class ShowImplantDataReq implements Serializable{
	

	private static final long serialVersionUID = -5145118965670277166L;
	
	private String txnid;
	private String[] implantCode;
	private String speciality;
	private String packageid;
	private String procedureid;
	
	
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getPackageid() {
		return packageid;
	}
	public void setPackageid(String packageid) {
		this.packageid = packageid;
	}
	public String getProcedureid() {
		return procedureid;
	}
	public void setProcedureid(String procedureid) {
		this.procedureid = procedureid;
	}
	public String getTxnid() {
		return txnid;
	}
	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}
	public String[] getImplantCode() {
		return implantCode;
	}
	public void setImplantCode(String[] implantCode) {
		this.implantCode = implantCode;
	}
	
}
