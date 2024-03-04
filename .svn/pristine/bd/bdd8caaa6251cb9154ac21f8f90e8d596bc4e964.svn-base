package com.gov.nha.bis.server.rest.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.gov.nha.bis.server.properties.ApplicationConstantConfig;
import com.gov.nha.bis.server.requestResponse.HospitalSpecialityMapperRequest;
import com.gov.nha.bis.server.rest.service.MasterDataService;
import com.gov.nha.bis.server.util.CommonUtility;

@Service
public class MasterDataServiceImpl implements MasterDataService {

	
	@Autowired
	ApplicationConstantConfig applicationConstantConfig;

	@Override
	public String savehospitalSpeciality(String session, HospitalSpecialityMapperRequest hospStateMapping) {
		Gson gson = new Gson();
		return CommonUtility.userRequest(session,gson.toJson(hospStateMapping), applicationConstantConfig.SAVE_HOSPITAL_SPECIALITY_MAPPING);
	}

	@Override
	public String statusChangeHospSpecMapping(String session, String mapid) {
		return CommonUtility.userRequest(session,null, applicationConstantConfig.CHANGE_HOSPITAL_SPECILAITY_MAPPING_STATUS+"?mapid="+mapid);
	}

}
