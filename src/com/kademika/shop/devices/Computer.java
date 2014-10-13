package com.kademika.shop.devices;


public class Computer extends Device {
	
	private String processor;
	private String videocard;
	
	private double hdd;
	private double ram;
	
	private int totalUsb;
	private boolean cardreader;
	private boolean vga;
	private boolean hdmi;
	private boolean ethernet;
	
	private String os;
	
	public Computer() {
		
	}
		
	public Computer(String produser, String model, String color, boolean broken, boolean skratched,
			String processor, String videocard, double hdd, double ram,
			int totalUsb, boolean cardreader, boolean vga, boolean hdmi, boolean ethernet, String os, double price) {
		
		super(produser, model, color, broken, skratched, price);
		
		this.processor = processor;
		this.videocard = videocard;
		this.hdd = hdd;
		this.ram = ram;
		this.totalUsb = totalUsb;
		this.cardreader = cardreader;
		this.vga = vga;
		this.hdmi = hdmi;
		this.ethernet = ethernet;
		this.os = os;
	}

	public String getProcessor() {
		return processor;
	}

	public String getVideocard() {
		return videocard;
	}

	public double getHdd() {
		return hdd;
	}

	public double getRam() {
		return ram;
	}

	public int getTotalUsb() {
		return totalUsb;
	}

	public boolean isCardreader() {
		return cardreader;
	}

	public boolean isVga() {
		return vga;
	}

	public boolean isHdmi() {
		return hdmi;
	}

	public boolean isEthernet() {
		return ethernet;
	}

	public String getOs() {
		return os;
	}
}
