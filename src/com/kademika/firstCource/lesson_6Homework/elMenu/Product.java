package com.midgardabc.lesson_6Homework.elMenu;

public class Product {
	
	private String name;
	private double total;
	private Unit unit;
	
	public Product(String name, Unit unit) {
		
		this.name = name;
		this.unit = unit;
	}
	
	public Product(String name, double total, Unit unit) {
		
		this.name = name;
		this.total = total;
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}
