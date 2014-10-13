package com.kademika.shop.devices;

public class Telephone extends Device {
	
	private TelephoneType type;
	private int totalSim;
	private String os;
	
	public Telephone() {
		
	}
	
	public Telephone(String produser, String model, String color, boolean broken, boolean skratched,
			TelephoneType type, int totalSim, String os, double price) {
		
		super(produser, model, color, broken, skratched, price);
		
		this.type = type;
		this.totalSim = totalSim;
		this.os = os;
	}

	public TelephoneType getType() {
		return type;
	}

	public int getTotalSim() {
		return totalSim;
	}

	public String getOs() {
		return os;
	}
}
