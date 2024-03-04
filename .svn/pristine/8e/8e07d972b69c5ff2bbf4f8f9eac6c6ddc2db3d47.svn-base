package com.gov.nha.bis.server.rest.service;

import javax.servlet.http.HttpSession;

import com.gov.nha.bis.server.preauth_requestResponse.PrimaryDiagnosis;
import com.gov.nha.bis.server.preauth_requestResponse.SavePreauthorizationMasterRequest;
import com.gov.nha.bis.server.preauth_requestResponse.SecondaryDiagnosis;
import com.gov.nha.bis.server.requestResponse.TreatmentProtocol;

public interface PreAuthDataService {

	String getPatientDataById(String txnid);

	String savePrimaryDaignosis(PrimaryDiagnosis diagnosis);

	String saveSecondaryDiagnosis(SecondaryDiagnosis diagnosis);

	String getPrimaryDaignoseData(String txnid);

	String getSecondaryDaignoseData(String txnid);

	String deletePrimaryDaignoseData(String txnid, String tempId);

	String deleteSecondaryDaignoseData(String txnid, String tempId);

	String catchPreAuthTreatmentProtocal(TreatmentProtocol treatmentProtocol, HttpSession session);
	
	String savePreAuth(SavePreauthorizationMasterRequest savePreauthorizationMasterRequest);

	String getDaignosticMasterData(String token, String codeordesc);


}
