package com.gov.nha.bis.server.controller;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gov.nha.bis.server.properties.ApplicationConstantConfig;
import com.gov.nha.bis.server.rest.service.UserAuthenticationService;

@Controller
@CrossOrigin
public class ReadImageContentController extends NhaBisBaseController{

	private static final Logger logger = LoggerFactory.getLogger(ReadImageContentController.class);

	@Autowired
	public ApplicationConstantConfig applicationConstantConfig;

	@Autowired
	UserAuthenticationService userAuthenticationService;

	@GetMapping(value="/imagecontetread")
	public ModelAndView getImageContentRead(Model model) {
		return new ModelAndView("check-document", "command", model);
	}
	
	@PostMapping(value="/readImageContent")
	public @ResponseBody String readImageContent(HttpSession session,@RequestParam String reportType,
			 @RequestParam("reportDocument") MultipartFile reportDocument) throws IOException {
		 
		 String response= null;
		 byte [] byteArr=reportDocument.getBytes();
		 String encodedfile = Base64.getEncoder().encodeToString(byteArr);
		
		 response= userAuthenticationService.readImageContent(reportType,encodedfile,applicationConstantConfig.IMAGE_CONTENT_READ_API);
		 logger.info("readImageContent Response"+response);
		 return response;		
	}
	
}