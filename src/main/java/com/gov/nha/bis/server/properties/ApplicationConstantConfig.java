package com.gov.nha.bis.server.properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@Configuration
@PropertySource({"classpath:application.properties"})
public class ApplicationConstantConfig {


	@Value("${SEARCH_DAIGNOSIS_MASTER_DATA}")
	public String SEARCH_DAIGNOSIS_MASTER_DATA;
	
	@Value("${SAVE_HOSPITAL_SPECIALITY_MAPPING}")
	public String SAVE_HOSPITAL_SPECIALITY_MAPPING;
	
	@Value("${CHANGE_HOSPITAL_SPECILAITY_MAPPING_STATUS}")
	public String CHANGE_HOSPITAL_SPECILAITY_MAPPING_STATUS;
	
	@Value("${GET_SPECIALITY_BY_HOSPITAL_STATE}")
	public String GET_SPECIALITY_BY_HOSPITAL_STATE;
	
	@Value("${GET_HEM_DATA}")
	public String GET_HEM_DATA;

	@Value("${SAVE_TREATMENT_PROTOCOL_REQUEST}")
	public String SAVE_TREATMENT_PROTOCOL_REQUEST;

	@Value("${DELETE_PRIMARY_DAIGNOSIS_STORED_DATA}")
	public String DELETE_PRIMARY_DAIGNOSIS_STORED_DATA;
	
	@Value("${DELETE_SECONDARY_DAIGNOSIS_STORED_DATA}")
	public String DELETE_SECONDARY_DAIGNOSIS_STORED_DATA;
	
	@Value("${GET_PRIMARY_DAIGNOSIS_STORED_DATA}")
	public String GET_PRIMARY_DAIGNOSIS_STORED_DATA;
	
	@Value("${GET_SECONDARY_DAIGNOSIS_STORED_DATA}")
	public String GET_SECONDARY_DAIGNOSIS_STORED_DATA;
	
	@Value("${SAVE_SECONDARY_DAIGNOSIS_REQUEST}")
	public String SAVE_SECONDARY_DAIGNOSIS_REQUEST;

	@Value("${SAVE_PRIMARY_DAIGNOSIS_REQUEST}")
	public String SAVE_PRIMARY_DAIGNOSIS_REQUEST;
	
	@Value("${GET_PROCEDURE_LIST_DISTINCT}")
	public String GET_PROCEDURE_LIST_DISTINCT;
	
	@Value("${GET_CURRENT_USER_HOSPITAL_DATA}")
	public String GET_CURRENT_USER_HOSPITAL_DATA;
	
	@Value("${LOG_FILE_PATH}")
	public String LOG_FILE_PATH;
	
	@Value("${GET_INVESTIGATION_BY_INVESTIGATION_ID}")
	public String GET_INVESTIGATION_BY_INVESTIGATION_ID;

	@Value("${GET_PROCEDURE_BY_PROCEDURE_ID}")
	public String GET_PROCEDURE_BY_PROCEDURE_ID;
	
	@Value("${GET_INVESTIGATION_BY_PROCEDURE_ID}")
	public String GET_INVESTIGATION_BY_PROCEDURE_ID;
	
	@Value("${STATE_MASTER}")
	public String STATE_MASTER;
	
	@Value("${NHA_TMS_WALLET_Token_URL}")
	public String NHA_TMS_WALLET_Token_URL;
	
	@Value("${NHA_TMS_WALLET_Client_ID}")
	public String NHA_TMS_WALLET_Client_ID;
	
	@Value("${NHA_TMS_WALLET_Secret_ID}")
	public String NHA_TMS_WALLET_Secret_ID;
	
	@Value("${NHA_TMS_WALLET_URL}")
	public String NHA_TMS_WALLET_URL;
	
	@Value("${APP_AADHAAR_AUTH_HISTORY_URL}")
	public String APP_AADHAAR_AUTH_HISTORY_URL;
	
	@Value("${RD.PIDOPTIONS.VER}")
	public String RD_PIDOPTIONS_VER;
	
	@Value("${RD.OPTS.PIDVER}")
	public String RD_OPTS_PIDVER;
	
