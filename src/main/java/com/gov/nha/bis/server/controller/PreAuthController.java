package com.gov.nha.bis.server.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gov.nha.bis.server.preauth_requestResponse.ErupiDetails;
import com.gov.nha.bis.server.preauth_requestResponse.ExaminationFindings;
import com.gov.nha.bis.server.preauth_requestResponse.ImplantDetails;
import com.gov.nha.bis.server.preauth_requestResponse.InvestigationDetails;
import com.gov.nha.bis.server.preauth_requestResponse.PackageDetails;
import com.gov.nha.bis.server.preauth_requestResponse.PatientHospDiagnosis;
import com.gov.nha.bis.server.preauth_requestResponse.PatientPersonalHistory;
import com.gov.nha.bis.server.preauth_requestResponse.PrimaryDiagnosis;
import com.gov.nha.bis.server.preauth_requestResponse.SavePreauthorizationMasterRequest;
import com.gov.nha.bis.server.preauth_requestResponse.SecondaryDiagnosis;
import com.gov.nha.bis.server.preauth_requestResponse.StratDetails;
import com.gov.nha.bis.server.properties.ApplicationConstantConfig;
import com.gov.nha.bis.server.requestResponse.AdmissionDetailDocument;
import com.gov.nha.bis.server.requestResponse.AdmissionDetailDocumentDropdownObject;
import com.gov.nha.bis.server.requestResponse.ShowImplantDataReq;
import com.gov.nha.bis.server.requestResponse.ShowStratificationAndImplantResponse;
import com.gov.nha.bis.server.requestResponse.ShowStratificationDataReq;
import com.gov.nha.bis.server.requestResponse.TempAdmissionDetailDocument;
import com.gov.nha.bis.server.requestResponse.TempInvestigationDetails;
import com.gov.nha.bis.server.requestResponse.TreatmentProtocol;
import com.gov.nha.bis.server.rest.service.PreAuthDataService;
import com.gov.nha.bis.server.rest.service.TmsMasterService;
import com.gov.nha.bis.server.rest.service.WalletDataService;
import com.gov.nha.bis.server.rest.service.Impl.PatientRegistrationServiceImpl;
import com.gov.nha.bis.server.util.JSONResponse;
import com.gov.nha.bis.server.util.JSONUtil;
import com.gov.nha.bis.server.util.MessageConstant;
import com.gov.nha.bis.server.util.ObjectMapperUtils;

@Controller
@CrossOrigin
public class PreAuthController extends NhaBisBaseController {

	private static final Logger logger = LoggerFactory.getLogger(PreAuthController.class);

	@Autowired
	public ApplicationConstantConfig applicationConstantConfig;

	@Autowired
	public WalletDataService walletDataService;

	@Autowired
	public PatientRegistrationServiceImpl patientRegistrationServiceImpl;

	@Autowired
	public PreAuthDataService preAuthDataService;

	@Autowired
	public TmsMasterService tmsMasterService;

	Map<String, List<PrimaryDiagnosis>>  primaryDiagnosisMap = new HashedMap<String, List<PrimaryDiagnosis>>();
	Map<String, List<SecondaryDiagnosis>>  secondaryDiagnosisMap = new HashedMap<String, List<SecondaryDiagnosis>>();


	
	Map<String, List<TreatmentProtocol>>  treatmentProtocolMap = new HashedMap<String, List<TreatmentProtocol>>();
	Map<String, ExaminationFindings>  examinationMap = new HashedMap<String, ExaminationFindings>();
	Map<String, PatientPersonalHistory>  patientPersonalHistoryMap = new HashedMap<String, PatientPersonalHistory>();
	Map<String, PatientHospDiagnosis>  patientHospDiagnosisMap = new HashedMap<String, PatientHospDiagnosis>();
	Map<String, SavePreauthorizationMasterRequest>  savePreauthorizationMasterRequestMap = new HashedMap<String, SavePreauthorizationMasterRequest>();
	Map<String, List<StratDetails>>  stratificationMap = new HashedMap<String, List<StratDetails>>();
	Map<String, List<ImplantDetails>>  implantDetailsMap = new HashedMap<String, List<ImplantDetails>>();
	ArrayList <ErupiDetails> erupiDetails = new ArrayList <ErupiDetails>();
	Map<String, List<InvestigationDetails>>  investigationDetails = new HashedMap<String, List<InvestigationDetails>>();
	Map<String, List<AdmissionDetailDocument>>  admissionDetailDocument = new HashedMap<String, List<AdmissionDetailDocument>>();

