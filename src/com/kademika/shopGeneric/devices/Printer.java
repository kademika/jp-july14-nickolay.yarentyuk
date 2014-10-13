package com.kademika.shopGeneric.devices;

public class Printer extends Device {
	
	private PrinterType type;
	private boolean colored;
	private double resolution;
	
	public Printer() {
		
	}

    public Printer(String producer, String model, String color, boolean broken, boolean scratched, double price) {
        super(producer, model, color, broken, scratched, price);
    }
	
	public Printer(String producer, String model, String color, boolean broken, boolean scratched,
			PrinterType type, boolean colored, double resolution, double price) {
		
		super(producer, model, color, broken, scratched, price);
		
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

//    @Override
//    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder(super.toString() + ", type: " + type);
//
//        if (colored) {
//            stringBuilder.append(", colored");
//        } else {
//            stringBuilder.append(", uncolored");
//        }
//        stringBuilder.append(", " + resolution + " pixels.");
//
//        return stringBuilder.toString();
//    }
}
