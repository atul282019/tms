package com.gov.nha.bis.server.util;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gov.nha.bis.server.properties.ApplicationConstantConfig;

@Service
public class LogCustomGenerator {

	@Autowired
	ApplicationConstantConfig applicationConstantConfig;
	
	public void generateLogFile(String logdata, String txnId,String type) {
		BufferedWriter bw = null;FileWriter fw = null;
		StringBuilder FILE_NAME = new StringBuilder();File theDir =null;
		try {
			logdata = "\n\n ######### "+ CommonUtility.getSysDate("dd-MMM-yyyy hh:mm:ss a")+ " ########\n\n"+logdata;
			FILE_NAME.append(applicationConstantConfig.LOG_FILE_PATH).append(CommonUtility.getSysDate("dd-MM-yyyy"));
			
			theDir = new File(FILE_NAME.toString());
			// if the directory does not exist, create it
			if (!theDir.exists()) {
				try {
					theDir.mkdir();
				} catch (Exception se) {
					se.printStackTrace();
				}
			}
			
			FILE_NAME.append("/").append(type).append("/");
			
			theDir = new File(FILE_NAME.toString());
			
			if (!theDir.exists()) {
				try {
					theDir.mkdir();
				} catch (Exception se) {
					se.printStackTrace();
				}
			}
			
			FILE_NAME.append(txnId).append(".txt");
			File file = new File(FILE_NAME.toString());
			if (file.createNewFile()) {}
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(logdata);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			FILE_NAME = null;theDir =null;logdata=null;type=null;
		}
	}
}
