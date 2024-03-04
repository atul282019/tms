package com.gov.nha.bis.server.preauth_requestResponse;

import java.util.ArrayList;

public class SavePreauthorizationMasterRequest {
	private String txnid;
	private String requestId;
	private String patientId;
	private String patientState;
	private String hospState;
	private String caseHospCode;
	private String autoApprovalFlag;
	private String enhFlag;
	private String admissionDt;
	private String totPckgAmt;
	private String caseType;
	private String isCovidCase;
	private String crtUsr;
	private String hospGrade;
	private ExaminationFindings examinationFindings;
	private PatientPersonalHistory patientPersonalHistory;
	private PatientHospDiagnosis patientHospDiagnosis;
	private ArrayList <PrimaryDiagnosis> primaryDiagnosis ;
	private ArrayList <SecondaryDiagnosis> secondaryDiagnosis ;
	private ArrayList <PackageDetails> packageDetails ;
	
	
	private String treatmentDate;
	private String legalCaseCheck;
	private String legalCaseNo;
	private String policeStatName;
	private String remarks;
	
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPatientState() {
		return patientState;
	}
	public void setPatientState(String patientState) {
		this.patientState = patientState;
	}
	public String getHospState() {
		return hospState;
	}
	public void setHospState(String hospState) {
		this.hospState = hospState;
	}
	public String getCaseHospCode() {
		return caseHospCode;
	}
	public void setCaseHospCode(String caseHospCode) {
		this.caseHospCode = caseHospCode;
	}
	public String getAutoApprovalFlag() {
		return autoApprovalFlag;
	}
	public void setAutoApprovalFlag(String autoApprovalFlag) {
		this.autoApprovalFlag = autoApprovalFlag;
	}
	public String getEnhFlag() {
		return enhFlag;
	}
	public void setEnhFlag(String enhFlag) {
		this.enhFlag = enhFlag;
	}
	public String getAdmissionDt() {
		return admissionDt;
	}
	public void setAdmissionDt(String admissionDt) {
		this.admissionDt = admissionDt;
	}
	public String getTotPckgAmt() {
		return totPckgAmt;
	}
	public void setTotPckgAmt(String totPckgAmt) {
		this.totPckgAmt = totPckgAmt;
	}
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	public String getIsCovidCase() {
		return isCovidCase;
	}
	public void setIsCovidCase(String isCovidCase) {
		this.isCovidCase = isCovidCase;
	}
	public String getCrtUsr() {
		return crtUsr;
	}
	public void setCrtUsr(String crtUsr) {
		this.crtUsr = crtUsr;
	}
	public String getHospGrade() {
		return hospGrade;
	}
	public void setHospGrade(String hospGrade) {
		this.hospGrade = hospGrade;
	}
	
	public ArrayList<PrimaryDiagnosis> getPrimaryDiagnosis() {
		return primaryDiagnosis;
	}
	public void setPrimaryDiagnosis(ArrayList<PrimaryDiagnosis> primaryDiagnosis) {
		this.primaryDiagnosis = primaryDiagnosis;
	}
	public ArrayList<SecondaryDiagnosis> getSecondaryDiagnosis() {
		return secondaryDiagnosis;
	}
	public void setSecondaryDiagnosis(ArrayList<SecondaryDiagnosis> secondaryDiagnosis) {
		this.secondaryDiagnosis = secondaryDiagnosis;
	}
	public ArrayList<PackageDetails> getPackageDetails() {
		return packageDetails;
	}
	public void setPackageDetails(ArrayList<PackageDetails> packageDetails) {
		this.packageDetails = packageDetails;
	}

	public String getTxnid() {
		return txnid;
	}
	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}
	
	@Override
	public String toString() {
		return "SavePreauthorizationMasterRequest [txnid=" + txnid + ", requestId=" + requestId + ", patientId="
				+ patientId + ", patientState=" + patientState + ", hospState=" + hospState + ", caseHospCode="
				+ caseHospCode + ", autoApprovalFlag=" + autoApprovalFlag + ", enhFlag=" + enhFlag + ", admissionDt="
				+ admissionDt + ", totPckgAmt=" + totPckgAmt + ", caseType=" + caseType + ", isCovidCase=" + isCovidCase
				+ ", crtUsr=" + crtUsr + ", hospGrade=" + hospGrade + ", examinationFindings=" + examinationFindings
				+ ", patientPersonalHistory=" + patientPersonalHistory + ", patientHospDiagnosis="
				+ patientHospDiagnosis + ", primaryDiagnosis=" + primaryDiagnosis + ", secondaryDiagnosis="
				+ secondaryDiagnosis + ", packageDetails=" + packageDetails + "]";
	}
	public ExaminationFindings getExaminationFindings() {
		return examinationFindings;
	}
	public void setExaminationFindings(ExaminationFindings examinationFindings) {
		this.examinationFindings = examinationFindings;
	}
	public PatientPersonalHistory getPatientPersonalHistory() {
		return patientPersonalHistory;
	}
	public void setPatientPersonalHistory(PatientPersonalHistory patientPersonalHistory) {
		this.patientPersonalHistory = patientPersonalHistory;
	}
	public PatientHospDiagnosis getPatientHospDiagnosis() {
		return patientHospDiagnosis;
	}
	public void setPatientHospDiagnosis(PatientHospDiagnosis patientHospDiagnosis) {
		this.patientHospDiagnosis = patientHospDiagnosis;
	}
	public String getTreatmentDate() {
		return treatmentDate;
	}
	public void setTreatmentDate(String treatmentDate) {
		this.treatmentDate = treatmentDate;
	}
	public String getLegalCaseCheck() {
		return legalCaseCheck;
	}
	public void setLegalCaseCheck(String legalCaseCheck) {
		this.legalCaseCheck = legalCaseCheck;
	}
	public String getLegalCaseNo() {
		return legalCaseNo;
	}
	public void setLegalCaseNo(String legalCaseNo) {
		this.legalCaseNo = legalCaseNo;
	}
	public String getPoliceStatName() {
		return policeStatName;
	}
	public void setPoliceStatName(String policeStatName) {
		this.policeStatName = policeStatName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}

