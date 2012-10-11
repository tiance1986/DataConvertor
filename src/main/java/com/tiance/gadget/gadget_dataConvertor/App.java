package com.tiance.gadget.gadget_dataConvertor;

import java.util.ArrayList;
import java.util.List;

import com.tiance.gadget.beans.Customer;
import com.tiance.gadget.beans.Order;
import com.tiance.gadget.beans.Product;
import com.tiance.gadget.services.BeanGenerator;
import com.tiance.gadget.services.StructureGenerator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StructureGenerator x = new StructureGenerator();
        Customer customer = (Customer)BeanGenerator.getBean(BeanGenerator.CUSTOMER);
        
        String xml = x.javabean2xml(customer);
        
        System.out.println(xml);
        
    }
}
