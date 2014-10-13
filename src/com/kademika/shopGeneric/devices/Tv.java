package com.kademika.shopGeneric.devices;

public class Tv extends Device {
	
	private int diagonal;
	private boolean func3d;
	
	public Tv() {
		
	}

    public Tv(String producer, String model, String color, boolean broken, boolean scratched, double price) {
        super(producer, model, color, broken, scratched, price);
    }
	
	public Tv(String producer, String model, String color, boolean broken, boolean scratched,
			int diagonal, boolean func3d, double price) {
		
		super(producer, model, color, broken, scratched, price);
		
		this.diagonal = diagonal;
		this.func3d = func3d;
	}

	public double getDiagonal() {
		return diagonal;
	}

	public boolean isFunc3d() {
		return func3d;
	}

//    @Override
//    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder(super.toString() + ", " + diagonal + " inches");
//
//        if (func3d) {
//            stringBuilder.append(", function 3D");
//        }
//        stringBuilder.append(".");
//
//        return stringBuilder.toString();
//    }
}
