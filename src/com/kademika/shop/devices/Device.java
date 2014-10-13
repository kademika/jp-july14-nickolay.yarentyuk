package com.kademika.shop.devices;

public class Device {
	
	protected double price = 0;
	protected String produser;
	protected String model;
	protected String color;
	protected boolean switchedOn = false;
	protected boolean skratched;
	protected boolean broken;

	public Device() {
		price = 1;
	}
	
	public Device(String produser, String model, String color, boolean broken, boolean skratched, double price) {
		this.produser = produser;
		this.model = model;
		this.color = color;
		this.broken = broken;
		this.skratched = skratched;
		this.price = price;
	}
	
	public void switchOn() {
		if (broken == false)
		switchedOn = true;
	}
	
	public void switchOff() {
		switchedOn = false;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	public String getProduser() {
		return produser;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public boolean isSwitchedOn() {
		return switchedOn;
	}

	public boolean isSkratched() {
		return skratched;
	}

//	public boolean isBroken() {
//		return broken;
//	}	
}
