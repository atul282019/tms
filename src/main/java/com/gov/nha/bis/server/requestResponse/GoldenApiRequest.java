package com.gov.nha.bis.server.requestResponse;

import java.io.Serializable;
public class GoldenApiRequest implements Serializable{
	
	private static final long serialVersionUID = -6047086312809415818L;

	  private String hmac;
	  private String token;
	  private String uuid;
	  private String hhId;
	  private String mobileNumber;
	  private String aadharToken;
	  private String rationCard;
	  private String stateCode;
	  
	public String getHmac() {
		return hmac;
	}
	public void setHmac(String hmac) {
		this.hmac = hmac;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getHhId() {
		return hhId;
	}
	public void setHhId(String hhId) {
		this.hhId = hhId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAadharToken() {
		return aadharToken;
	}
	public void setAadharToken(String aadharToken) {
		this.aadharToken = aadharToken;
	}
	public String getRationCard() {
		return rationCard;
	}
	public void setRationCard(String rationCard) {
		this.rationCard = rationCard;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
