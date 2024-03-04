package com.gov.nha.bis.server.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gov.nha.bis.server.properties.ApplicationConstantConfig;
import com.gov.nha.bis.server.rest.service.PreAuthDataService;

@Controller
@CrossOrigin
public class PreAuthMasterController extends NhaBisBaseController {

	private static final Logger logger = LoggerFactory.getLogger(PreAuthMasterController.class);

	@Autowired
	public ApplicationConstantConfig applicationConstantConfig;


	@Autowired
	public PreAuthDataService preAuthDataService;
	
	//search assigner or sub assigner
	@PostMapping(value="/searchIcdData")
	public @ResponseBody String getDaignosticMasterData(@RequestParam String codeordesc ,HttpServletRequest request, ModelMap model,Locale locale,HttpSession session) {
		logger.info("getDaignosticMasterData");	
		String token = (String) session.getAttribute("loginToken");
		logger.info("getDaignosticMasterData "+session.getAttribute("loginToken"));	
		return preAuthDataService.getDaignosticMasterData(token,codeordesc);
	}
}