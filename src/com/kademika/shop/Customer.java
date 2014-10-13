package com.kademika.shop;

public class Customer {
	
	String firstname;
	String lastname;
	
	public Customer(String firstname, String lastname) {

		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}
	
	public String getFullName() {
		return firstname + " " + lastname;
	}
}