	// opening page
	@GetMapping(value="/preauth")
	public ModelAndView preAuth(Model model,@RequestParam String txnid) {
		logger.info("get Patient Registration Controller");	
		String response= null;JSONObject userJson= null;
		try {
			response= preAuthDataService.getPatientDataById(txnid);			
			if(!ObjectUtils.isEmpty(response)) {		
				 userJson= new JSONObject(response);
				if(userJson.getString("status")!=null 
						&& userJson.getString("status").equalsIgnoreCase("SUCCESS")
						&&  userJson.getJSONArray("data")!=null) {
					JSONArray jsonArray = userJson.getJSONArray("data");  
					JSONObject explrObject = jsonArray.getJSONObject(0);  
					model.addAttribute("patientName",explrObject.getString("membername"));
					model.addAttribute("patientGender",explrObject.getString("gender"));
					model.addAttribute("beneficiaryCardId",explrObject.getString("nhaid"));
					
					model.addAttribute("patientId",explrObject.getString("patientid"));
					model.addAttribute("patientImage",explrObject.getString("photo"));
					model.addAttribute("benContactName",explrObject.getString("mobilenumber"));
					
					model.addAttribute("familyId",explrObject.getString("member_id"));
					model.addAttribute("verified",explrObject.getString("name"));
					model.addAttribute("benRegistrationData",explrObject.getString("creation_date"));
					model.addAttribute("txnid",explrObject.getString("txnid"));
				}
			}
			return new ModelAndView("preauth", "command", "");
		} catch (Exception e) {
		}finally {
			response=null; userJson= null;
		}	
		return null;
	}	
	
	@PostMapping(value="/catchPrimaryDiagnosis")
	public @ResponseBody String catchDiagnosis(Model model, @ModelAttribute("diagnosis")PrimaryDiagnosis diagnosis) {		
		try {
			diagnosis.setTempId(String.valueOf(Math.random()));
			diagnosis.setTxnid(diagnosis.getTxnid());
			diagnosis.setIcdCode(Optional.ofNullable(diagnosis.getIcdCode()).orElse(null));
			diagnosis.setIcdDesc(Optional.ofNullable(diagnosis.getIcdDesc()).orElse(null));
			diagnosis.setIcdURI(Optional.ofNullable("http://id.who.int/icd/release/11/2022-02/mms/1986853646").orElse(null));
			
			return preAuthDataService.savePrimaryDaignosis(diagnosis);
		} catch (Exception e) {
			return null;
		}
	}
	
	@PostMapping(value="/getPrimaryDaignoseData")
	public @ResponseBody String getPrimaryDaignoseData(Model model, @RequestParam String txnid) {
		try {
			return preAuthDataService.getPrimaryDaignoseData(txnid);
		} catch (Exception e) {
			return null;
		}
	}
	
