package com.gov.nha.bis.server.preauth_requestResponse;

public class Errors {
	private String errorCode;
	private String errorMessage;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "Errors [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}
	
}
