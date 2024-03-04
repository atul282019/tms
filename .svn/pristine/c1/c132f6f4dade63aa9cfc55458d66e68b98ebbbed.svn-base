package com.gov.nha.bis.server.face.auth;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class FaceRdRequest {
	
	public static String getPidOptions( String RdVer, String fingerCount, String fingerType,
			String irisCount, String irisType, String facePhotoCount, String facePhotoType,
			String format, String  pidVer, String capTimeout, String otp, String wadh ,
			String biPosh,String env ,String paramName1,String paramValue1,
			String paramName2,String paramValue2,String paramName3,String paramValue3){

		StringWriter stringWriter = new StringWriter();

		PidOptions pidOptions= new PidOptions();
		pidOptions.setVer(RdVer);
		pidOptions.setEnv(env);
	
		Opts opts= new Opts();
		opts.setfCount(fingerCount);		
		opts.setfType(fingerType);
		opts.setiCount(irisCount);
		opts.setiType(irisType);
		opts.setpCount(facePhotoCount);
		opts.setpType(facePhotoType);
		opts.setFormat(format);
		opts.setPidVer(pidVer);
		opts.setTimeout(capTimeout);
		opts.setOtp(otp);
		opts.setWadh(wadh);
		opts.setPosh(biPosh);
		
	
		CustOpts custOpts = new CustOpts();
		List<Param> list = new ArrayList<Param>();
		Param param= new Param();
		param.setName(paramName1);
		param.setValue(paramValue1);
		list.add(param);
		
		Param param2= new Param();
		param2.setName(paramName2);
		param2.setValue(paramValue2);
		list.add(param2);
		
		
		Param param3= new Param();
		param3.setName(paramName3);
		param3.setValue(paramValue3);
		list.add(param3);
		
		custOpts.setParam(list);
		
		
		pidOptions.setOpts(opts);
		
		pidOptions.setCustOpts(custOpts);


		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(PidOptions.class);

			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);  
			marshaller.marshal(pidOptions, stringWriter);

		} catch (JAXBException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block

		}
		return stringWriter.toString();
	}

}
