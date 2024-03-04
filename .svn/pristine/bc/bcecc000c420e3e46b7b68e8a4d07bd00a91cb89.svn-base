package com.gov.nha.bis.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gov.nha.bis.server.properties.ApplicationConstantConfig;
import com.gov.nha.bis.server.rest.service.WalletDataService;

@Controller
@CrossOrigin
public class WalletDataController extends NhaBisBaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(WalletDataController.class);

	@Autowired
	public ApplicationConstantConfig applicationConstantConfig;
	
	@Autowired
	public WalletDataService walletDataService;
	
	
	@PostMapping(value="/getWalletBalance")
	public @ResponseBody String getRegisteredPatient(Model model) {
		String walletResponse= null;
		
		 walletResponse= walletDataService.walletDataService("hhid", applicationConstantConfig.NHA_TMS_WALLET_URL);
		 logger.info(walletResponse);
		 return walletResponse;
				
	}	


}
