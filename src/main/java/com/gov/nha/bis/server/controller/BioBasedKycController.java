package com.gov.nha.bis.server.controller;
/**
 * @author Vinay Kushwaha
 * @Email  vinaykushwaha85@gmail.com

 */
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gov.nha.bis.server.model.ApplicationForm;
import com.gov.nha.bis.server.properties.ApplicationConstantConfig;
import com.gov.nha.bis.server.rest.service.BioKycService;

@Controller
public class BioBasedKycController {

	private static final Logger logger = LogManager.getLogger(BioBasedKycController.class);

	@Autowired
	BioKycService bioKycService;

	@Autowired
	ApplicationConstantConfig applicationConstantConfig;
	
	@RequestMapping(value="/bioBasedKyc",method = RequestMethod.POST)
	public @ResponseBody String bioBasedKyc(HttpServletRequest request,	@ModelAttribute("applicationForm") ApplicationForm applicationForm,	Locale locale,Model model){
		ObjectMapper mapper = new ObjectMapper();
		String res=null;
		HashMap<String, String> kycMap = new  HashMap<String, String> ();
		String	response=bioKycService.bioKyc(applicationForm.getAadhar().replaceAll(" ", ""),applicationForm.getPidData(),
				applicationForm.getBioType(), applicationConstantConfig.BIO_KYC_URL);
		JSONObject demoRes=null;
	    //logger.info("response===="+response);
		if(!ObjectUtils.isEmpty(response)) {
			demoRes= new JSONObject(response);
			if(Boolean.valueOf(demoRes.getString("status"))) {

				JSONObject UidData =demoRes.getJSONObject("UidData");
				JSONObject poi =UidData.getJSONObject("poi");

				kycMap.put("kycName", poi.isNull("name")?" ":poi.getString("name"));
				kycMap.put("kycGender",poi.isNull("gender")?" ": poi.getString("gender"));
				kycMap.put("kycDob", poi.isNull("dob")?" ":poi.getString("dob"));
				kycMap.put("uidToken", UidData.isNull("tkn")?" ":UidData.getString("tkn"));
				kycMap.put("pht", UidData.isNull("pht")?" ":UidData.getString("pht"));
				JSONObject poa =UidData.getJSONObject("poa");
				kycMap.put("kycFname", poa.isNull("co")?" ":poa.getString("co"));

				String address=(poa.isNull("house")?" ":poa.getString("house"))
						+" "+(poa.isNull("street")?" ":poa.getString("street"))	
						+" "+(poa.isNull("vtc")?" ":poa.getString("vtc"))	
						+" "+(poa.isNull("dist")?" ":poa.getString("dist"))	
						+" "+(poa.isNull("state")?" ":poa.getString("state"))	
						+" "+(poa.isNull("pc")?" ":poa.getString("pc"));

				kycMap.put("kycAdr", address);

				kycMap.put("vtc_s", (poa.isNull("vtc")?" ":poa.getString("vtc")));
				kycMap.put("district_name_s", (poa.isNull("dist")?" ":poa.getString("dist")));
				kycMap.put("state_name_s", (poa.isNull("state")?" ":poa.getString("state")));
				kycMap.put("post_s", (poa.isNull("pc")?" ":poa.getString("pc")));

				kycMap.put("status", "Y");

			}else {
				kycMap.put("status", "N");
			}
		}else {
			kycMap.put("status", "N");
		}
		String bioT=applicationForm.getBioType();
	
		try {
			res = mapper.writeValueAsString(kycMap);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return res;
	}

}
