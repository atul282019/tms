package com.gov.nha.bis.server.controller;

import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.util.encoders.Base64;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gov.nha.bis.server.model.ApplicationForm;
import com.gov.nha.bis.server.properties.ApplicationConstantConfig;
import com.gov.nha.bis.server.rest.service.ConnectRdMobileService;
import com.gov.nha.bis.server.util.TransactionManager;

@Controller
public class ConnectRdMobileController extends NhaBisBaseController{

	private static final Logger logger = LogManager.getLogger(ConnectRdMobileController.class);

	@Autowired
	public ConnectRdMobileService connectRdMobileService;

	@Autowired
	public ApplicationConstantConfig applicationConstantConfig;


	@RequestMapping(value="/connectRdMobile",method = RequestMethod.GET)
	public ModelAndView beneficiaryViewGET(HttpServletRequest request,
			@ModelAttribute("applicationForm") ApplicationForm applicationForm,
			Locale locale,Model model)
	{

		return new ModelAndView("connectRdMobile", "command", applicationForm);
	}
	@RequestMapping(value="/connectRdMobileForDD",method = RequestMethod.GET)
	public ModelAndView beneficiaryViewDDGET(HttpServletRequest request,
			@ModelAttribute("applicationForm") ApplicationForm applicationForm,
			Locale locale,Model model)
	{

		return new ModelAndView("connectRdMobileForDD", "command",applicationForm);
	}


