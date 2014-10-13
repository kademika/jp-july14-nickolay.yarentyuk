package com.kademika.shop.devices;

public class Tv extends Device {
	
	private int diagonal;
	private boolean func3d;
	
	public Tv() {
		
	}
	
	public Tv(String produser, String model, String color, boolean broken, boolean skratched,
			int diagonal, boolean func3d, double price) {
		
		super(produser, model, color, broken, skratched, price);
		
		this.diagonal = diagonal;
		this.func3d = func3d;
	}

	public double getDiagonal() {
		return diagonal;
	}

	public boolean isFunc3d() {
		return func3d;
	}
}
