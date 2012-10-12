package com.tiance.gadget.services;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

public class JsonStreamFactory extends StreamFactory {

	@Override
	protected void createStream() {
		xstream = new XStream(new JsonHierarchicalStreamDriver());
	}

}
