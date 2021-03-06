package com.jwt.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private int id;
	private String name;
	private ArrayList<Product> products;

	public Category(int id, String name, ArrayList<Product> products) {
		this.id = id;
		this.name = name;
		this.products = products;
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
