package com.gov.nha.bis.server.face.auth;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="PidOptions")  
public class PidOptions {

		@XmlAttribute(required = true)
	    protected String ver;
	
	    @XmlElement(name= "Opts")
	    protected Opts Opts;
	    
	    @XmlElement(name= "CustOpts")
	    protected CustOpts CustOpts;
	    
	    @XmlAttribute
		protected String env;



		public String getEnv() {
			return env;
		}

		public void setEnv(String env) {
			this.env = env;
		}

	    
		public CustOpts getCustOpts() {
			return CustOpts;
		}

		public void setCustOpts(CustOpts custOpts) {
			CustOpts = custOpts;
		}

		public String getVer() {
			return ver;
		}

		public void setVer(String ver) {
			this.ver = ver;
		}

		public Opts getOpts() {
			return Opts;
		}

		public void setOpts(Opts opts) {
			Opts = opts;
		}

		
	    
	  
	    
	    
}