	@PostMapping(value="/deletePrimaryDaignoseData")
	public @ResponseBody String deletePrimaryDaignoseData(Model model, @RequestParam String tempId, @RequestParam String txnid) {
		try {
			return preAuthDataService.deletePrimaryDaignoseData(txnid,tempId);
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping(value="/catchSecondaryDiagnosis")
	public @ResponseBody String catchSecondaryDiagnosis(Model model, @ModelAttribute("diagnosis")SecondaryDiagnosis diagnosis) {		
		try {
			diagnosis.setTempId(String.valueOf(Math.random()));
			diagnosis.setIcdCode(Optional.ofNullable(diagnosis.getIcdCode()).orElse(null));
			diagnosis.setTxnid(diagnosis.getTxnid());
			diagnosis.setIcdDesc(Optional.ofNullable(diagnosis.getIcdDesc()).orElse(null));
			diagnosis.setIcdURI(Optional.ofNullable("http://id.who.int/icd/release/11/2022-02/mms/1986853646").orElse(null));

			return preAuthDataService.saveSecondaryDiagnosis(diagnosis);
		} catch (Exception e) {
			return null;
		}
	}
	
	@PostMapping(value="/getSecondaryDaignoseData")
	public @ResponseBody String getSecondaryDaignoseData(Model model, @RequestParam String txnid) {
		try {
			return preAuthDataService.getSecondaryDaignoseData(txnid);
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping(value="/deleteSecondaryDaignoseData")
	public @ResponseBody String deleteSecondaryDaignoseData(Model model, @RequestParam String tempId, @RequestParam String txnid) {
		try {
			return preAuthDataService.deleteSecondaryDaignoseData(txnid,tempId);
		} catch (Exception e) {
			return null;
		}
	}
	
	@PostMapping(value="/getForPreAuthSpecialityMasterData")
	public @ResponseBody String getSpecialityMasterData(HttpSession session,Model model) {
		String response= null;
		
		// input parameter hospitalid-patient state
		
		// speciality will be search in the basis of following parameter
		//case1. user state = hospital state
		//case2. user state != hospital state
		
		//case1.speciality will be according to userstate and HEM data
		//case2.speciality will be according to either with (hospital or userstate)  and HEM data
	
		//1 step search in HEM DB according to state
		
		response= tmsMasterService.getSpecialityMasterData((String) session.getAttribute("loginToken"));
		return response;			
	}
	
	@PostMapping(value="/catchPreAuthTreatmentProtocal")
	public @ResponseBody String catchPreAuthTreatmentProtocal(Model model,HttpSession session, @ModelAttribute("treatmentProtocol")TreatmentProtocol treatmentProtocol) {
		try {
			return preAuthDataService.catchPreAuthTreatmentProtocal(treatmentProtocol,session);
		} catch (Exception e) {
			return null;
		}
	}
	
	@PostMapping(value="/getprotoColData")
	public @ResponseBody JSONResponse getprotoColData(Model model, @RequestParam String txnid) {
		try {
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_SUCCESS, MessageConstant.TRUE, treatmentProtocolMap.get(txnid));
		} catch (Exception e) {
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_FAILED, MessageConstant.FALSE, null);
		}
	}

	@PostMapping(value="/deleteprotoColData")
	public @ResponseBody String deleteprotoColData(Model model, @RequestParam String tempId, @RequestParam String txnid) {
		List<TreatmentProtocol> lstdaig = new ArrayList<TreatmentProtocol>();
		List<TreatmentProtocol> newlstdaig = new ArrayList<TreatmentProtocol>();
		List<StratDetails>	newarrlst =null;
		try {
			lstdaig = treatmentProtocolMap.get(txnid);
			for (TreatmentProtocol diagnosis : lstdaig) {
				if(!diagnosis.getTempId().equalsIgnoreCase(tempId)) {
					newlstdaig.add(diagnosis);
				}else {
					if(diagnosis.getStratificationstatus()!=null && diagnosis.getStratificationstatus().equalsIgnoreCase("Yes")) {
						List<StratDetails>	lststrats = stratificationMap.get(diagnosis.getTxnid());
						newarrlst = new ArrayList<StratDetails>();
						for (StratDetails stratDetails : lststrats) {
							if(!stratDetails.getPackageid().equalsIgnoreCase(diagnosis.getPackageid())
									&& !stratDetails.getProcedureid().equalsIgnoreCase(diagnosis.getProcedureid())
									&& !stratDetails.getSpeciality().equalsIgnoreCase(diagnosis.getSpeciality())) {
								newarrlst.add(stratDetails);
							}
						}
						stratificationMap.put(diagnosis.getTxnid(), newarrlst);
					}
				}	
			}
			treatmentProtocolMap.put(txnid, newlstdaig);
			return MessageConstant.RESPONSE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return MessageConstant.RESPONSE_FAILED;
		}finally {
			lstdaig=null;newarrlst =null;
		}
	}
	
//	@PostMapping(value="/getPatientDetailById")
//	public @ResponseBody String getPatientDetailDataById(@RequestParam String txnid, HttpServletRequest request, 
//			ModelMap model,Locale locale) {
//		logger.info("get Patient Registration Controller");	
//		String response= null;
//		response= preAuthDataService.getPatientDataById(txnid);
//		logger.info("--------------"+response);
//		return response;
//	}	

	@PostMapping(value="/catchPreAuthData")
	public @ResponseBody String catchGeneralFindingData(Model model, @ModelAttribute("examinationFindings")
	ExaminationFindings examinationFindings) {
		String response= "SUCCESS";
		examinationMap.put(examinationFindings.getTxnid(), examinationFindings);
		return response;

	}	

	@PostMapping(value="/catchPreAuthPersonalHistory")
	public @ResponseBody String catchPreAuthPersonalHistory(Model model, @ModelAttribute("patientPersonalHistory") 
	PatientPersonalHistory patientPersonalHistory) {
		String response= "SUCCESS";
		patientPersonalHistoryMap.put(patientPersonalHistory.getTxnid(), patientPersonalHistory);
		return response;

	}

	@PostMapping(value="/catchPastFamilyHistory")
	public @ResponseBody String catchPastFamilyHistory(Model model,  @ModelAttribute("patientHospDiagnosis") 
	PatientHospDiagnosis patientHospDiagnosis) {
		String response= "SUCCESS";

		if(patientHospDiagnosis.getFh()!=null) {
			patientHospDiagnosis.setFamilyHistory(String.join("~", patientHospDiagnosis.getFh()));
		}
		if(patientHospDiagnosis.getPh()!=null) {
			patientHospDiagnosis.setPastHistory(String.join("~", patientHospDiagnosis.getPh()));
		}
		patientHospDiagnosisMap.put(patientHospDiagnosis.getTxnid(), patientHospDiagnosis);
		return response;

	}

	@PostMapping(value="/catchPreAuthAdmissionDetail")
	public @ResponseBody String catchPreAuthAdmissionDetail(Model model, @ModelAttribute("savePreauthorizationMasterRequest") SavePreauthorizationMasterRequest savePreauthorizationMasterRequest) {
		List<TreatmentProtocol> lstprtc = new ArrayList<TreatmentProtocol>();
		Double package_price=0.0;Double implant_price=0.0;Double strat_price=0.0;
		try {
			lstprtc = treatmentProtocolMap.get(savePreauthorizationMasterRequest.getTxnid());
			for (TreatmentProtocol treatmentProtocol : lstprtc) {
				if(treatmentProtocol.getInclusiveImplantCost()!=null && !treatmentProtocol.getInclusiveImplantCost().equalsIgnoreCase("NA")) {
					implant_price = implant_price+ Double.valueOf(treatmentProtocol.getInclusiveImplantCost());
				}
				if(treatmentProtocol.getInclusiveStractsCost()!=null && !treatmentProtocol.getInclusiveStractsCost().equalsIgnoreCase("NA")) {
					strat_price = strat_price+ Double.valueOf(treatmentProtocol.getInclusiveStractsCost());
				}
				package_price = package_price+Double.valueOf(Optional.ofNullable(treatmentProtocol.getPrice()).orElse("0.00"));
			}
			if(savePreauthorizationMasterRequest!=null && !ObjectUtils.isEmpty(savePreauthorizationMasterRequest)) {
				savePreauthorizationMasterRequest.setPatientState((String)session.getAttribute("stateCode"));
				savePreauthorizationMasterRequest.setHospState((String)session.getAttribute("stateCode"));
				savePreauthorizationMasterRequest.setCaseHospCode((String)session.getAttribute("hid"));
				savePreauthorizationMasterRequest.setTotPckgAmt(String.valueOf(implant_price+strat_price+package_price));
			}			
			savePreauthorizationMasterRequestMap.put(savePreauthorizationMasterRequest.getTxnid(), savePreauthorizationMasterRequest);
			return MessageConstant.RESPONSE_SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return MessageConstant.RESPONSE_FAILED;
		}finally {
			package_price=null;implant_price=null;strat_price=null;
		}
	}

	


	@PostMapping(value="/checkForStratificationAndImplant")
	public @ResponseBody JSONResponse checkForStratificationAndImplant(HttpSession session,@RequestParam String procedureid) {
		String response = null;ShowStratificationAndImplantResponse resp = new ShowStratificationAndImplantResponse();
		try {
			response = tmsMasterService.getProcedureByprocedureId(procedureid,(String) session.getAttribute("loginToken"));
			if(!ObjectUtils.isEmpty(response)) {		
				JSONObject userJson= new JSONObject(response);
				if(userJson.getString("status")!=null 
						&& userJson.getString("status").equalsIgnoreCase("SUCCESS")
						&&  userJson.getJSONArray("data")!=null) {
					JSONArray jsonArray = userJson.getJSONArray("data");  
					JSONObject explrObject = jsonArray.getJSONObject(0);  
					resp.setStratificationstatus(explrObject.getString("stratificationstatus"));
					resp.setImplantstatus(explrObject.getString("implantstatus"));
					resp.setErupistatus(explrObject.getString("erupi_status"));
				}
			}
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_SUCCESS, MessageConstant.TRUE, resp);
		} catch (Exception e) {
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_FAILED, MessageConstant.FALSE, null);			
		}finally {
			resp=null;response=null;
		}
	}	

	

