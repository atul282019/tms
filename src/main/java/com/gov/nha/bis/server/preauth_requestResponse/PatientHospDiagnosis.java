package com.gov.nha.bis.server.preauth_requestResponse;

public class PatientHospDiagnosis {
	private String txnid;
	private String historyIllness;
	private String pastHistory;
	private String pastHistoryOthr;
	private String familyHistory;
	private String familyHistoryOthr;
	private String caseAdmType;
	private String pastHistoryCancers;
	private String pastHistoryEnddis;
	private String pastHistorySurg;
	private String legalCaseCheck;
	private String legalCaseNo;
	private String policeStatName;
	
	private String[] ph;
	private String[] fh;
	
	public String[] getPh() {
		return ph;
	}
	public void setPh(String[] ph) {
		this.ph = ph;
	}
	public String[] getFh() {
		return fh;
	}
	public void setFh(String[] fh) {
		this.fh = fh;
	}
	public String getHistoryIllness() {
		return historyIllness;
	}
	public void setHistoryIllness(String historyIllness) {
		this.historyIllness = historyIllness;
	}
	public String getPastHistory() {
		return pastHistory;
	}
	public void setPastHistory(String pastHistory) {
		this.pastHistory = pastHistory;
	}
	public String getPastHistoryOthr() {
		return pastHistoryOthr;
	}
	public void setPastHistoryOthr(String pastHistoryOthr) {
		this.pastHistoryOthr = pastHistoryOthr;
	}
	public String getFamilyHistory() {
		return familyHistory;
	}
	public void setFamilyHistory(String familyHistory) {
		this.familyHistory = familyHistory;
	}
	public String getFamilyHistoryOthr() {
		return familyHistoryOthr;
	}
	public void setFamilyHistoryOthr(String familyHistoryOthr) {
		this.familyHistoryOthr = familyHistoryOthr;
	}
	public String getCaseAdmType() {
		return caseAdmType;
	}
	public void setCaseAdmType(String caseAdmType) {
		this.caseAdmType = caseAdmType;
	}
	public String getPastHistoryCancers() {
		return pastHistoryCancers;
	}
	public void setPastHistoryCancers(String pastHistoryCancers) {
		this.pastHistoryCancers = pastHistoryCancers;
	}
	public String getPastHistoryEnddis() {
		return pastHistoryEnddis;
	}
	public void setPastHistoryEnddis(String pastHistoryEnddis) {
		this.pastHistoryEnddis = pastHistoryEnddis;
	}
	public String getPastHistorySurg() {
		return pastHistorySurg;
	}
	public void setPastHistorySurg(String pastHistorySurg) {
		this.pastHistorySurg = pastHistorySurg;
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
	@Override
	public String toString() {
		return "PatientHospDiagnosis [historyIllness=" + historyIllness + ", pastHistory=" + pastHistory
				+ ", pastHistoryOthr=" + pastHistoryOthr + ", familyHistory=" + familyHistory + ", familyHistoryOthr="
				+ familyHistoryOthr + ", caseAdmType=" + caseAdmType + ", pastHistoryCancers=" + pastHistoryCancers
				+ ", pastHistoryEnddis=" + pastHistoryEnddis + ", pastHistorySurg=" + pastHistorySurg
				+ ", legalCaseCheck=" + legalCaseCheck + ", legalCaseNo=" + legalCaseNo + ", policeStatName="
				+ policeStatName + "]";
	}
	public String getTxnid() {
		return txnid;
	}
	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}



}
