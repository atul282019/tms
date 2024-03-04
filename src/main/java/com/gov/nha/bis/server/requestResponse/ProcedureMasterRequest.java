package com.gov.nha.bis.server.requestResponse;

public class ProcedureMasterRequest {
	
	 private Long procedureid;
		private String statecode;
	    private Integer schemeid;
		private String procedurecode;
		private String specialtycode;
		private String packagecode;
	    private String procedurename;
		private String implantstatus;	
	    private String stratificationStatus;
	    private String multipleprocedures;
	    private String specialconditionsstatus;
	    private String ispublic;
	    private String hospStatus;
	    private String levelofcare;
	    private String los;
	    private String alosStg;
	    private String autoapprovedstatus;
	    private String procedurelabel;
	    private String specialconditionstatus;
	    private String enhanceStatus;
	    private String medicalorsurgical;
	    private String daycareprocedure;
	    private String reservedprocedure;
	    private String version;
	    private Integer status;
	    
	    
		 private String medicalorsurgical_code;
		
		private String procedurelabelname_code;
		
		public String getMedicalorsurgical_code() {
			return medicalorsurgical_code;
		}
		public void setMedicalorsurgical_code(String medicalorsurgical_code) {
			this.medicalorsurgical_code = medicalorsurgical_code;
		}
		public String getProcedurelabelname_code() {
			return procedurelabelname_code;
		}
		public void setProcedurelabelname_code(String procedurelabelname_code) {
			this.procedurelabelname_code = procedurelabelname_code;
		}
		
		
		public Long getProcedureid() {
			return procedureid;
		}
		public void setProcedureid(Long procedureid) {
			this.procedureid = procedureid;
		}
		public String getStatecode() {
			return statecode;
		}
		public void setStatecode(String statecode) {
			this.statecode = statecode;
		}
		public Integer getSchemeid() {
			return schemeid;
		}
		public void setSchemeid(Integer schemeid) {
			this.schemeid = schemeid;
		}
		public String getProcedurecode() {
			return procedurecode;
		}
		public void setProcedurecode(String procedurecode) {
			this.procedurecode = procedurecode;
		}
		public String getSpecialtycode() {
			return specialtycode;
		}
		public void setSpecialtycode(String specialtycode) {
			this.specialtycode = specialtycode;
		}
		public String getPackagecode() {
			return packagecode;
		}
		public void setPackagecode(String packagecode) {
			this.packagecode = packagecode;
		}
		public String getProcedurename() {
			return procedurename;
		}
		public void setProcedurename(String procedurename) {
			this.procedurename = procedurename;
		}
		public String getImplantstatus() {
			return implantstatus;
		}
		public void setImplantstatus(String implantstatus) {
			this.implantstatus = implantstatus;
		}
		public String getStratificationStatus() {
			return stratificationStatus;
		}
		public void setStratificationStatus(String stratificationStatus) {
			this.stratificationStatus = stratificationStatus;
		}
		public String getMultipleprocedures() {
			return multipleprocedures;
		}
		public void setMultipleprocedures(String multipleprocedures) {
			this.multipleprocedures = multipleprocedures;
		}
		public String getSpecialconditionsstatus() {
			return specialconditionsstatus;
		}
		public void setSpecialconditionsstatus(String specialconditionsstatus) {
			this.specialconditionsstatus = specialconditionsstatus;
		}
		public String getIspublic() {
			return ispublic;
		}
		public void setIspublic(String ispublic) {
			this.ispublic = ispublic;
		}
		public String getHospStatus() {
			return hospStatus;
		}
		public void setHospStatus(String hospStatus) {
			this.hospStatus = hospStatus;
		}
		public String getLevelofcare() {
			return levelofcare;
		}
		public void setLevelofcare(String levelofcare) {
			this.levelofcare = levelofcare;
		}
		public String getLos() {
			return los;
		}
		public void setLos(String los) {
			this.los = los;
		}
		public String getAlosStg() {
			return alosStg;
		}
		public void setAlosStg(String alosStg) {
			this.alosStg = alosStg;
		}
		public String getAutoapprovedstatus() {
			return autoapprovedstatus;
		}
		public void setAutoapprovedstatus(String autoapprovedstatus) {
			this.autoapprovedstatus = autoapprovedstatus;
		}
		public String getProcedurelabel() {
			return procedurelabel;
		}
		public void setProcedurelabel(String procedurelabel) {
			this.procedurelabel = procedurelabel;
		}
		public String getSpecialconditionstatus() {
			return specialconditionstatus;
		}
		public void setSpecialconditionstatus(String specialconditionstatus) {
			this.specialconditionstatus = specialconditionstatus;
		}
		public String getEnhanceStatus() {
			return enhanceStatus;
		}
		public void setEnhanceStatus(String enhanceStatus) {
			this.enhanceStatus = enhanceStatus;
		}
		public String getMedicalorsurgical() {
			return medicalorsurgical;
		}
		public void setMedicalorsurgical(String medicalorsurgical) {
			this.medicalorsurgical = medicalorsurgical;
		}
		public String getDaycareprocedure() {
			return daycareprocedure;
		}
		public void setDaycareprocedure(String daycareprocedure) {
			this.daycareprocedure = daycareprocedure;
		}
		public String getReservedprocedure() {
			return reservedprocedure;
		}
		public void setReservedprocedure(String reservedprocedure) {
			this.reservedprocedure = reservedprocedure;
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
		@Override
		public String toString() {
			return "ProcedureMasterRequest [procedureid=" + procedureid + ", statecode=" + statecode + ", schemeid="
					+ schemeid + ", procedurecode=" + procedurecode + ", specialtycode=" + specialtycode + ", packagecode="
					+ packagecode + ", procedurename=" + procedurename + ", implantstatus=" + implantstatus
					+ ", stratificationStatus=" + stratificationStatus + ", multipleprocedures=" + multipleprocedures
					+ ", specialconditionsstatus=" + specialconditionsstatus + ", ispublic=" + ispublic + ", hospStatus="
					+ hospStatus + ", levelofcare=" + levelofcare + ", los=" + los + ", alosStg=" + alosStg
					+ ", autoapprovedstatus=" + autoapprovedstatus + ", procedurelabel=" + procedurelabel
					+ ", specialconditionstatus=" + specialconditionstatus + ", enhanceStatus=" + enhanceStatus
					+ ", medicalorsurgical=" + medicalorsurgical + ", daycareprocedure=" + daycareprocedure
					+ ", reservedprocedure=" + reservedprocedure + ", version=" + version + ", status=" + status + "]";
		}

}
