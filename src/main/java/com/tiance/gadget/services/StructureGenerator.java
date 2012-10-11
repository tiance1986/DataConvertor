package com.tiance.gadget.services;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.tiance.gadget.beans.Customer;
import com.tiance.gadget.beans.Order;
import com.tiance.gadget.beans.Product;

public class StructureGenerator {
	
	public static final String XML = "XML";
	public static final String JSON = "JSON";
	
	public String convertBean(Object object, String type) {
		
		XStream xstream = null;
		
		if(type.equals(this.XML)) {
			xstream = new XStream(new Dom4JDriver());
		} else if(type.equals(this.JSON)) {
			xstream = new XStream(new JsonHierarchicalStreamDriver());
		}
			
		
		if(object instanceof Customer){
			xstream.alias("Customer", Customer.class);
			xstream.alias("Product", Product.class);
			xstream.alias("Order", Order.class);
		}
		
		return xstream.toXML(object);
	}
}
