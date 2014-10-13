package com.kademika.shopGeneric.devices;

public class Phone extends Device {

	private TelephoneType type;
	private int totalSim;
	private String os;

	public Phone() {

	}

    public Phone(String producer, String model, String color, boolean broken, boolean scratched, double price) {
        super(producer, model, color, broken, scratched, price);
    }

	public Phone(String producer, String model, String color, boolean broken, boolean scratched,
                 TelephoneType type, int totalSim, String os, double price) {
		
		super(producer, model, color, broken, scratched, price);
		
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

//    @Override
//    public String toString() {
//        return super.toString() + ", " + type + ", " + totalSim + " sim, " + os;
//    }
}
