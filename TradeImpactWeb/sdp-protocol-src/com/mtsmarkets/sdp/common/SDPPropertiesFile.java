package com.mtsmarkets.sdp.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SDPPropertiesFile extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5258017454853343551L;
	
	private boolean noInit = true;
	public SDPPropertiesFile(String propertiesFileName){
		super();
		try (FileInputStream fis = new FileInputStream(propertiesFileName)) {
			load(fis);
			noInit = false;
		} catch (IOException e) {
			noInit = true;
		}
	}
	
	public String getProperty(String key) {
		String value = null;
		
		if (noInit == false)
			value = super.getProperty(key);
		
		return value;
	}

}
