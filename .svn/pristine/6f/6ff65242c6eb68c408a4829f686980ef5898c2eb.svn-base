package com.gov.nha.bis.server.rest.service.Impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gov.nha.bis.server.config.token.NhaBisUserAuthenticateTokenService;
import com.gov.nha.bis.server.properties.ApplicationConstantConfig;
import com.gov.nha.bis.server.rest.service.WalletDataService;

@Service
public class WalletDataServiceImpl implements WalletDataService {
	
	@Autowired
	public ApplicationConstantConfig applicationConstantConfig; 
	
	@Autowired
	public NhaBisUserAuthenticateTokenService nhaBisUserAuthenticateTokenService;
	
	private static final Logger logger = LogManager.getLogger(WalletDataServiceImpl.class);
	
	@Override
	public String walletDataService(String hhid, String url) {
		
		return getUserWalletBalance(nhaBisUserAuthenticateTokenService.getTokenOauth2_0(applicationConstantConfig.NHA_TMS_WALLET_Client_ID,
				applicationConstantConfig.NHA_TMS_WALLET_Secret_ID,
				applicationConstantConfig.NHA_TMS_WALLET_Token_URL)
				, registerUserRequestJson(hhid), url);
	}

	
	public  String registerUserRequestJson(String hhid){
		JSONObject data= new JSONObject();
		data.put("hhid", hhid);
		
		logger.info(data.toString());
		return data.toString();
	}
	
	
	public String getUserWalletBalance( String sAccessToken,String requestJson,String url){
		String returnStr=null;
		RestTemplate restTemplate = new RestTemplate();
		try{
			logger.info("url===="+url);
			HttpHeaders headers = new HttpHeaders();
			
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setBearerAuth(sAccessToken);
			HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);

			returnStr = restTemplate.postForObject(url, entity, String.class);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			return returnStr;
	}
}
