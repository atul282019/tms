package com.gov.nha.bis.server.model;

public class UserForm {
	
	private String loginId;
	private String password;
	private String userState;
	
	private String ip;
	
	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Override
	public String toString() {
		return "UserForm [loginId=" + loginId + ", password=" + password + ", userState=" + userState + ", ip=" + ip
				+ "]";
	}
	

}