	@Value("${NHA_BIS_FACE_WADH_KEY}")
	public String NHA_BIS_FACE_WADH_KEY;
	
	@Value("${RD.OPTS.ENV}")
	public String RD_OPTS_ENV;
	
	@Value("${FACE_THIRD_PARTY_URL}")
	public String FACE_THIRD_PARTY_URL;
	
	@Value("${FACE_APIKEY}")
	public String FACE_APIKEY;
	
	@Value("${FACE_CURL}")
	public String FACE_CURL;
	
	@Value("${FACE_STIMEOUT}")
	public String FACE_STIMEOUT ;
	
	@Value("${FACE_HOSTID}")
	public String FACE_HOSTID;
	
	@Value("${FACE_PASSCODE}")
	public String FACE_PASSCODE;
	
	@Value("${BIO_KYC_URL}")
	public String BIO_KYC_URL;
	
	@Value("${USER_REGISTER_AUTHENTICATION_URL}")
	public String USER_REGISTER_AUTHENTICATION_URL;
	
	@Value("${USER_REGISTER_AUTHENTICATION_Client_ID}")
	public String USER_REGISTER_AUTHENTICATION_Client_ID;
	
	@Value("${USER_REGISTER_AUTHENTICATION_Client_Secret}")
	public String USER_REGISTER_AUTHENTICATION_Client_Secret;
	
	@Value("${USER_REGISTER_AUTHENTICATION_Token_URL}")
	public String USER_REGISTER_AUTHENTICATION_Token_URL;
	
	@Value("${USER_LOGIN_GOLDEN_API_URL}")
	public String USER_LOGIN_GOLDEN_API_URL;
	
	@Value("${SAVE_REGISTER_PATIENT_SERVICE}")
	public String SAVE_REGISTER_PATIENT_SERVICE;
	
	@Value("${GET_ALL_REGISTERED_PATIENT_DATA}")
	public String GET_ALL_REGISTERED_PATIENT_DATA;
	
	@Value("${GET_PATIENT_DATA_BY_ID}")
	public String GET_PATIENT_DATA_BY_ID;
	
	@Value("${GET_PATIENT_DATA_COUNT_TOTAL_TODAY}")
	public String GET_PATIENT_DATA_COUNT_TOTAL_TODAY;
	
	@Value("${SAVE_PRICE_MASTER_DATA}")
	public String SAVE_PRICE_MASTER_DATA;
	
	@Value("${GET_PRICE_MASTER_DATA}")
	public String GET_PRICE_MASTER_DATA;
	
	@Value("${SAVE_SPACILITY_MASTER_DATA}")
	public String SAVE_SPACILITY_MASTER_DATA;
	
	@Value("${GET_SPACILITY_MASTER_DATA}")
	public String GET_SPACILITY_MASTER_DATA;

	@Value("${SAVE_PACKAGE_MASTER_DATA}")
	public String SAVE_PACKAGE_MASTER_DATA;
	
	@Value("${GET_PACKAGE_MASTER_DATA}")
	public String GET_PACKAGE_MASTER_DATA;
	
	@Value("${SAVE_CATEGORY_MASTER_DATA}")
	public String SAVE_CATEGORY_MASTER_DATA;
		
	@Value("${GET_CATEGORY_MASTER_DATA}")
	public String GET_CATEGORY_MASTER_DATA;
	
	@Value("${SAVE_PROCEDURE_MASTER_DATA}")
	public String SAVE_PROCEDURE_MASTER_DATA;
			
	@Value("${GET_PROCEDURE_MASTER_DATA}")
	public String GET_PROCEDURE_MASTER_DATA;
		
	@Value("${SAVE_LBL_PROCEDURE_MASTER_DATA}")
	public String SAVE_LBL_PROCEDURE_MASTER_DATA;
			
	@Value("${GET_LBL_PROCEDURE_MASTER_DATA}")
	public String GET_LBL_PROCEDURE_MASTER_DATA;
	
	@Value("${SAVE_STRATIFICATION_MASTER_DATA}")
	public String SAVE_STRATIFICATION_MASTER_DATA;
				
	@Value("${GET_STRATIFICATION_MASTER_DATA}")
	public String GET_STRATIFICATION_MASTER_DATA;
	
