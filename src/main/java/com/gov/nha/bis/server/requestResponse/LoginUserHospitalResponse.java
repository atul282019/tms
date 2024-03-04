package com.gov.nha.bis.server.requestResponse;

public class LoginUserHospitalResponse {
	

	private String hid;
	private String hname;
	private String hstate;
	private String hcat;
	private boolean selected;
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getHstate() {
		return hstate;
	}
	public void setHstate(String hstate) {
		this.hstate = hstate;
	}
	public String getHcat() {
		return hcat;
	}
	public void setHcat(String hcat) {
		this.hcat = hcat;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
}
