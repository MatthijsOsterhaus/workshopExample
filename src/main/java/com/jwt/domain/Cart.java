package com.jwt.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private int id;
	private int customer_id;
	private List<Product> products = new ArrayList<Product>();

	public Cart(int id, int customer_id, ArrayList<Product> products) {
		this.setId(id);
		this.setCustomer_id(customer_id);
		this.setProducts(products);
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