	@Value("${SAVE_IMPLANT_MASTER_DATA}")
	public String SAVE_IMPLANT_MASTER_DATA;
				
	@Value("${GET_IMPLANT_MASTER_DATA}")
	public String GET_IMPLANT_MASTER_DATA;

	@Value("${SAVE_DUCUMENT_MASTER_DATA}")
	public String SAVE_DUCUMENT_MASTER_DATA;
				
	@Value("${GET_DOCUMENT_MASTER_DATA}")
	public String GET_DOCUMENT_MASTER_DATA;
	

	@Value("${SAVE_TEST_MASTER_DATA}")
	public String SAVE_TEST_MASTER_DATA;
				
	@Value("${GET_TEST_MASTER_DATA}")
	public String GET_TEST_MASTER_DATA;
	
	@Value("${SAVE_PREAUTHORIZATION_REQUEST}")
	public String SAVE_PREAUTHORIZATION_REQUEST;
	
	@Value("${GET_TEST_MASTER_DATA_BY_SPECILITY_ID}")
	public String GET_TEST_MASTER_DATA_BY_SPECILITY_ID;
	
	@Value("${GET_SCHEME_MASTER_DATA}")
	public String GET_SCHEME_MASTER_DATA;
	
	@Value("${GET_ID_MASTER_DATA}")
	public String GET_ID_MASTER_DATA;
	
	@Value("${GET_LOGIN_USER}")
	public String GET_LOGIN_USER;
	
	@Value("${GET_PACKAGE_MASTER_BY_SPECILITY_CODE}")
	public String GET_PACKAGE_MASTER_BY_SPECILITY_CODE;
	
	@Value("${GET_PROCEDURE_MASTER_BY_SPECILITY_CODE_PACKAGE_CODE}")
	public String GET_PROCEDURE_MASTER_BY_SPECILITY_CODE_PACKAGE_CODE;
	
	@Value("${GET_INVESTIGATION_MASTER_BY_PACKAGE_CODE_AND_PROCEDURE_CODE}")
	public String GET_INVESTIGATION_MASTER_BY_PACKAGE_CODE_AND_PROCEDURE_CODE;
	
	@Value("${GET_STRATIFICATION_MASTER_BY_STATE_CODE}")
	public String GET_STRATIFICATION_MASTER_BY_STATE_CODE;
	
	@Value("${GET_IMPLANT_MASTER_BY_STATE_CODE}")
	public String GET_IMPLANT_MASTER_BY_STATE_CODE;
	
	@Value("${GET_DOCUMENT_PRE_AUTH_DATA_BY_SPEC_PACK_PROC_CODE}")
	public String GET_DOCUMENT_PRE_AUTH_DATA_BY_SPEC_PACK_PROC_CODE;
	
	@Value("${GET_PACKAGE_COST}")
	public String GET_PACKAGE_COST;
	
	@Value("${GET_STRATIFICATION_DETAIL_STRATIFICATION_CODE}")
	public String GET_STRATIFICATION_DETAIL_STRATIFICATION_CODE;
	
	@Value("${GET_IMPLANT_DETAIL_BY_ID}")
	public String GET_IMPLANT_DETAIL_BY_ID;
	
	@Value("${SAVE_INVESTIGATION_MASTER_DATA}")
	public String SAVE_INVESTIGATION_MASTER_DATA;
	
	@Value("${GET_INVESTIGATION_MASTER_DATA}")
	public String GET_INVESTIGATION_MASTER_DATA;
	
	@Value("${SAVE_VITAL_TEST_MASTER_DATA}")
	public String SAVE_VITAL_TEST_MASTER_DATA;
	
	@Value("${GET_VITALTEST_MASTER_DATA}")
	public String GET_VITALTEST_MASTER_DATA;
	
	@Value("${SAVE_INVESTIGATION_PROCEDURE_MAPPING_DATA}")
	public String SAVE_INVESTIGATION_PROCEDURE_MAPPING_DATA;
	
	@Value("${GET_INVESTIGATION_PROCEDURE_MAPPING_DATA}")
	public String GET_INVESTIGATION_PROCEDURE_MAPPING_DATA;
	
