package com.gov.nha.bis.server.requestResponse;

import java.io.Serializable;

public class ResponseGoldenAPI implements Serializable{
	private static final long serialVersionUID = -6047086312809415818L;
	private Boolean status;
	private String  operation;

	private String  ahlTinId;
	private String  uuid;
	private String  hhId;
	private String aadharToken;
	private String rationCard;
	private int stateCode;
	
	private String familyType;
	private String hhid;
	private String scode;
	private String bentype;
	private String hhdtype;
	private String stateName;
	     
	private String careOfTypeDec;
	private String careOfDec;
	private String memberName;
	private String fatherName;
	private String gender;
	private String yearOfBirth;
	private String photo;
	private String mobileNumber;
	          
	private String statelgdCode;
	
	private String benstatelgdCode;
	private String districtlgdCode;
	private String subdistrictlgdCode;
	private String bendistrictlgdCode;
	private String address;
	private String village_townlgdCode;
	private String ruralUrban;
	private String pinCode;
	         
	private String venderToken;
	private String tempId;
	private String dependent_flag;
	private String member_id;
	private String dateofbirth;
	private String agegroup;
	private String card_delivery_status;
	private String card_delivery_date;
	private String health_id;
	private String nhaid;
	private String familyDocTyp;
	private String familyDocId;
	private String aaa_URN;
	private String aaa_enrollment_date;
	private String aaa_expiry_date;
	private String aaa_flag;
	private String s_flag;
	
	
	private String id_name;
	private String id_number;
	private String schemename;
	private String authmode;
	private String patientid;

	private String hospitalid;
	private String loginuserid;
	
