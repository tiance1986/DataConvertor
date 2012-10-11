package com.tiance.gadget.utils;

import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tiance.gadget.services.StreamFactory;

public class ResourcesLoader {
	
	private static Log log = LogFactory.getLog(ResourcesLoader.class);
	
	public static Properties loadProperties(String fileName) {
		Properties properties = new Properties();
		InputStream in = StreamFactory.class.getClassLoader().getResourceAsStream(fileName);
		
		try{
			properties.load(in);
		}catch(Exception e) {
			log.error(e + " - Error loading file");
			e.printStackTrace();
		}
		
		return properties;
	}
}
