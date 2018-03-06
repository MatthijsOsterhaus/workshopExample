package com.jwt.domain;

public class Orderline {
	private int id;
	private int amount;
	private double price;
	private int order_id;

	public Orderline(int id, int amount, double price, int order_id) {
		super();
		this.id = id;
		this.amount = amount;
		this.price = price;
		this.setOrder_id(order_id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

}
