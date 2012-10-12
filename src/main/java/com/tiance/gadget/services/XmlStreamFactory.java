package com.tiance.gadget.services;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class XmlStreamFactory extends StreamFactory {

	@Override
	protected void createStream() {
		xstream = new XStream(new Dom4JDriver());
	}
	
}
