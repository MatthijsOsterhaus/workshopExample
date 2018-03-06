package com.jwt.domain;

public class Adress {
	private String street;
	private int streetnumber;
	private int customer_id;

	public Adress(String street, int streetnumber, int customer_id) {
		this.street = street;
		this.streetnumber = streetnumber;
		this.customer_id = customer_id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getStreetnumber() {
		return streetnumber;
	}

	public void setStreetnumber(int streetnumber) {
		this.streetnumber = streetnumber;
	}

}
