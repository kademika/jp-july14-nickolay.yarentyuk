package com.kademika.shop.devices;

public class Notebook extends Computer {
	
	private int battaryLife;
	private double diagonal;
	
	public Notebook() {
		
	}
	
	public Notebook(String produser, String model, String color, boolean broken, boolean skratched,
			String processor, String videocard, double hdd, double ram,
			int totalUsb, boolean cardreader, boolean vga, boolean hdmi, boolean ethernet,
			int battaryLife, double diagonal, String os, double price) {
		
		super(produser, model, color, broken, skratched, processor, videocard, hdd, ram, totalUsb, cardreader, vga,
				hdmi, ethernet, os, price);
		this.battaryLife = battaryLife;
		this.diagonal = diagonal;
	}
	
	public int getBattaryLife() {
		return battaryLife;
	}

	public double getDiagonal() {
		return diagonal;
	}
}
