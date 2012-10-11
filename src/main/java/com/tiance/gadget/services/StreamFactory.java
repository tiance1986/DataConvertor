package com.tiance.gadget.services;

import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.tiance.gadget.utils.ResourcesLoader;

public class StreamFactory {
	
	private Log log = LogFactory.getLog(StreamFactory.class);
	
	public static final String XML = "XML";
	public static final String JSON = "JSON";
	private static final String ALIAS_MAPPING_FILE_NAME = "aliasMapping.properties";
	
	private XStream xstream;
	
	public XStream getInstance() {
		xstream = getInstance(XML);
		return xstream;
	}
	
	public XStream getInstance(String type) {
		createStream(type);
		
		initialStream();
		
		return xstream;
	}
	
	private void createStream() {
		xstream = new XStream(new Dom4JDriver());
	}
	
	private void createStream(String type) {
		if(type.equals(JSON)) 
			xstream = new XStream(new JsonHierarchicalStreamDriver());
		else if(type.equalsIgnoreCase(XML))
			createStream();
	}
	
	private void initialStream() {
		loadAlias();
		
	}
	
	private void loadAlias() {
		Properties prop = ResourcesLoader.loadProperties(ALIAS_MAPPING_FILE_NAME);
		
		Set<Object> aliasKeys = prop.keySet();
		for(Object aliasKeyObj : aliasKeys) {
			try{
				String qualifiedClassName = formatAliasKey((String)aliasKeyObj);
				Class<?> a = Class.forName(qualifiedClassName);
				xstream.alias(prop.getProperty((String)aliasKeyObj), Class.forName(qualifiedClassName));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private String formatAliasKey(String aliasKey) {
		return StringUtils.replace(aliasKey, "/", ".");
	}
	
	public static void main(String[] args) {
		StreamFactory f = new StreamFactory();
		f.getInstance();
	}
		
}
