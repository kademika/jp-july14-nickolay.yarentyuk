package com.midgardabc.lesson_6Homework.elMenu;

public class Dish {
	
	private String name;
	private Product[] products;
	private double price;
	private boolean present;
	
	public Dish(String name, Product[] products, double price, boolean present) {
		
		this.name = name;
		this.products = products;
		this.price = price;
		this.present = present;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product[] getProducts() {
		return products;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
