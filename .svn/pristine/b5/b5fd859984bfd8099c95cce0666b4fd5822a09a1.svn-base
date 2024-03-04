package com.gov.nha.bis.server.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gov.nha.bis.server.properties.ApplicationConstantConfig;
import com.gov.nha.bis.server.requestResponse.PatientRegisterRequest;
import com.gov.nha.bis.server.requestResponse.ResponseGoldenAPI;
import com.gov.nha.bis.server.rest.service.PatientRegistrationService;
import com.gov.nha.bis.server.rest.service.UserAuthenticationService;
import com.gov.nha.bis.server.rest.service.WalletDataService;
import com.gov.nha.bis.server.rest.service.Impl.PatientRegistrationServiceImpl;
import com.gov.nha.bis.server.util.MessageConstant;

@Controller
@CrossOrigin
public class PatientRegistrationController extends NhaBisBaseController{

	private static final Logger logger = LoggerFactory.getLogger(PatientRegistrationController.class);

	@Autowired
	public ApplicationConstantConfig applicationConstantConfig;

	@Autowired
	UserAuthenticationService userAuthenticationService;

	@Autowired
	public PatientRegistrationService patientRegistrationService ;
	
	@Autowired
	public WalletDataService walletDataService;
	
	@Autowired
	public PatientRegistrationServiceImpl patientRegistrationServiceImpl;
	
	
	@PostMapping(value="/registerUser")
	public @ResponseBody String registerUser(HttpSession session,HttpServletRequest request,@ModelAttribute("userForm") PatientRegisterRequest userForm) {
		logger.info("registerUser");
		String	 response= null; String goldenresponse= null;	ResponseGoldenAPI goldenapiresponse  = new ResponseGoldenAPI();
		String	 dbresponse= null; 
		try {
			
			goldenresponse= userAuthenticationService.getGoldenAPI("716558b4-fdba-4701-b06a-d211f4b60d7b","atul","9205431193",
			"6", applicationConstantConfig.USER_LOGIN_GOLDEN_API_URL);
			logger.info("golden API Response"+goldenresponse);
		
			if(!ObjectUtils.isEmpty(goldenresponse)) {
				JSONObject goldenJson= new JSONObject(goldenresponse);
				JSONObject goldenJson2= goldenJson.getJSONObject("header");
				JSONObject goldenJson3= goldenJson2.getJSONObject("beneficiaryDetails");
				JSONObject goldenJson4= goldenJson3.getJSONObject("rationCardDetails");
				JSONObject goldenJson5= goldenJson.getJSONObject("familySearchDetails");
				
				JSONArray goldenJson6= goldenJson5.getJSONArray("family");
				JSONObject goldenJson7= (JSONObject) goldenJson6.get(0);

				JSONArray goldenJson8=  goldenJson7.getJSONArray("familyMember");
				JSONObject goldenJson9= (JSONObject) goldenJson8.get(0);
				JSONObject goldenJson10= goldenJson9.getJSONObject("address");
				
				//ObjectMapper objMapper = new ObjectMapper();
				//ResponseGoldenAPI goldenapiresponse = objMapper.readValue(goldenJson4.toString(), ResponseGoldenAPI.class);
			
				if(goldenJson.getBoolean("status") ==true) {
					goldenapiresponse.setCareOfTypeDec(goldenJson9.getString("careOfTypeDec"));
					goldenapiresponse.setCareOfDec(goldenJson9.getString("careOfDec"));
					//goldenapiresponse.setMemberName(goldenJson9.getString("memberName"));
					goldenapiresponse.setMemberName(userForm.getMemberName());
					//goldenapiresponse.setFatherName(goldenJson9.getString("fatherName"));
					goldenapiresponse.setFatherName(userForm.getFathename());
					//goldenapiresponse.setGender(goldenJson9.getString("gender"));
					goldenapiresponse.setGender(userForm.getGender());
					goldenapiresponse.setYearOfBirth(goldenJson9.getString("yearOfBirth"));
					goldenapiresponse.setMobileNumber(goldenJson9.getString("mobileNumber"));
					goldenapiresponse.setVenderToken(goldenJson9.getString("venderToken"));
					goldenapiresponse.setTempId(goldenJson9.getString("tempId"));
					goldenapiresponse.setDependent_flag(goldenJson9.getString("dependent_flag"));
					//goldenapiresponse.setMember_id(goldenJson9.getString("member_id"));
					goldenapiresponse.setMember_id(userForm.getMemberId());
					//goldenapiresponse.setDateofbirth(goldenJson9.getString("dateofbirth"));
					goldenapiresponse.setDateofbirth(userForm.getDateofbirth());
					
					goldenapiresponse.setAgegroup(goldenJson9.getString("agegroup"));
					goldenapiresponse.setCard_delivery_status(goldenJson9.getString("card_delivery_status"));
					goldenapiresponse.setCard_delivery_date(goldenJson9.getString("card_delivery_date"));
					goldenapiresponse.setHealth_id(goldenJson9.getString("health_id"));
					goldenapiresponse.setNhaid(goldenJson9.getString("nhaid"));
					goldenapiresponse.setFamilyDocTyp(goldenJson9.getString("familyDocTyp"));
					goldenapiresponse.setFamilyDocId(goldenJson9.getString("familyDocId"));
					goldenapiresponse.setAaa_enrollment_date(goldenJson9.getString("aaa_enrollment_date"));
					goldenapiresponse.setAaa_expiry_date(goldenJson9.getString("aaa_expiry_date"));
					goldenapiresponse.setAaa_flag(goldenJson9.getString("aaa_flag"));
					goldenapiresponse.setStatelgdCode(goldenJson10.getString("statelgdCode"));
					goldenapiresponse.setBendistrictlgdCode(goldenJson10.getString("benstatelgdCode"));
					goldenapiresponse.setDistrictlgdCode(goldenJson10.getString("districtlgdCode"));
					goldenapiresponse.setSubdistrictlgdCode(goldenJson10.getString("subdistrictlgdCode"));
					goldenapiresponse.setBendistrictlgdCode(goldenJson10.getString("bendistrictlgdCode"));
					//goldenapiresponse.setAddress(goldenJson10.getString("address"));
					
					goldenapiresponse.setAddress(userForm.getAddress());
					
					goldenapiresponse.setVillage_townlgdCode(goldenJson10.getString("village_townlgdCode"));
					//goldenapiresponse.setPinCode(goldenJson10.getString("pinCode"));
					goldenapiresponse.setPinCode(userForm.getPinCode());
					goldenapiresponse.setId_name(userForm.getId_name());
					goldenapiresponse.setId_number(userForm.getId_number());
					goldenapiresponse.setSchemename(userForm.getSchemename());
					goldenapiresponse.setAuthmode(userForm.getAuthmode());
					goldenapiresponse.setPhoto(userForm.getPhoto());
					
					goldenapiresponse.setHospitalid((String)session.getAttribute("hid"));
					goldenapiresponse.setLoginuserid((String)session.getAttribute("loginId"));
					System.out.println((String)session.getAttribute("hospitalId"));
					
				}
			}
			
			response= patientRegistrationServiceImpl.registerUser(userForm,goldenapiresponse, applicationConstantConfig.USER_REGISTER_AUTHENTICATION_URL);
			
			if(!ObjectUtils.isEmpty(response)) {	
				JSONObject userJson= new JSONObject(response);
				
				goldenapiresponse.setPatientid(userJson.getString("patientId"));
				dbresponse = patientRegistrationService.saveRegisterPatientData(goldenapiresponse);
				
				if(!ObjectUtils.isEmpty(dbresponse)) {
					System.out.println(response);
				}
				else {
					return MessageConstant.RESPONSE_FAILED;
				}
			}
			else {
				return MessageConstant.RESPONSE_FAILED;
			}
				return MessageConstant.RESPONSE_SUCCESS;
			} 
		catch (Exception e) {
			e.printStackTrace();
			return "API GAteway not responding";
		}finally {
		  response= null;
		}
	}	

	@PostMapping(value="/getRegisteredPatient")
	public @ResponseBody String getRegisteredPatient(Model model) {
		String token = (String) session.getAttribute("loginToken");
		return patientRegistrationService.getRegisteredPatientData(token,(String)session.getAttribute("hospitalId"),(String)session.getAttribute("loginId"));
	}	
	
	@PostMapping(value="/getPatientCountTodatAndTotal")
	public @ResponseBody String getTodayAndTotalPatient(Model model) {
		String token = (String) session.getAttribute("loginToken");
		return patientRegistrationService.getTodayAndTotalPatient(token);
	}	
	
}