	public String getHospitalid() {
		return hospitalid;
	}
	public void setHospitalid(String hospitalid) {
		this.hospitalid = hospitalid;
	}
	public String getLoginuserid() {
		return loginuserid;
	}
	public void setLoginuserid(String loginuserid) {
		this.loginuserid = loginuserid;
	}
	
	
	public String getId_name() {
		return id_name;
	}
	public void setId_name(String id_name) {
		this.id_name = id_name;
	}
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}
	public String getSchemename() {
		return schemename;
	}
	public void setSchemename(String schemename) {
		this.schemename = schemename;
	}
	public String getAuthmode() {
		return authmode;
	}
	public void setAuthmode(String authmode) {
		this.authmode = authmode;
	}
	
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getAhlTinId() {
		return ahlTinId;
	}
	public void setAhlTinId(String ahlTinId) {
		this.ahlTinId = ahlTinId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getHhId() {
		return hhId;
	}
	public void setHhId(String hhId) {
		this.hhId = hhId;
	}
	public String getAadharToken() {
		return aadharToken;
	}
	public void setAadharToken(String aadharToken) {
		this.aadharToken = aadharToken;
	}
	public String getRationCard() {
		return rationCard;
	}
	public void setRationCard(String rationCard) {
		this.rationCard = rationCard;
	}
	public int getStateCode() {
		return stateCode;
	}
	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}
	public String getFamilyType() {
		return familyType;
	}
	public void setFamilyType(String familyType) {
		this.familyType = familyType;
	}
	public String getHhid() {
		return hhid;
	}
	public void setHhid(String hhid) {
		this.hhid = hhid;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public String getBentype() {
		return bentype;
	}
	public void setBentype(String bentype) {
		this.bentype = bentype;
	}
	public String getHhdtype() {
		return hhdtype;
	}
	public void setHhdtype(String hhdtype) {
		this.hhdtype = hhdtype;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getCareOfTypeDec() {
		return careOfTypeDec;
	}
	public void setCareOfTypeDec(String careOfTypeDec) {
		this.careOfTypeDec = careOfTypeDec;
	}
	public String getCareOfDec() {
		return careOfDec;
	}
	public void setCareOfDec(String careOfDec) {
		this.careOfDec = careOfDec;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getStatelgdCode() {
		return statelgdCode;
	}
	public void setStatelgdCode(String statelgdCode) {
		this.statelgdCode = statelgdCode;
	}
	public String getBenstatelgdCode() {
		return benstatelgdCode;
	}
	public void setBenstatelgdCode(String benstatelgdCode) {
		this.benstatelgdCode = benstatelgdCode;
	}
	public String getDistrictlgdCode() {
		return districtlgdCode;
	}
	public void setDistrictlgdCode(String districtlgdCode) {
		this.districtlgdCode = districtlgdCode;
	}
	public String getSubdistrictlgdCode() {
		return subdistrictlgdCode;
	}
	public void setSubdistrictlgdCode(String subdistrictlgdCode) {
		this.subdistrictlgdCode = subdistrictlgdCode;
	}
	public String getBendistrictlgdCode() {
		return bendistrictlgdCode;
	}
	public void setBendistrictlgdCode(String bendistrictlgdCode) {
		this.bendistrictlgdCode = bendistrictlgdCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVillage_townlgdCode() {
		return village_townlgdCode;
	}
	public void setVillage_townlgdCode(String village_townlgdCode) {
		this.village_townlgdCode = village_townlgdCode;
	}
	public String getRuralUrban() {
		return ruralUrban;
	}
	public void setRuralUrban(String ruralUrban) {
		this.ruralUrban = ruralUrban;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getVenderToken() {
		return venderToken;
	}
	public void setVenderToken(String venderToken) {
		this.venderToken = venderToken;
	}
	public String getTempId() {
		return tempId;
	}
	public void setTempId(String tempId) {
		this.tempId = tempId;
	}
	public String getDependent_flag() {
		return dependent_flag;
	}
	public void setDependent_flag(String dependent_flag) {
		this.dependent_flag = dependent_flag;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getAgegroup() {
		return agegroup;
	}
	public void setAgegroup(String agegroup) {
		this.agegroup = agegroup;
	}
	public String getCard_delivery_status() {
		return card_delivery_status;
	}
	public void setCard_delivery_status(String card_delivery_status) {
		this.card_delivery_status = card_delivery_status;
	}
	public String getCard_delivery_date() {
		return card_delivery_date;
	}
	public void setCard_delivery_date(String card_delivery_date) {
		this.card_delivery_date = card_delivery_date;
	}
	public String getHealth_id() {
		return health_id;
	}
	public void setHealth_id(String health_id) {
		this.health_id = health_id;
	}
	public String getNhaid() {
		return nhaid;
	}
	public void setNhaid(String nhaid) {
		this.nhaid = nhaid;
	}
	public String getFamilyDocTyp() {
		return familyDocTyp;
	}
	public void setFamilyDocTyp(String familyDocTyp) {
		this.familyDocTyp = familyDocTyp;
	}
	public String getFamilyDocId() {
		return familyDocId;
	}
	public void setFamilyDocId(String familyDocId) {
		this.familyDocId = familyDocId;
	}
	public String getAaa_URN() {
		return aaa_URN;
	}
	public void setAaa_URN(String aaa_URN) {
		this.aaa_URN = aaa_URN;
	}
	public String getAaa_enrollment_date() {
		return aaa_enrollment_date;
	}
	public void setAaa_enrollment_date(String aaa_enrollment_date) {
		this.aaa_enrollment_date = aaa_enrollment_date;
	}
	public String getAaa_expiry_date() {
		return aaa_expiry_date;
	}
	public void setAaa_expiry_date(String aaa_expiry_date) {
		this.aaa_expiry_date = aaa_expiry_date;
	}
	public String getAaa_flag() {
		return aaa_flag;
	}
	public void setAaa_flag(String aaa_flag) {
		this.aaa_flag = aaa_flag;
	}
	public String getS_flag() {
		return s_flag;
	}
	public void setS_flag(String s_flag) {
		this.s_flag = s_flag;
	}
	@Override
	public String toString() {
		return "GoldenApiResponse [status=" + status + ", operation=" + operation + ", ahlTinId=" + ahlTinId + ", uuid="
				+ uuid + ", hhId=" + hhId + ", aadharToken=" + aadharToken + ", rationCard=" + rationCard
				+ ", stateCode=" + stateCode + ", familyType=" + familyType + ", hhid=" + hhid + ", scode=" + scode
				+ ", bentype=" + bentype + ", hhdtype=" + hhdtype + ", stateName=" + stateName + ", careOfTypeDec="
				+ careOfTypeDec + ", careOfDec=" + careOfDec + ", memberName=" + memberName + ", fatherName="
				+ fatherName + ", gender=" + gender + ", yearOfBirth=" + yearOfBirth + ", photo=" + photo
				+ ", mobileNumber=" + mobileNumber + ", statelgdCode=" + statelgdCode + ", benstatelgdCode="
				+ benstatelgdCode + ", districtlgdCode=" + districtlgdCode + ", subdistrictlgdCode="
				+ subdistrictlgdCode + ", bendistrictlgdCode=" + bendistrictlgdCode + ", address=" + address
				+ ", village_townlgdCode=" + village_townlgdCode + ", ruralUrban=" + ruralUrban + ", pinCode=" + pinCode
				+ ", venderToken=" + venderToken + ", tempId=" + tempId + ", dependent_flag=" + dependent_flag
				+ ", member_id=" + member_id + ", dateofbirth=" + dateofbirth + ", agegroup=" + agegroup
				+ ", card_delivery_status=" + card_delivery_status + ", card_delivery_date=" + card_delivery_date
				+ ", health_id=" + health_id + ", nhaid=" + nhaid + ", familyDocTyp=" + familyDocTyp + ", familyDocId="
				+ familyDocId + ", aaa_URN=" + aaa_URN + ", aaa_enrollment_date=" + aaa_enrollment_date
				+ ", aaa_expiry_date=" + aaa_expiry_date + ", aaa_flag=" + aaa_flag + ", s_flag=" + s_flag + "]";
	}
	public String getPatientid() {
		return patientid;
	}
	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}

}