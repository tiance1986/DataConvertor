package com.tiance.gadget.services;

import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.thoughtworks.xstream.XStream;
import com.tiance.gadget.utils.ResourcesLoader;

public abstract class StreamFactory {
	
	private Log log = LogFactory.getLog(StreamFactory.class);
	
	public static final String XML = "XML";
	public static final String JSON = "JSON";
	private static final String ALIAS_MAPPING_FILE_NAME = "aliasMapping.properties";
	
	protected XStream xstream;
	
	public XStream getStream() {
		createStream();
		initialStream();
		return xstream;
	}
	
	protected abstract void createStream();
	
	private void initialStream() {
		loadAlias();
	}
	
	private void loadAlias() {
		Properties prop = ResourcesLoader.loadProperties(ALIAS_MAPPING_FILE_NAME);
		
		Set<Object> aliasKeys = prop.keySet();
		for(Object aliasKeyObj : aliasKeys) {
			try{
				String qualifiedClassName = formatAliasKey((String)aliasKeyObj);
				Class<?> classObj = Class.forName(qualifiedClassName);
				xstream.alias(prop.getProperty((String)aliasKeyObj), classObj);
			}catch(Exception e) {
				log.error(e);
				e.printStackTrace();
			}
		}
	}
	
	private String formatAliasKey(String aliasKey) {
		return StringUtils.replace(aliasKey, "/", ".");
	}
	
}
