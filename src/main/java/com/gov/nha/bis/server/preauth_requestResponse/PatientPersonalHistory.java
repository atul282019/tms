package com.gov.nha.bis.server.preauth_requestResponse;

public class PatientPersonalHistory {
	 private String txnid;
	 private String appetite;
	 private String diet;
	 private String bowels;
	 private String nutrition;
	 private String knownAllergies;
	 private String addictions;
	 private String alergictomed;
	 private String alergictomeddesc;
	 private String alertosub;
	 private String alerttosubdesc;
	 private String alcohol;
	 private String druguse;
	 private String beetelnut;
	 private String betelleaf;
	 private String pack;
	 private String years;
	 private String tobacco;
	 
	public String getAppetite() {
		return appetite;
	}
	public void setAppetite(String appetite) {
		this.appetite = appetite;
	}
	public String getDiet() {
		return diet;
	}
	public void setDiet(String diet) {
		this.diet = diet;
	}
	public String getBowels() {
		return bowels;
	}
	public void setBowels(String bowels) {
		this.bowels = bowels;
	}
	public String getNutrition() {
		return nutrition;
	}
	public void setNutrition(String nutrition) {
		this.nutrition = nutrition;
	}
	public String getKnownAllergies() {
		return knownAllergies;
	}
	public void setKnownAllergies(String knownAllergies) {
		this.knownAllergies = knownAllergies;
	}
	public String getAddictions() {
		return addictions;
	}
	public void setAddictions(String addictions) {
		this.addictions = addictions;
	}
	public String getAlergictomed() {
		return alergictomed;
	}
	public void setAlergictomed(String alergictomed) {
		this.alergictomed = alergictomed;
	}
	public String getAlergictomeddesc() {
		return alergictomeddesc;
	}
	public void setAlergictomeddesc(String alergictomeddesc) {
		this.alergictomeddesc = alergictomeddesc;
	}
	public String getAlertosub() {
		return alertosub;
	}
	public void setAlertosub(String alertosub) {
		this.alertosub = alertosub;
	}
	public String getAlerttosubdesc() {
		return alerttosubdesc;
	}
	public void setAlerttosubdesc(String alerttosubdesc) {
		this.alerttosubdesc = alerttosubdesc;
	}
	public String getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}
	public String getDruguse() {
		return druguse;
	}
	public void setDruguse(String druguse) {
		this.druguse = druguse;
	}
	public String getBeetelnut() {
		return beetelnut;
	}
	public void setBeetelnut(String beetelnut) {
		this.beetelnut = beetelnut;
	}
	public String getBetelleaf() {
		return betelleaf;
	}
	public void setBetelleaf(String betelleaf) {
		this.betelleaf = betelleaf;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public String getTobacco() {
		return tobacco;
	}
	public void setTobacco(String tobacco) {
		this.tobacco = tobacco;
	}
	@Override
	public String toString() {
		return "PatientPersonalHistory [appetite=" + appetite + ", diet=" + diet + ", bowels=" + bowels + ", nutrition="
				+ nutrition + ", knownAllergies=" + knownAllergies + ", addictions=" + addictions + ", alergictomed="
				+ alergictomed + ", alergictomeddesc=" + alergictomeddesc + ", alertosub=" + alertosub
				+ ", alerttosubdesc=" + alerttosubdesc + ", alcohol=" + alcohol + ", druguse=" + druguse
				+ ", beetelnut=" + beetelnut + ", betelleaf=" + betelleaf + ", pack=" + pack + ", years=" + years
				+ ", tobacco=" + tobacco + "]";
	}
	public String getTxnid() {
		return txnid;
	}
	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}


	
	}