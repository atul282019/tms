package com.gov.nha.bis.server.rest.service.Impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.gov.nha.bis.server.preauth_requestResponse.PrimaryDiagnosis;
import com.gov.nha.bis.server.preauth_requestResponse.SavePreauthorizationMasterRequest;
import com.gov.nha.bis.server.preauth_requestResponse.SecondaryDiagnosis;
import com.gov.nha.bis.server.properties.ApplicationConstantConfig;
import com.gov.nha.bis.server.requestResponse.TreatmentProtocol;
import com.gov.nha.bis.server.rest.service.PreAuthDataService;
import com.gov.nha.bis.server.util.CommonUtility;
import com.gov.nha.bis.server.util.LogCustomGenerator;

@Service
public class PreAuthDataServiceImpl implements PreAuthDataService{

	@Autowired
	public ApplicationConstantConfig applicationConstantConfig; 
	
	@Autowired
	LogCustomGenerator custumLog;
	
	//private static final Logger logger = LogManager.getLogger(PreAuthDataServiceImpl.class);
	
	@Override
	public String getPatientDataById(String txnid) {
		return CommonUtility.userRequest(null,null, applicationConstantConfig.GET_PATIENT_DATA_BY_ID+"?txnid="+txnid);
	}
	
	@Override
	public String savePrimaryDaignosis(PrimaryDiagnosis diagnosis) {
		Gson gson = new Gson();
		return CommonUtility.userRequest(null,gson.toJson(diagnosis),applicationConstantConfig.SAVE_PRIMARY_DAIGNOSIS_REQUEST);
	}

	@Override
	public String getPrimaryDaignoseData(String txnid) {
		return CommonUtility.userRequest(null,null,applicationConstantConfig.GET_PRIMARY_DAIGNOSIS_STORED_DATA+"?txnid="+txnid);
	}
	
	@Override
	public String deletePrimaryDaignoseData(String txnid, String tempId) {
		return CommonUtility.userRequest(null,null,applicationConstantConfig.DELETE_PRIMARY_DAIGNOSIS_STORED_DATA+"?txnid="+txnid+"&tempid="+tempId);
	}

	@Override
	public String saveSecondaryDiagnosis(SecondaryDiagnosis diagnosis) {
		Gson gson = new Gson();
		return CommonUtility.userRequest(null,gson.toJson(diagnosis),applicationConstantConfig.SAVE_SECONDARY_DAIGNOSIS_REQUEST);
	}
	
	@Override
	public String getSecondaryDaignoseData(String txnid) {
		return CommonUtility.userRequest(null,null,applicationConstantConfig.GET_SECONDARY_DAIGNOSIS_STORED_DATA+"?txnid="+txnid);
	}
	
	@Override
	public String deleteSecondaryDaignoseData(String txnid, String tempId) {
		return CommonUtility.userRequest(null,null,applicationConstantConfig.DELETE_SECONDARY_DAIGNOSIS_STORED_DATA+"?txnid="+txnid+"&tempid="+tempId);
	}	
	
	@Override
	public String catchPreAuthTreatmentProtocal(TreatmentProtocol treatmentProtocol,HttpSession session) {
		Gson gson = new Gson();
		String token = (String) session.getAttribute("loginToken");
		return CommonUtility.userRequest(token,gson.toJson(treatmentProtocol),applicationConstantConfig.SAVE_TREATMENT_PROTOCOL_REQUEST);
	}
	
	@Override
	public String savePreAuth(SavePreauthorizationMasterRequest savePreauthorizationMasterRequest) {
		Gson gson = new Gson();
		String request = gson.toJson(savePreauthorizationMasterRequest);
		custumLog.generateLogFile(request, savePreauthorizationMasterRequest.getRequestId(), "PRE_AUTH");
		return CommonUtility.userRequest(null,request, applicationConstantConfig.SAVE_PREAUTHORIZATION_REQUEST);
	}

	@Override
	public String getDaignosticMasterData(String token, String codeordesc) {
		return CommonUtility.userRequest(null,null,applicationConstantConfig.SEARCH_DAIGNOSIS_MASTER_DATA+"?codeordesc="+codeordesc);
	}

	

	
}
