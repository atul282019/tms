package com.gov.nha.bis.server.requestResponse;

public class StratificationMasterRequest {
	
	   private Long stratificationid;
	   
	   private String stratificationcode;

		private String rule;
		
	    private String stratificationcodecriteria;
		
		private String stratificationdetails;
		
	    private String stratificationdescription;
		
		private String price;

	    private Integer schemeid;
		
	    private Integer status;
		
	    private String statecode;

		public Long getStratificationid() {
			return stratificationid;
		}

		public void setStratificationid(Long stratificationid) {
			this.stratificationid = stratificationid;
		}

		public String getStratificationcode() {
			return stratificationcode;
		}

		public void setStratificationcode(String stratificationcode) {
			this.stratificationcode = stratificationcode;
		}

		public String getRule() {
			return rule;
		}

		public void setRule(String rule) {
			this.rule = rule;
		}

		public String getStratificationcodecriteria() {
			return stratificationcodecriteria;
		}

		public void setStratificationcodecriteria(String stratificationcodecriteria) {
			this.stratificationcodecriteria = stratificationcodecriteria;
		}

		public String getStratificationdetails() {
			return stratificationdetails;
		}

		public void setStratificationdetails(String stratificationdetails) {
			this.stratificationdetails = stratificationdetails;
		}

		public String getStratificationdescription() {
			return stratificationdescription;
		}

		public void setStratificationdescription(String stratificationdescription) {
			this.stratificationdescription = stratificationdescription;
		}

	
		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public Integer getSchemeid() {
			return schemeid;
		}

		public void setSchemeid(Integer schemeid) {
			this.schemeid = schemeid;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public String getStatecode() {
			return statecode;
		}

		public void setStatecode(String statecode) {
			this.statecode = statecode;
		}


}
