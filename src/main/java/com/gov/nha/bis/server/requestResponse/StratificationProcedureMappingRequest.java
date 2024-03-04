package com.gov.nha.bis.server.requestResponse;

public class StratificationProcedureMappingRequest {
	
	 private String stratificationcode;
		
	    private String procedurecode;
		
	    private String statecode;

	    private Integer schemecode;
		
	    private Integer status;

		public String getStratificationcode() {
			return stratificationcode;
		}

		public void setStratificationcode(String stratificationcode) {
			this.stratificationcode = stratificationcode;
		}

		public String getProcedurecode() {
			return procedurecode;
		}

		public void setProcedurecode(String procedurecode) {
			this.procedurecode = procedurecode;
		}

		public String getStatecode() {
			return statecode;
		}

		public void setStatecode(String statecode) {
			this.statecode = statecode;
		}

		public Integer getSchemecode() {
			return schemecode;
		}

		public void setSchemecode(Integer schemecode) {
			this.schemecode = schemecode;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}



}