	@Value("${SAVE_VITALTEST_PROCEDURE_MAPPING_DATA}")
	public String SAVE_VITALTEST_PROCEDURE_MAPPING_DATA;
	
	@Value("${GET_VITALTEST_PROCEDURE_MAPPING_DATA}")
	public String GET_VITALTEST_PROCEDURE_MAPPING_DATA;
	
	@Value("${GET_IMPLANT_FOR_PROCEDURE_MAPP}")
	public String GET_IMPLANT_FOR_PROCEDURE_MAPP;
	
	@Value("${SAVE_IMPLANT_PROC_MAPPING_DATA}")
	public String SAVE_IMPLANT_PROC_MAPPING_DATA;
	
	@Value("${GET_IMPLANT_MAPPING_PROCEDURE_DATA}")
	public String GET_IMPLANT_MAPPING_PROCEDURE_DATA;
	
	
	@Value("${GET_STRATIFICATION_FOR_PROCEDURE_MAPP}")
	public String GET_STRATIFICATION_FOR_PROCEDURE_MAPP;
	
	@Value("${SAVE_STRATIFICATION_PROC_MAPPING_DATA}")
	public String SAVE_STRATIFICATION_PROC_MAPPING_DATA;
	
	@Value("${GET_STRSTIFICATION_MAPPING_PROCEDURE_DATA}")
	public String GET_STRSTIFICATION_MAPPING_PROCEDURE_DATA;
	
	@Value("${GET_INVESTIGATION_BY_SCHEME_STATE_FOR_PROCEDURE_MAPP}")
	public String GET_INVESTIGATION_BY_SCHEME_STATE_FOR_PROCEDURE_MAPP;
	
	@Value("${GET_SPECIALITY_BY_SCHEME_STATE_FOR_PROCEDURE_MAPP}")
	public String GET_SPECIALITY_BY_SCHEME_STATE_FOR_PROCEDURE_MAPP;	
	
	@Value("${GET_SPECIALITY_DETAIL_BY_ID}")
	public String GET_SPECIALITY_DETAIL_BY_ID;

	@Value("${DELETE_SPECIALITY__BY_SPECIALITY_ID}")
	public String DELETE_SPECIALITY__BY_SPECIALITY_ID;
	
	@Value("${GET_PACKAGE_DETAIL_BY_PACKAGE_ID}")
	public String GET_PACKAGE_DETAIL_BY_PACKAGE_ID;	
	
	@Value("${DELETE_PACKAGE__BY_PACKAGE_ID}")
	public String DELETE_PACKAGE__BY_PACKAGE_ID;
	
	@Value("${GET_PACKAGE_CATEGORY_DETAIL_BY_CATEGORY_ID}")
	public String GET_PACKAGE_CATEGORY_DETAIL_BY_CATEGORY_ID;
	
	@Value("${DELETE_PACKAGE_CATEGORY__BY_CATEGORY_ID}")
	public String DELETE_PACKAGE_CATEGORY__BY_CATEGORY_ID;
	
	@Value("${GET_PROCEDURE_LABEL_DETAIL_BY_PROCEDURE_LABEL_ID}")
	public String GET_PROCEDURE_LABEL_DETAIL_BY_PROCEDURE_LABEL_ID;
	
	@Value("${DELETE_PROCEDURE_LABEL_BY_PROCEDURE_LABEL_ID}")
	public String DELETE_PROCEDURE_LABEL_BY_PROCEDURE_LABEL_ID;
	
	@Value("${GET_PROC__DETAIL_FOR_EDIT_BY_PROCEDURE_ID}")
	public String GET_PROC__DETAIL_FOR_EDIT_BY_PROCEDURE_ID;
	
	@Value("${DELETE_PROC_MASTER_FOR_EDIT_BY_PROCEDURE_ID}")
	public String DELETE_PROC_MASTER_FOR_EDIT_BY_PROCEDURE_ID;
	
	@Value("${GET_PRICE__DETAIL_FOR_EDIT_BY_PRICE_ID}")
	public String GET_PRICE__DETAIL_FOR_EDIT_BY_PRICE_ID;
	
	@Value("${DELETE_PRICE_DETAIL_MASTER__BY_PRICE_ID}")
	public String DELETE_PRICE_DETAIL_MASTER__BY_PRICE_ID;
	
