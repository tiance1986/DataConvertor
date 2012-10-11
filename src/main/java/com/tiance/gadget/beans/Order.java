package com.tiance.gadget.beans;

public class Order {

	private int id;
	private String name;
	private Product[] products;
	
	public Order(int id, String name, Product[] products) {
		this.id = id;
		this.name = name;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}
	
}
