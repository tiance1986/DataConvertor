package com.tiance.gadget.gadget_dataConvertor;

import com.thoughtworks.xstream.XStream;
import com.tiance.gadget.beans.Customer;
import com.tiance.gadget.services.BeanBuilder;
import com.tiance.gadget.services.StreamFactory;
import com.tiance.gadget.services.StructureFormat;
import com.tiance.gadget.services.XmlStreamFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Customer customer = (Customer)BeanBuilder.getBean(BeanBuilder.CUSTOMER);
        
        StreamFactory streamFactory = new XmlStreamFactory();
        XStream xstream = streamFactory.getStream();
        
        String xml = StructureFormat.convertObject(xstream, customer);
        
        System.out.println(xml);
        
    }
}
