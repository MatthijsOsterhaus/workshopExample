package com.jwt.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Sale {
	private int id;
	private Date begindate;
	private Date enddate;
	private List<Product> products = new ArrayList<Product>();

	public Sale(int id, Date begindate, Date enddate) {
		super();
		this.id = id;
		this.begindate = begindate;
		this.enddate = enddate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBegindate() {
		return begindate;
	}

	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
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

}