	@Value("${GET_DOCUMENT_DETAIL_FOR_EDIT_BY_DOCUMENT_ID}")
	public String GET_DOCUMENT_DETAIL_FOR_EDIT_BY_DOCUMENT_ID;
	
	@Value("${DELETE_DOCUMENT_MASTER_DETAIL_DOCUMENT_ID}")
	public String DELETE_DOCUMENT_MASTER_DETAIL_DOCUMENT_ID;
	
	@Value("${GET_IIMPLANT_DETAIL_FOR_EDIT_BY_IMPLANT_ID}")
	public String GET_IIMPLANT_DETAIL_FOR_EDIT_BY_IMPLANT_ID;
	
	@Value("${DELETE_IMPLANT_MASTER_DETAIL_IMPLANT_ID}")
	public String DELETE_IMPLANT_MASTER_DETAIL_IMPLANT_ID;
	
	@Value("${GET_STRATIFICATION_MASTER_DETAIL_BY_STRATIFICATION_ID}")
	public String GET_STRATIFICATION_MASTER_DETAIL_BY_STRATIFICATION_ID;
	
	@Value("${DELETE_STRATIFICATION_MASTER_DETAIL_STRATIFICATION_ID}")
	public String DELETE_STRATIFICATION_MASTER_DETAIL_STRATIFICATION_ID;
	
	@Value("${GET_INVESTIGATION_MASTER_DETAIL_BY_INVESTIGATION_ID}")
	public String GET_INVESTIGATION_MASTER_DETAIL_BY_INVESTIGATION_ID;
	
	@Value("${DELETE_INVESTIGATION_MASTER_DETAIL_INVESTIGATION_ID}")
	public String DELETE_INVESTIGATION_MASTER_DETAIL_INVESTIGATION_ID;
	
	@Value("${GET_SPECIALITY_MASTER_APPROVAL}")
	public String GET_SPECIALITY_MASTER_APPROVAL;
	
	@Value("${APPROVE_SPECIALITY_MASTER}")
	public String APPROVE_SPECIALITY_MASTER;
	
	@Value("${GET_PACKAGE_MASTER_APPROVAL}")
	public String GET_PACKAGE_MASTER_APPROVAL;
	
	@Value("${APPROVE_PACKAGE_MASTER}")
	public String APPROVE_PACKAGE_MASTER;
	
	@Value("${GET_PROCEDURE_MASTER_APPROVAL}")
	public String GET_PROCEDURE_MASTER_APPROVAL;
	
	@Value("${APPROVE_PROCEDURE_MASTER}")
	public String APPROVE_PROCEDURE_MASTER;
	
	@Value("${GET_PRICE_MASTER_APPROVAL}")
	public String GET_PRICE_MASTER_APPROVAL;
	
	@Value("${APPROVE_RICE_MASTER}")
	public String APPROVE_RICE_MASTER;
	
	@Value("${GET_DOCUMENT_MASTER_APPROVAL}")
	public String GET_DOCUMENT_MASTER_APPROVAL;
	
	@Value("${APPROVE_DOCUMENT_MASTER}")
	public String APPROVE_DOCUMENT_MASTER;
	
	@Value("${GET_IMPLANT_MASTER_APPROVAL}")
	public String GET_IMPLANT_MASTER_APPROVAL;
	
	@Value("${APPROVE_IMPLANT_MASTER}")
	public String APPROVE_IMPLANT_MASTER;
	
	@Value("${GET_STRATIFICATION_MASTER_APPROVAL}")
	public String GET_STRATIFICATION_MASTER_APPROVAL;
	
	@Value("${APPROVE_STRATIFICATION_MASTER}")
	public String APPROVE_STRATIFICATION_MASTER;
	
	@Value("${GET_INVESTIGATION_MASTER_APPROVAL}")
	public String GET_INVESTIGATION_MASTER_APPROVAL;
	
	@Value("${APPROVE_INVESTIGATION_MASTER}")
	public String APPROVE_INVESTIGATION_MASTER;
	
	@Value("${IMAGE_CONTENT_READ_API}")
	public String IMAGE_CONTENT_READ_API;
	
	
	
}