package com.gov.nha.bis.server.rest.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gov.nha.bis.server.face.auth.FaceRdRequest;
import com.gov.nha.bis.server.properties.ApplicationConstantConfig;
import com.gov.nha.bis.server.util.TransactionManager;

@Service
public class ConnectRdMobileService {


	@Autowired
	public ApplicationConstantConfig applicationConstantConfig;



	private static final Logger logger = LogManager.getLogger(ConnectRdMobileService.class);



	public String faceRDCapture(String nsuid,String wtimeout,String facerd) {

		
		  String pload=
		  FaceRdRequest.getPidOptions(applicationConstantConfig.RD_PIDOPTIONS_VER, "",
		  "", "", "", "", "", "", applicationConstantConfig.RD_OPTS_PIDVER, "", "",
		  applicationConstantConfig.NHA_BIS_FACE_WADH_KEY, "",
		  applicationConstantConfig.RD_OPTS_ENV, "txnId",
		  TransactionManager.TxnId(4), "purpose", "auth","language", "en");
		  pload=pload.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");
		
		
		String res=requestSendAckConf(nsuid,wtimeout,
				getRequestCapture(facerd,pload), applicationConstantConfig.FACE_THIRD_PARTY_URL+"3");


		return res;

	}

	
	
	public String facePhtCapture(String nsuid,String wtimeout,String facerd) {

		
		String res=requestSendAckConf(nsuid,wtimeout,
				getRequestCapture(facerd,""), applicationConstantConfig.FACE_THIRD_PARTY_URL+"3");


		return res;

}

	
	public String getRequestCapture(String facerd,String pload) {

		JSONObject request= new JSONObject();
		request.put("cmd", facerd);
		request.put("pload", pload);

		return request.toString();

	}


	public   String requestFaceRDCapture(String suid,String wtimeout,
			String requestJson,String url){
		String returnStr=null;
		RestTemplate restTemplate = new RestTemplate();
		try{

			logger.info("requestJson===="+requestJson);
			HttpHeaders headers = new HttpHeaders();

			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("suid",suid);
			headers.set("rtimeout",wtimeout);

			HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);

			returnStr = restTemplate.postForObject(url, entity, String.class);
			logger.info("returnStr==="+returnStr);
		}catch(Exception e)
		{
			e.printStackTrace();
		}


		return returnStr;
	}








	public String createSession(String userId) {


		String res=createSessionRequest(applicationConstantConfig.FACE_APIKEY,
				getRequest(userId), applicationConstantConfig.FACE_THIRD_PARTY_URL+"1");


		return res;

	}

	public String getRequest(String userId) {

		JSONObject request= new JSONObject();
		request.put("curl", applicationConstantConfig.FACE_CURL);
		request.put("stimeout", applicationConstantConfig.FACE_STIMEOUT);
		request.put("hostid", applicationConstantConfig.FACE_HOSTID);

		request.put("suid", "");

		request.put("userid", userId);
		request.put("passcode", applicationConstantConfig.FACE_PASSCODE);
		return request.toString();

	}



	public String waitForAck(String suid,String wtimeout) {

		String res=requestWaitForAck(suid,wtimeout,
				"", applicationConstantConfig.FACE_THIRD_PARTY_URL+"5");


		return res;

	}



	public String SendAckConf(String suid,String wtimeout,String nsuid,String ret) {

		String res=requestSendAckConf(suid,wtimeout,
				getRequestAckConf(nsuid,ret), applicationConstantConfig.FACE_THIRD_PARTY_URL+"7");


		return res;
	}


	public String getRequestAckConf(String nsuid,String ret) {

		JSONObject request= new JSONObject();
		request.put("nsuid", nsuid);
		request.put("ret", ret);

		return request.toString();

	}


	public   String requestSendAckConf(String suid,String wtimeout,
			String requestJson,String url){
		String returnStr=null;
		RestTemplate restTemplate = new RestTemplate();
		try{

			logger.info("requestJson===="+requestJson);
			HttpHeaders headers = new HttpHeaders();

			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("suid",suid);
			headers.set("rtimeout",wtimeout);

			HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);

			returnStr = restTemplate.postForObject(url, entity, String.class);
			logger.info("returnStr==="+returnStr);
		}catch(Exception e)
		{
			e.printStackTrace();
		}


		return returnStr;
	}






	public   String requestWaitForAck(String suid,String wtimeout,String requestJson,String url){
		String returnStr=null;
		RestTemplate restTemplate = new RestTemplate();
		try{

			logger.info("requestJson===="+requestJson);
			HttpHeaders headers = new HttpHeaders();

			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("suid",suid);
			headers.set("wtimeout",wtimeout);

			HttpEntity<String> entity = new HttpEntity<String>(headers);

			ResponseEntity<String> response = restTemplate.exchange(
					url,
					HttpMethod.GET,
					entity,
					String.class,
					1
					);

			logger.info("returnStr==="+response.getBody());
			returnStr=response.getBody();
		}catch(Exception e)
		{
			e.printStackTrace();
		}


		return returnStr;
	}




	/*
	 * public String requestSendAckConf(String suid,String wtimeout,String
	 * requestJson,String url){ String returnStr=null; RestTemplate restTemplate =
	 * new RestTemplate(); try{
	 * 
	 * logger.info("requestJson===="+requestJson); HttpHeaders headers = new
	 * HttpHeaders();
	 * 
	 * headers.setContentType(MediaType.APPLICATION_JSON); headers.set("suid",suid);
	 * headers.set("wtimeout",wtimeout);
	 * 
	 * HttpEntity<String> entity = new HttpEntity<String>(headers);
	 * 
	 * ResponseEntity<String> response = restTemplate.exchange( url,
	 * HttpMethod.POST, entity, String.class, 1 );
	 * 
	 * logger.info("returnStr==="+response.getBody()); returnStr=response.getBody();
	 * }catch(Exception e) { e.printStackTrace(); }
	 * 
	 * 
	 * return returnStr; }
	 * 
	 */	

	public   String createSessionRequest(String apikey,String requestJson,String url){
		String returnStr=null;
		RestTemplate restTemplate = new RestTemplate();
		try{

			logger.info("requestJson===="+requestJson);
			HttpHeaders headers = new HttpHeaders();

			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("apikey",apikey);

			HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);

			returnStr = restTemplate.postForObject(url, entity, String.class);
			logger.info("returnStr==="+returnStr);
		}catch(Exception e)
		{
			e.printStackTrace();
		}


		return returnStr;
	}





}
