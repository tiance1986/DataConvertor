package com.tiance.gadget.services;

import java.util.ArrayList;
import java.util.List;

import com.tiance.gadget.beans.Customer;
import com.tiance.gadget.beans.Order;
import com.tiance.gadget.beans.Product;

public class BeanGenerator {
	public static final int CUSTOMER = 1001;
	
	public static Object getBean() {
		Product p1 = new Product(1001, "com", 4000);
        Product p2 = new Product(1002, "tra", 2000);
        
        Product[] prod = new Product[]{p1,p2};
        
        Order order = new Order(101, "ele", prod);
        
        List<Order> orders = new ArrayList<Order>();
        
        orders.add(order);
        
        Customer customer = new Customer(1,"Andy", orders);
        
        return customer;
	}
	
	public static Object getBean(int type) {
		if(type == BeanGenerator.CUSTOMER) {
			return getBean();
		}
		return new Object();
	}
}
