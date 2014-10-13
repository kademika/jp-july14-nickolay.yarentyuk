package com.midgardabc.lesson_5Homework.shop.devices;

public enum PrinterType {
	
	LASER(0), STYLUS(1), MATRIX(2);
	
	private int id;
	
	private PrinterType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
