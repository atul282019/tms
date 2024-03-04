package com.gov.nha.bis.server.preauth_requestResponse;

import java.util.ArrayList;

public class SavePreauthorizationMasterResponse {

	private Integer statusCode;
	private String message;
	private ArrayList <Errors> errors = null;
	
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<Errors> getErrors() {
		return errors;
	}
	public void setErrors(ArrayList<Errors> errors) {
		this.errors = errors;
	}

}

