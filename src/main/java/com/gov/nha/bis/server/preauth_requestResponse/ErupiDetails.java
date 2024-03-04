package com.gov.nha.bis.server.preauth_requestResponse;

public class ErupiDetails {
	 private String investigationName;
	 private String investCode;
	 private String quantity;
	 private String unitAmount;
	 private String totalAmount;
	 private String maxQuantity;
	 private String minQuantity;
	public String getInvestigationName() {
		return investigationName;
	}
	public void setInvestigationName(String investigationName) {
		this.investigationName = investigationName;
	}
	public String getInvestCode() {
		return investCode;
	}
	public void setInvestCode(String investCode) {
		this.investCode = investCode;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUnitAmount() {
		return unitAmount;
	}
	public void setUnitAmount(String unitAmount) {
		this.unitAmount = unitAmount;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getMaxQuantity() {
		return maxQuantity;
	}
	public void setMaxQuantity(String maxQuantity) {
		this.maxQuantity = maxQuantity;
	}
	public String getMinQuantity() {
		return minQuantity;
	}
	public void setMinQuantity(String minQuantity) {
		this.minQuantity = minQuantity;
	}
	@Override
	public String toString() {
		return "ErupiDetails [investigationName=" + investigationName + ", investCode=" + investCode + ", quantity="
				+ quantity + ", unitAmount=" + unitAmount + ", totalAmount=" + totalAmount + ", maxQuantity="
				+ maxQuantity + ", minQuantity=" + minQuantity + "]";
	}
	 
	 

}
