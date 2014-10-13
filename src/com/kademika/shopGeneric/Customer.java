package com.kademika.shopGeneric;

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

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }
}
