package com.gov.nha.bis.server.preauth_requestResponse;

public class StratDetails {
	private String txnid;
	private String speciality;
	private String packageid;
	private String procedureid;
	private String stratCode;
	private String stratDtls;
	private String stratName;
	private String stratCost;
	private String totalStratCost;
	private String noOfUnits;
	

	public String getStratCode() {
		return stratCode;
	}
	public void setStratCode(String stratCode) {
		this.stratCode = stratCode;
	}
	public String getStratDtls() {
		return stratDtls;
	}
	public void setStratDtls(String stratDtls) {
		this.stratDtls = stratDtls;
	}
	public String getStratName() {
		return stratName;
	}
	public void setStratName(String stratName) {
		this.stratName = stratName;
	}
	public String getStratCost() {
		return stratCost;
	}
	public void setStratCost(String stratCost) {
		this.stratCost = stratCost;
	}
	public String getTotalStratCost() {
		return totalStratCost;
	}
	public void setTotalStratCost(String totalStratCost) {
		this.totalStratCost = totalStratCost;
	}
	public String getNoOfUnits() {
		return noOfUnits;
	}
	public void setNoOfUnits(String noOfUnits) {
		this.noOfUnits = noOfUnits;
	}
	@Override
	public String toString() {
		return "StratDetails [stratCode=" + stratCode + ", stratDtls=" + stratDtls + ", stratName=" + stratName
				+ ", stratCost=" + stratCost + ", totalStratCost=" + totalStratCost + ", noOfUnits=" + noOfUnits + "]";
	}
	public String getTxnid() {
		return txnid;
	}
	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}
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
	
	
	
}
