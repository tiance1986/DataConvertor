package com.tiance.gadget.services;

import com.thoughtworks.xstream.XStream;

public class StructureFormat {

	public static String convertObject(XStream xstream, Object o) {
		if(xstream == null) return null;		
		return xstream.toXML(o);
	}
	
}