	@PostMapping(value="/getPackageTotalCost")
	public @ResponseBody JSONResponse getCostByPackage(Model model, @RequestParam String txnid) {
		List<TreatmentProtocol> lstprtc = new ArrayList<TreatmentProtocol>();
		Double package_price=0.0;Double implant_price=0.0;Double strat_price=0.0;
		try {
			lstprtc = treatmentProtocolMap.get(txnid);
			for (TreatmentProtocol treatmentProtocol : lstprtc) {
				if(treatmentProtocol.getInclusiveImplantCost()!=null && !treatmentProtocol.getInclusiveImplantCost().equalsIgnoreCase("NA")) {
					implant_price = implant_price+ Double.valueOf(treatmentProtocol.getInclusiveImplantCost());
				}
				if(treatmentProtocol.getInclusiveStractsCost()!=null && !treatmentProtocol.getInclusiveStractsCost().equalsIgnoreCase("NA")) {
					strat_price = strat_price+ Double.valueOf(treatmentProtocol.getInclusiveStractsCost());
				}
				package_price = package_price+Double.valueOf(Optional.ofNullable(treatmentProtocol.getPrice()).orElse("0.00"));
			}
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_SUCCESS, MessageConstant.TRUE, String.valueOf(package_price+implant_price+strat_price));
		} catch (Exception e) {
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_FAILED, MessageConstant.FALSE, "0.00");			
		}finally {
			lstprtc = null;package_price=null;implant_price=null;strat_price=null;
		}
	}

	@PostMapping(value="/catchStratificationDetail")
	public @ResponseBody JSONResponse catchStratificationDetail(HttpSession session,Model model, @ModelAttribute ShowStratificationDataReq req) {
		List<StratDetails> lstprtc = new ArrayList<StratDetails>();
		Double override_procedure_price = 0.0;
		try {			
			stratificationMap.remove(req.getTxnid());			
			for (String stratDetails2 : req.getStratCode()) {
				String response =  tmsMasterService.getStratificationDetailByStatificationCode(stratDetails2,(String) session.getAttribute("loginToken"));
				if(!ObjectUtils.isEmpty(response)) {		
					JSONObject userJson= new JSONObject(response);
					if(userJson.getString("status")!=null 
							&& userJson.getString("status").equalsIgnoreCase("SUCCESS")
							&&  userJson.getJSONArray("data")!=null) {
						JSONArray jsonArray = userJson.getJSONArray("data");  
						// Iterate jsonArray using for loop   
						for (int i = 0; i < jsonArray.length(); i++) {  
							// store each object in JSONObject 
							StratDetails stract = new StratDetails();
							JSONObject explrObject = jsonArray.getJSONObject(i);  
							stract.setNoOfUnits("1");
							stract.setProcedureid(req.getProcedureid());
							stract.setPackageid(req.getPackageid());
							stract.setSpeciality(req.getSpeciality());
							stract.setStratCode(explrObject.getString("stratification_code"));
							stract.setStratCost(explrObject.getString("override_procedure_price"));
							stract.setStratDtls(explrObject.getString("stratification_details"));
							stract.setStratName(explrObject.getString("stratification_options"));
							override_procedure_price = override_procedure_price 
									+ Double.valueOf(Optional.ofNullable(explrObject.getString("override_procedure_price")).orElse("0.00"));
							stract.setTotalStratCost(override_procedure_price.toString());
							stract.setTxnid(req.getTxnid());							
							lstprtc.add(stract);
						}     
					}
				}
			}
			stratificationMap.put(req.getTxnid(), lstprtc);
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_SUCCESS, MessageConstant.TRUE, override_procedure_price);
		} catch (Exception e) {
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_FAILED, MessageConstant.FALSE, null);			
		}
	}

	@PostMapping(value="/catchImplantDetail")
	public @ResponseBody JSONResponse catchImplantDetail(HttpSession session,Model model, @ModelAttribute ShowImplantDataReq implantDetails) {
		List<ImplantDetails> lstprtc = new ArrayList<ImplantDetails>();
		Double override_procedure_price = 0.0;
		try {			
			implantDetailsMap.remove(implantDetails.getTxnid());

			for (String stratDetails2 : implantDetails.getImplantCode()) {
				String response =  tmsMasterService.getImplantDetailByImplantId(stratDetails2,(String) session.getAttribute("loginToken"));
				System.out.println(response);

				if(!ObjectUtils.isEmpty(response)) {		
					JSONObject userJson= new JSONObject(response);
					if(userJson.getString("status")!=null 
							&& userJson.getString("status").equalsIgnoreCase("SUCCESS")
							&&  userJson.getJSONArray("data")!=null) {
						JSONArray jsonArray = userJson.getJSONArray("data");  
						// Iterate jsonArray using for loop   
						for (int i = 0; i < jsonArray.length(); i++) {  
							// store each object in JSONObject 
							ImplantDetails stract = new ImplantDetails();
							JSONObject explrObject = jsonArray.getJSONObject(i);
							stract.setProcedureid(implantDetails.getProcedureid());
							stract.setPackageid(implantDetails.getPackageid());
							stract.setSpeciality(implantDetails.getSpeciality());
							stract.setImplantCode(String.valueOf(explrObject.getInt("implantid")));
							stract.setImplantCost(explrObject.getString("override_procedure_price"));
							stract.setImplantCount(String.valueOf(i+1));
							stract.setImplantName(explrObject.getString("implantdetails"));
							stract.setMaximumMultiplier("");
							override_procedure_price = override_procedure_price 
									+ Double.valueOf(Optional.ofNullable(explrObject.getString("override_procedure_price")).orElse("0.00"));
							stract.setTotalImplantCost(override_procedure_price.toString());
							stract.setTxnid(implantDetails.getTxnid());							
							lstprtc.add(stract);
						}     
					}
				}
			}
			implantDetailsMap.put(implantDetails.getTxnid(), lstprtc);
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_SUCCESS, MessageConstant.TRUE, override_procedure_price);
		} catch (Exception e) {
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_FAILED, MessageConstant.FALSE, null);			
		}
	}

	@PostMapping(value="/catchInvestigationDetail")
	public @ResponseBody JSONResponse catchInvestigationDetail(InvestigationDetails investigation,HttpServletRequest request,
			ModelMap model,Locale locale,HttpSession session) {
		List<InvestigationDetails> sdlst = new ArrayList<InvestigationDetails>();
		List<TempInvestigationDetails> resp = new ArrayList<TempInvestigationDetails>();
		try {
			investigation.setTempId(String.valueOf(Math.random()));
			investigation.setFileName(investigation.getInvfile().getOriginalFilename());

			String response  =tmsMasterService.getInvestigationByInvestigationId(investigation.getFileName(),(String) session.getAttribute("loginToken")); 
			logger.info("getInvestigationDocumentForProcedures"+response);
			if(!ObjectUtils.isEmpty(response)) {		
				JSONObject userJson= new JSONObject(response);
				if(userJson.getString("status")!=null 
						&& userJson.getString("status").equalsIgnoreCase("SUCCESS")
						&&  userJson.getJSONArray("data")!=null) {
					JSONArray jsonArray = userJson.getJSONArray("data");  
					// Iterate jsonArray using for loop   
					for (int i = 0; i < jsonArray.length(); i++) {  
						// store each object in JSONObject  
						JSONObject explrObject = jsonArray.getJSONObject(i);
						investigation.setAattachName(explrObject.getString("investigationname"));
						investigation.setProcedureCode(explrObject.getString("procedure_code"));
					}     
				}
			}

			byte[] image = Base64.encodeBase64(investigation.getInvfile().getBytes());
			String result = new String(image);
			System.out.println(result);
			investigation.setImage(result);
			investigation.setInvfile(null);

			if(investigationDetails.get(investigation.getTxnId())==null) {
				sdlst.add(investigation);
				investigationDetails.put(investigation.getTxnId(), sdlst);
			}else {
				sdlst = investigationDetails.get(investigation.getTxnId());
				sdlst.add(investigation);
				investigationDetails.put(investigation.getTxnId(), sdlst);
			}
			sdlst = investigationDetails.get(investigation.getTxnId());
			resp = ObjectMapperUtils.mapAll(sdlst, TempInvestigationDetails.class);
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_SUCCESS, MessageConstant.TRUE, resp);
		} catch (Exception e) {
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_FAILED, MessageConstant.FALSE, null);
		}finally {
			investigation=null;sdlst=null;
		}

	}

	@PostMapping(value="/getInvestigationFileData")
	public @ResponseBody JSONResponse getInvestigationFileData(Model model, @RequestParam String txnid) {
		List<InvestigationDetails> sdlst = new ArrayList<InvestigationDetails>();
		List<TempInvestigationDetails> resp = new ArrayList<TempInvestigationDetails>();
		try {
			sdlst = investigationDetails.get(txnid);
			resp = ObjectMapperUtils.mapAll(sdlst, TempInvestigationDetails.class);			
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_SUCCESS, MessageConstant.TRUE, resp);
		} catch (Exception e) {
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_FAILED, MessageConstant.FALSE, null);
		}finally {
			sdlst=null;
		}
	}

	@PostMapping(value="/deleteInvestigationFileData")
	public @ResponseBody String deleteInvestigationFileData(Model model, @RequestParam String tempId, @RequestParam String txnid) {
		List<InvestigationDetails> lstdaig = new ArrayList<InvestigationDetails>();
		List<InvestigationDetails> newlstdaig = new ArrayList<InvestigationDetails>();
		try {
			lstdaig = investigationDetails.get(txnid);
			for (InvestigationDetails diagnosis : lstdaig) {
				if(!diagnosis.getTempId().equalsIgnoreCase(tempId)) {
					newlstdaig.add(diagnosis);
				}
			}
			investigationDetails.put(txnid, newlstdaig);
			return MessageConstant.RESPONSE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return MessageConstant.RESPONSE_FAILED;
		}finally {
			lstdaig=null;
		}
	}

	@PostMapping(value="/perview")
	public @ResponseBody JSONResponse perview(Model model, @RequestParam String txnid) {
		Map<String,Object> preview = new HashMap<>();
		List<AdmissionDetailDocument> sdlst = new ArrayList<AdmissionDetailDocument>();
		List<InvestigationDetails> invlst = new ArrayList<InvestigationDetails>();
		try {
			preview.put("primaryDiagnosisMap", primaryDiagnosisMap.get(txnid));
			preview.put("secondaryDiagnosisMap", secondaryDiagnosisMap.get(txnid));
			preview.put("treatmentProtocolMap", treatmentProtocolMap.get(txnid));
			preview.put("examinationMap", examinationMap.get(txnid));
			preview.put("patientPersonalHistoryMap", patientPersonalHistoryMap.get(txnid));
			preview.put("patientHospDiagnosisMap", patientHospDiagnosisMap.get(txnid));
			preview.put("preAuth", savePreauthorizationMasterRequestMap.get(txnid));

			sdlst = admissionDetailDocument.get(txnid);
			if(sdlst!=null && sdlst.size()>0) {
				preview.put("admissionDetailDocument", ObjectMapperUtils.mapAll(sdlst, TempAdmissionDetailDocument.class));
			}else {
				preview.put("admissionDetailDocument", null);
			}

			invlst = investigationDetails.get(txnid);
			if(invlst!=null && invlst.size()>0) {
				preview.put("investigationDetails", ObjectMapperUtils.mapAll(invlst, TempInvestigationDetails.class));
			}else {
				preview.put("investigationDetails", null);
			}

			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_SUCCESS, MessageConstant.TRUE, preview);
		} catch (Exception e) {
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_FAILED, MessageConstant.FALSE, null);
		}finally {
			invlst=null;sdlst=null;
		}
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value="/finalSubmitPreAuth")
	public @ResponseBody String getRegisteredPatient(Model model, @RequestParam String txnid) {
		SavePreauthorizationMasterRequest savePreauthorizationMasterRequest = new SavePreauthorizationMasterRequest();
		String response= null;
		ArrayList <PackageDetails> packageDetailsArray = new ArrayList <PackageDetails>();
		try {
			savePreauthorizationMasterRequest = savePreauthorizationMasterRequestMap.get(txnid);
			savePreauthorizationMasterRequest.setRequestId(txnid);

			savePreauthorizationMasterRequest.setAutoApprovalFlag("N");
			savePreauthorizationMasterRequest.setEnhFlag("N");
			savePreauthorizationMasterRequest.setIsCovidCase("N");
			savePreauthorizationMasterRequest.setCrtUsr(response);
			savePreauthorizationMasterRequest.setHospGrade("I");

			savePreauthorizationMasterRequest.setExaminationFindings(examinationMap.get(txnid));
			savePreauthorizationMasterRequest.setPatientPersonalHistory(patientPersonalHistoryMap.get(txnid));
			PatientHospDiagnosis patientHospDiagnosis  = patientHospDiagnosisMap.get(txnid);

			patientHospDiagnosis.setLegalCaseCheck(Optional.ofNullable(savePreauthorizationMasterRequest.getLegalCaseCheck()).orElse(null));

			savePreauthorizationMasterRequest.setPatientHospDiagnosis(patientHospDiagnosisMap.get(txnid));
			savePreauthorizationMasterRequest.setPrimaryDiagnosis((ArrayList<PrimaryDiagnosis>) primaryDiagnosisMap.get(txnid));
			savePreauthorizationMasterRequest.setSecondaryDiagnosis((ArrayList<SecondaryDiagnosis>) secondaryDiagnosisMap.get(txnid));


			for (TreatmentProtocol treatmentProtocol : treatmentProtocolMap.get(txnid)) {
				PackageDetails packageDteail = new PackageDetails();

				packageDteail.setAmount(treatmentProtocol.getPrice()); 
				packageDteail.setCategoryDispCode("SB");
				packageDteail.setCategoryName("Orthopaedics");
				packageDteail.setProcApprvAmt("0");
				packageDteail.setSecorter("S");
				packageDteail.setCyclicFlag("N");
				packageDteail.setEnhFlag("N");
				packageDteail.setIchiCode(treatmentProtocol.getIchiCode());
				packageDteail.setPercentage("100");
				packageDteail.setProcApprvAmt("");

				packageDteail.setProcedureDispCode(treatmentProtocol.getProcedureCode());
				packageDteail.setProcLabel(treatmentProtocol.getProcedurelabel());
				packageDteail.setProcName(treatmentProtocol.getProcedureName());
				packageDteail.setProcType(treatmentProtocol.getProceduretype());


				List<InvestigationDetails>  investigationLst = investigationDetails.get(txnid);
				List<InvestigationDetails>  investigationreqLst = investigationDetails.get(txnid);

				if(investigationLst!=null && investigationLst.size()>0) {
					for (InvestigationDetails investigation : investigationLst) {
						if(investigation.getProcedureCode() == treatmentProtocol.getProcedureCode()) {
							investigationreqLst.add(investigation);
						}	
					}
					packageDteail.setInvestigationDetails((ArrayList)investigationreqLst);
					packageDteail.setInvestigationActive("Y");	
				}else {
					packageDteail.setInvestigationDetails(new ArrayList<>());
					packageDteail.setInvestigationActive("N");
				}

				packageDteail.setErupiActive(treatmentProtocol.getErupistatus());
				packageDteail.setProcWiseAmount(treatmentProtocol.getPrice());
				packageDteail.setProcwiseImplantCost(treatmentProtocol.getInclusiveImplantCost());
				packageDteail.setProcwiseStratCost(treatmentProtocol.getInclusiveStractsCost());
				packageDteail.setProcApprvAmt("0");

				packageDteail.setImplantActive(treatmentProtocol.getImplantstatus());
				packageDteail.setStratActive(treatmentProtocol.getStratificationstatus());

				//packageDteail.setStratDetails(stratDetail);
				//packageDteail.setImplantDetails(implantDetails);
				//packageDteail.setCaseAttachDetails(caseAttachDetails);

				packageDetailsArray.add(packageDteail);				
			}
			savePreauthorizationMasterRequest.setPackageDetails(packageDetailsArray);
			response= preAuthDataService.savePreAuth(savePreauthorizationMasterRequest);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			packageDetailsArray=null;savePreauthorizationMasterRequest=null;
		}
	}	

	@PostMapping(value="/admission_upload_and_process")
	public @ResponseBody JSONResponse admission_upload_and_process(AdmissionDetailDocument req, HttpServletRequest request,
			ModelMap model,Locale locale,HttpSession session) {
		List<AdmissionDetailDocument> sdlst = new ArrayList<AdmissionDetailDocument>();
		List<TempAdmissionDetailDocument> resp = new ArrayList<TempAdmissionDetailDocument>();
		try {
			req.setTempId(String.valueOf(Math.random()));
			req.setDocumentname(req.getAdddocFile().getOriginalFilename());
			if(admissionDetailDocument.get(req.getTxnId())==null) {
				sdlst.add(req);
				admissionDetailDocument.put(req.getTxnId(), sdlst);
			}else {
				sdlst = admissionDetailDocument.get(req.getTxnId());
				sdlst.add(req);
				admissionDetailDocument.put(req.getTxnId(), sdlst);
			}

			sdlst = admissionDetailDocument.get(req.getTxnId());
			resp = ObjectMapperUtils.mapAll(sdlst, TempAdmissionDetailDocument.class);
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_SUCCESS, MessageConstant.TRUE, resp);
		} catch (Exception e) {
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_FAILED, MessageConstant.FALSE, null);
		}finally {
			req=null;sdlst=null;
		}
	}

	@PostMapping(value="/getAdmissionFileData")
	public @ResponseBody JSONResponse getAdmissionFileData(Model model, @RequestParam String txnid) {
		List<AdmissionDetailDocument> sdlst = new ArrayList<AdmissionDetailDocument>();
		List<TempAdmissionDetailDocument> resp = new ArrayList<TempAdmissionDetailDocument>();
		try {
			sdlst = admissionDetailDocument.get(txnid);
			resp = ObjectMapperUtils.mapAll(sdlst, TempAdmissionDetailDocument.class);
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_SUCCESS, MessageConstant.TRUE, resp);
		} catch (Exception e) {
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_FAILED, MessageConstant.FALSE, null);
		}finally {
			sdlst = null;
		}
	}

	@PostMapping(value="/deleteAdmissionFileData")
	public @ResponseBody String deleteAdmissionFileData(Model model, @RequestParam String tempId, @RequestParam String txnid) {
		List<AdmissionDetailDocument> lstdaig = new ArrayList<AdmissionDetailDocument>();
		List<AdmissionDetailDocument> newlstdaig = new ArrayList<AdmissionDetailDocument>();
		try {
			lstdaig = admissionDetailDocument.get(txnid);
			for (AdmissionDetailDocument diagnosis : lstdaig) {
				if(!diagnosis.getTempId().equalsIgnoreCase(tempId)) {
					newlstdaig.add(diagnosis);
				}
			}
			admissionDetailDocument.put(txnid, newlstdaig);
			return MessageConstant.RESPONSE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return MessageConstant.RESPONSE_FAILED;
		}finally {
			lstdaig=null;
		}
	}

	@PostMapping(value="/getPreAuthDocumentMasterData")
	public @ResponseBody JSONResponse getInvestigationMasterBydPackageAndProcedureCode(HttpSession session,@RequestParam String txnid) {
		List<TreatmentProtocol> lstdaig = new ArrayList<TreatmentProtocol>();
		List<AdmissionDetailDocumentDropdownObject> resp = new ArrayList<AdmissionDetailDocumentDropdownObject>();
		try {
			lstdaig = treatmentProtocolMap.get(txnid);
			for (TreatmentProtocol treatmentProtocol : lstdaig) {
				String response  =tmsMasterService.getDocumentPreAuthBySpecPackProcState(treatmentProtocol.getSpeciality(),treatmentProtocol.getPackageid(),treatmentProtocol.getProcedureCode(),(String )session.getAttribute("stateCode"),(String) session.getAttribute("loginToken")); 
				logger.info("getInvestigationMasterBydPackageAndProcedureCode"+response);
				if(!ObjectUtils.isEmpty(response)) {		
					JSONObject userJson= new JSONObject(response);
					if(userJson.getString("status")!=null 
							&& userJson.getString("status").equalsIgnoreCase("SUCCESS")
							&&  userJson.getJSONArray("data")!=null) {
						JSONArray jsonArray = userJson.getJSONArray("data");  
						// Iterate jsonArray using for loop   
						for (int i = 0; i < jsonArray.length(); i++) {  
							// store each object in JSONObject  
							JSONObject explrObject = jsonArray.getJSONObject(i);
							AdmissionDetailDocumentDropdownObject invest = new AdmissionDetailDocumentDropdownObject();
							invest.setDocid(String.valueOf(explrObject.getInt("docid")));
							invest.setPreauthdoc(explrObject.getString("preauthdoc"));    
							resp.add(invest);
						}     
					}
				}
			}
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_SUCCESS, MessageConstant.TRUE, resp);
		} catch (Exception e) {
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_FAILED, MessageConstant.FALSE, null);
		}finally {
			lstdaig=null;resp=null;
		}			
	}


	@PostMapping(value="/getInvestigationDocumentForProcedures")
	public @ResponseBody JSONResponse getInvestigationDocumentForProcedures(HttpSession session,@RequestParam String txnid) {
		List<TreatmentProtocol> lstdaig = new ArrayList<TreatmentProtocol>();
		List<AdmissionDetailDocumentDropdownObject> resp = new ArrayList<AdmissionDetailDocumentDropdownObject>();
		try {
			lstdaig = treatmentProtocolMap.get(txnid);
			for (TreatmentProtocol treatmentProtocol : lstdaig) {
				String investCode[] = treatmentProtocol.getInvestigationActive().split("\\,");
				for (int j = 0; j < investCode.length; j++) {
					String response  =tmsMasterService.getInvestigationByInvestigationId(investCode[j],(String) session.getAttribute("loginToken")); 
					logger.info("getInvestigationDocumentForProcedures"+response);
					if(!ObjectUtils.isEmpty(response)) {		
						JSONObject userJson= new JSONObject(response);
						if(userJson.getString("status")!=null 
								&& userJson.getString("status").equalsIgnoreCase("SUCCESS")
								&&  userJson.getJSONArray("data")!=null) {
							JSONArray jsonArray = userJson.getJSONArray("data");  
							// Iterate jsonArray using for loop   
							for (int i = 0; i < jsonArray.length(); i++) {  
								// store each object in JSONObject  
								JSONObject explrObject = jsonArray.getJSONObject(i);
								AdmissionDetailDocumentDropdownObject invest = new AdmissionDetailDocumentDropdownObject();
								invest.setDocid(String.valueOf(explrObject.getInt("investigationid")));
								invest.setPreauthdoc(explrObject.getString("investigationname"));    
								resp.add(invest);
							}     
						}
					}
				}	
			}
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_SUCCESS, MessageConstant.TRUE, resp);
		} catch (Exception e) {
			return JSONUtil.setJSONResonse(MessageConstant.RESPONSE_FAILED, MessageConstant.FALSE, null);
		}finally {
			lstdaig = null;resp=null;
		}			
	}
}