package com.gov.nha.bis.server.requestResponse;

public class SpecialityMasterRequest {

	private Integer  specialityid;
	public Integer getSpecialityid() {
		return specialityid;
	}

	public void setSpecialityid(Integer specialityid) {
		this.specialityid = specialityid;
	}

	private String specialityname;
	
    private String version;
	
    private Integer status;
	
    private String specialitycode;
    
	private String specialitytype;
	
	private Integer schemecode;
	private String statecode;
	
    public Integer getSchemecode() {
		return schemecode;
	}

	public void setSchemecode(Integer schemecode) {
		this.schemecode = schemecode;
	}

	public String getStatecode() {
		return statecode;
	}

	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}

	public String getSpecialitytype() {
		return specialitytype;
	}

	public void setSpecialitytype(String specialitytype) {
		this.specialitytype = specialitytype;
	}
	public String getSpecialityname() {
		return specialityname;
	}

	public void setSpecialityname(String specialityname) {
		this.specialityname = specialityname;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getSpecialitycode() {
		return specialitycode;
	}

	public void setSpecialitycode(String specialitycode) {
		this.specialitycode = specialitycode;
	}
}
