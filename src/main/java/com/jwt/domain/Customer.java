package com.jwt.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private int id;
	private String name;
	private String lastname;
	private String username;
	private String password;
	private String role;
	private String token;
	private Adress adress;
	private List<Order> orders = new ArrayList<Order>();
	private int cart_id;
	private String straat;
	
	private int nummer;

	public Customer(String name, String lastname, String straat, int nummer) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.straat = straat;
		this.nummer = nummer;
				}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void addOrder(Order order) {
		this.orders.add(order);
	}
	
	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

}
