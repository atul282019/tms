package com.gov.nha.bis.server.requestResponse;

public class PackageCategoryMasterRequest {

	 
	private String catname;
    private String version;
    private Integer reimbursementpercentage;
    private Integer  status;
    private Integer packagecatid;
    
	public Integer getPackagecatid() {
		return packagecatid;
	}

	public void setPackagecatid(Integer packagecatid) {
		this.packagecatid = packagecatid;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
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

	public Integer getReimbursementpercentage() {
		return reimbursementpercentage;
	}

	public void setReimbursementpercentage(Integer reimbursementpercentage) {
		this.reimbursementpercentage = reimbursementpercentage;
	}
	
	
}
