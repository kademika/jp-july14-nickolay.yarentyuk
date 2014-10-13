package com.kademika.shopGeneric;

import com.kademika.shopGeneric.devices.*;

import java.util.Date;

public class Transaction {

	int number;
    Date date;
//	String customer;
	Customer customer;
//	String device;
	Device device;
	double price;
	
	public Transaction(int number, Customer customer, Device device) {

		this.number = number;
        this.date = new Date();
//		this.customer = customer.getFirstname() + " " + customer.getLastname();
		this.customer = customer;
//		this.device = device.getProduser() + " " + device.getModel();
		this.device = device;
		this.price = device.getPrice();
	}

	public int getNumber() {
		return number;
	}

    public Date getDate() {
        return date;
    }

//    public String getCustomer() {
//		return customer;
//	}

    public Customer getCustomer() {
		return customer;
	}

//	public String getDevice() {
//		return device;
//	}

    public Device getDevice() {
        return device;
    }

	public double getPrice() {
		return price;
	}
}
