package com.gov.nha.bis.server.model;

public class State {

	private String modeFlag;
    private String  stateCode;
	private String  districtCode;
	private String  blockCode;
	private String  townCode;
	
    public String getModeFlag() {
		return modeFlag;
	}
	public void setModeFlag(String modeFlag) {
		this.modeFlag = modeFlag;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public String getBlockCode() {
		return blockCode;
	}
	public void setBlockCode(String blockCode) {
		this.blockCode = blockCode;
	}
	public String getTownCode() {
		return townCode;
	}
	public void setTownCode(String townCode) {
		this.townCode = townCode;
	}

}