	@RequestMapping(value="/createSession",method = RequestMethod.POST)
	public @ResponseBody String createSession(@ModelAttribute("applicationForm") ApplicationForm applicationForm,
			Locale locale,Model model)
	{
		ObjectMapper mapper = new ObjectMapper();
		String res=null;
		
		String userId = (String) session.getAttribute("loginId");
		HashMap<String, String> kycMap = new  HashMap<String, String> ();
		String qrimg="";
		
		
		String barCodeData=	connectRdMobileService.createSession(userId);
		logger.info("barCodeData=="+barCodeData);

		if(!ObjectUtils.isEmpty(barCodeData)) {
			JSONObject barCodeJson= new JSONObject(barCodeData);

			if(barCodeJson.getString("ret").equalsIgnoreCase("Y")) {
				qrimg=barCodeJson.getString("qrimg");
				logger.info("qrimg====  "+qrimg);
				kycMap.put("qrimg", qrimg);

				kycMap.put("status", "Y");
				session.setAttribute("suid", barCodeJson.getString("suid"));

			}else {
				kycMap.put("status", "N");
			}

		}else {
			kycMap.put("status", "N");
		}

		try {
			res = mapper.writeValueAsString(kycMap);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return res;
	}

	@RequestMapping(value="/waitForAck",method = RequestMethod.POST)
	public @ResponseBody String waitForAck(
			@ModelAttribute("applicationForm") ApplicationForm applicationForm,
			Locale locale,Model model)
	{
		ObjectMapper mapper = new ObjectMapper();
		String res=null;
		HashMap<String, String> kycMap = new  HashMap<String, String> ();

		String phoneno="";
		String devip="";


		String suid="";
		if(session.getAttribute("suid")!=null) {
			suid=(String)session.getAttribute("suid");

		}

		String deviceRes=	connectRdMobileService.waitForAck(suid,"55000");
		logger.info("deviceRes=="+deviceRes);

		if(!ObjectUtils.isEmpty(deviceRes)) {
			JSONObject barCodeJson= new JSONObject(deviceRes);

			if(barCodeJson.getString("ret").equalsIgnoreCase("Y")) {
				phoneno=barCodeJson.getString("phoneno");
				devip=barCodeJson.getString("devip");
				logger.info("devip====  "+devip);

				kycMap.put("phoneno", phoneno);
				kycMap.put("devip", devip);

				kycMap.put("status", "Y");
				session.setAttribute("phoneno",phoneno);
				session.setAttribute("devip",devip);

			}else {
				kycMap.put("status", "N");
			}

		}else {
			kycMap.put("status", "N");
		}

		try {
			res = mapper.writeValueAsString(kycMap);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return res;
	}


	@RequestMapping(value="/sendAckConf",method = RequestMethod.POST)
	public @ResponseBody String sendAckConf(
			@ModelAttribute("applicationForm") ApplicationForm applicationForm,
			Locale locale,Model model)
	{
		ObjectMapper mapper = new ObjectMapper();
		String res=null;
		HashMap<String, String> kycMap = new  HashMap<String, String> ();

		String nsuid=TransactionManager.otpTxnId(32);

		String suid="";
		String rip="";
		if(session.getAttribute("suid")!=null) {
			suid=(String)session.getAttribute("suid");

		}
		session.setAttribute("nsuid", nsuid);
		String deviceRes=	connectRdMobileService.SendAckConf(suid,"55000",nsuid,"Y");
		logger.info("deviceRes=="+deviceRes);

		if(!ObjectUtils.isEmpty(deviceRes)) {
			JSONObject barCodeJson= new JSONObject(deviceRes);
			// {"ret":"Y","rip":"10.200.2.20","rcode":"RC:1107"}
			if(barCodeJson.getString("ret").equalsIgnoreCase("Y") 
					&& barCodeJson.getString("rcode").equalsIgnoreCase("RC:1107")) {
				rip=barCodeJson.getString("rip");

				kycMap.put("rip", rip);

				kycMap.put("status", "Y");
				session.setAttribute("rip",rip);


			}else {
				kycMap.put("status", "N");
			}

		}else {
			kycMap.put("status", "N");
		}

		try {
			res = mapper.writeValueAsString(kycMap);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return res;
	}

	@RequestMapping(value="/faceCaptureReq",method = RequestMethod.POST)
	public @ResponseBody String faceCaptureReq(
			@ModelAttribute("applicationForm") ApplicationForm applicationForm,
			Locale locale,Model model)
	{
		ObjectMapper mapper = new ObjectMapper();
		String res=null;
		HashMap<String, String> kycMap = new  HashMap<String, String> ();

		String nsuid="";
		String pload="";
		String photo="";
		if(session.getAttribute("suid")!=null) {
			nsuid=(String)session.getAttribute("suid");

		}

		logger.info("nsuid==="+nsuid);
		String rdFaceRes=	connectRdMobileService.faceRDCapture(nsuid,"55000","facerd");
		logger.info("deviceRes=="+rdFaceRes);

		if(!ObjectUtils.isEmpty(rdFaceRes)) {
			JSONObject barCodeJson= new JSONObject(rdFaceRes);

			if(barCodeJson.getString("ret").equalsIgnoreCase("Y") ) {

				pload=barCodeJson.getString("pload");
				logger.info("pload::"+pload);
				/*
				 * logger.info("Before==="+new Date()); DefaultExecutor executor = new
				 * DefaultExecutor(); ExecuteWatchdog watchdog = new ExecuteWatchdog(6000);
				 * executor.setWatchdog(watchdog); logger.info("After==="+new Date());
				 */
				String phtFaceRes=	connectRdMobileService.facePhtCapture(nsuid,"50000","capphoto");

				
				if(!ObjectUtils.isEmpty(phtFaceRes)) {
					JSONObject phtFaceJson= new JSONObject(phtFaceRes);
					if(phtFaceJson.getString("ret").equalsIgnoreCase("Y") ) {	

						photo=phtFaceJson.getString("photo");

						kycMap.put("facePht", photo);
						kycMap.put("pidData", new String(Base64.encode(pload.getBytes())) );

						kycMap.put("status", "Y");

					}else {
						kycMap.put("status", "N");
					}
				}

			}else {
				kycMap.put("status", "N");
			}

		}else {
			kycMap.put("status", "N");
		}

		try {
			res = mapper.writeValueAsString(kycMap);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return res;
	}



}
