package com.midgardabc.lesson_5Homework.shop.devices;


public class Printer extends Device {
	
	private PrinterType type;
	private boolean colored;
	private double resolution;
	
	public Printer() {
		
	}
	
	public Printer(String produser, String model, String color, boolean broken, boolean skratched,
			PrinterType type, boolean colored, double resolution, double price) {
		
		super(produser, model, color, broken, skratched, price);
		
		this.type = type;
		this.colored = colored;
		this.resolution = resolution;
	}

	public PrinterType getType() {
		return type;
	}

	public boolean isColored() {
		return colored;
	}

	public double getResolution() {
		return resolution;
	}
}
