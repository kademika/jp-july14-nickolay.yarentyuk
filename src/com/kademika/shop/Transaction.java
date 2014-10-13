package com.kademika.shop;

import com.kademika.shop.devices.Device;

public class Transaction {

	int number;
	String customer;
	String device;
	double price;
	
	public Transaction(int number, Customer customer, Device device) {
		
		this.number = number;
		this.customer = customer.firstname + " " + customer.lastname;
		this.device = device.getProduser() + " " + device.getModel();
		this.price = device.getPrice();
	}

	public int getNumber() {
		return number;
	}

	public String getCustomer() {
		return customer;
	}

	public String getDevice() {
		return device;
	}

	public double getPrice() {
		return price;
	}
}
