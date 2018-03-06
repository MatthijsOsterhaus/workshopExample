package com.jwt.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private int id;
	private Adress deliveryadress;
	private List<Orderline> orderlines = new ArrayList<Orderline>();

	public Order(int id, Adress deliveryadress, ArrayList<Orderline> orderlines) {
		super();
		this.id = id;
		this.deliveryadress = deliveryadress;
		this.orderlines = orderlines;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Adress getDeliveryadress() {
		return deliveryadress;
	}

	public void setDeliveryadress(Adress deliveryadress) {
		this.deliveryadress = deliveryadress;
	}

	public List<Orderline> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(List<Orderline> orderlines) {
		this.orderlines = orderlines;
	}

	public void addOrderline(Orderline orderline) {
		this.orderlines.add(orderline);
	}

}
