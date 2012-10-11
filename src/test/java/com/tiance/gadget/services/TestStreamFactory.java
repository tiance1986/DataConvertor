package com.tiance.gadget.services;

import org.junit.Test;
import static junit.framework.Assert.*;
import com.thoughtworks.xstream.XStream;

public class TestStreamFactory {
	
	@Test
	public void testCreateStream() {
		StreamFactory streamFactory = new StreamFactory();
		XStream xstream = streamFactory.getInstance();
		assertTrue(xstream != null);
	}
}
