package com.gov.nha.bis.server.config.token;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gov.nha.bis.server.util.NhaSSSLUtil;

@Service
public class NhaBisUserAuthenticateTokenService {
	
	private static final Logger logger = LoggerFactory.getLogger(NhaBisUserAuthenticateTokenService.class);
	

	public  String getTokenOauth2_0(String clientId,String clientSecret,String OAUTH_ACCESS_TOKEN_URL){

		NhaSSSLUtil.setDefaultSSL();
		
		BufferedReader reader = null;
		HttpsURLConnection connection = null;
		String returnTokenValue = "";

		
		String auth = clientId + ":" + clientSecret;
		String authentication =
				Base64.getEncoder().encodeToString(auth.getBytes());
		String grantTypeContent ="grant_type=client_credentials";
		
		try {


			URL url = new URL(OAUTH_ACCESS_TOKEN_URL);
			connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", "basic " +
					authentication);
			connection.setRequestProperty("Accept", "application/json");
		
			PrintStream os = new PrintStream(connection.getOutputStream());
			os.print(grantTypeContent);
			os.close();
			reader = new BufferedReader(new
					InputStreamReader(connection.getInputStream()));
			String line = null;
			StringWriter out = new
					StringWriter(connection.getContentLength() > 0 ?
							connection.getContentLength() : 2048);
			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			String response = out.toString();
		
			
			returnTokenValue =new JSONObject(response.toString()).getString("access_token");
		
		
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error : " + e.getMessage());
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					logger.info("Error : " + e.getMessage());
				}
			}
			connection.disconnect();
		}
		//logger.info(returnTokenValue);
		return returnTokenValue;

	}
	public  String getTokenOauth2_0_1(String clientId,String clientSecret,String OAUTH_ACCESS_TOKEN_URL){

		NhaSSSLUtil.setDefaultSSL();
		
		BufferedReader reader = null;
		HttpsURLConnection connection = null;
		String returnTokenValue = "";

		
		String auth = clientId + ":" + clientSecret;
		String authentication =
				Base64.getEncoder().encodeToString(auth.getBytes());
		String grantTypeContent ="grant_type=client_credentials";
		
		try {


			URL url = new URL(OAUTH_ACCESS_TOKEN_URL);
			connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", "basic " +
					authentication);
			connection.setRequestProperty("Accept", "application/json");
		
			PrintStream os = new PrintStream(connection.getOutputStream());
			os.print(grantTypeContent);
			os.close();
			reader = new BufferedReader(new
					InputStreamReader(connection.getInputStream(),Charset.forName("UTF-8")));

			String line = null;
			StringWriter out = new
					StringWriter(connection.getContentLength() > 0 ?
							connection.getContentLength() : 2048);
			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			String response = out.toString();
			
			
			returnTokenValue =new JSONObject(response.toString()).getString("access_token");
		
		
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error : " + e.getMessage());
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					logger.info("Error : " + e.getMessage());
				}
			}
			connection.disconnect();
		}
		
		return returnTokenValue;

	}
	
	//public static void main(String[] args) {
	//	NhaBisCardAccessTokenService token = new NhaBisCardAccessTokenService();
		//System.out.println(token.getTokenOauth2_0("PMJAY_BIS_01", "57e9a295-24ce-4074-a8e7-bbe671eac0bc", "https://apis-prd.pmjay.gov.in/prod/gateway/v0.5/sessions"));
	//	System.out.println(token.getTokenOauth2_0_1("PMJAY_BIS_01", "57e9a295-24ce-4074-a8e7-bbe671eac0bc", "https://apis-prd.pmjay.gov.in/prod/gateway/v0.5/sessions"));

	
//	}

}
