package com.gov.nha.bis.server.requestResponse;

public class DocumentMasterRequest {

	private String specialitycode;
	private String packagecode;
	private String procedurecode;
	private String claimprocessingdoc;
	private String preauthorizationdoc;
	private Integer schemeid;
	private Integer status;
	private String statecode;
	private String mandatoryStatus;
	
	private Long documentid;
	
	public Long getDocumentid() {
		return documentid;
	}
	public void setDocumentid(Long documentid) {
		this.documentid = documentid;
	}
	

	public String getSpecialitycode() {
		return specialitycode;
	}
	public void setSpecialitycode(String specialitycode) {
		this.specialitycode = specialitycode;
	}
	public String getPackagecode() {
		return packagecode;
	}
	public void setPackagecode(String packagecode) {
		this.packagecode = packagecode;
	}
	public String getProcedurecode() {
		return procedurecode;
	}
	public void setProcedurecode(String procedurecode) {
		this.procedurecode = procedurecode;
	}
	public String getClaimprocessingdoc() {
		return claimprocessingdoc;
	}
	public void setClaimprocessingdoc(String claimprocessingdoc) {
		this.claimprocessingdoc = claimprocessingdoc;
	}
	public String getPreauthorizationdoc() {
		return preauthorizationdoc;
	}
	public void setPreauthorizationdoc(String preauthorizationdoc) {
		this.preauthorizationdoc = preauthorizationdoc;
	}
	public Integer getSchemeid() {
		return schemeid;
	}
	public void setSchemeid(Integer schemeid) {
		this.schemeid = schemeid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getStatecode() {
		return statecode;
	}
	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}
	@Override
	public String toString() {
		return "DocumentMasterRequest [specialitycode=" + specialitycode + ", packagecode=" + packagecode
				+ ", procedurecode=" + procedurecode + ", claimprocessingdoc=" + claimprocessingdoc
				+ ", preauthorizationdoc=" + preauthorizationdoc + ", schemeid=" + schemeid + ", status=" + status
				+ ", statecode=" + statecode + ", mandatoryStatus=" + mandatoryStatus + ", documentid=" + documentid
				+ "]";
	}
	public String getMandatoryStatus() {
		return mandatoryStatus;
	}
	public void setMandatoryStatus(String mandatoryStatus) {
		this.mandatoryStatus = mandatoryStatus;
	}
		
}
