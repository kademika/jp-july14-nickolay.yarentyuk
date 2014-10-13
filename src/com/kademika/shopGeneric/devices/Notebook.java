package com.kademika.shopGeneric.devices;

public class Notebook extends Computer {
	
	private int battaryLife;
	private double diagonal;
	
	public Notebook() {
		
	}

    public Notebook(String producer, String model, String color, boolean broken, boolean scratched, double price) {
        super(producer, model, color, broken, scratched, price);
    }
	
	public Notebook(String producer, String model, String color, boolean broken, boolean scratched,
			String processor, String videocard, double hdd, double ram,
			int totalUsb, boolean cardreader, boolean vga, boolean hdmi, boolean ethernet,
			int battaryLife, double diagonal, String os, double price) {
		
		super(producer, model, color, broken, scratched, processor, videocard, hdd, ram, totalUsb, cardreader, vga,
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

//    @Override
//    public String toString() {
//        return super.toString() + ", " + battaryLife + " mA/h, diagonal: " + diagonal + ".";
//    }
}
