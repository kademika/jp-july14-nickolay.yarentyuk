package com.midgardabc.lesson_4Homework;

public class Car {
	private Color exteriorColor;
	private Color wheelsColor;
	
	public Car() {
		exteriorColor = Color.WHITE;
		wheelsColor = Color.BLACK;
		
		System.out.println("Created new car: exteriorColor = " + exteriorColor + ", wheelsColor = " + wheelsColor);
	}
	
	public void changeExteriorColor(Color color) {
		exteriorColor = color;
		
		System.out.println("exteriorColor = " + exteriorColor);
	}
	
	public void changeWheelsColor(Color color) {
		wheelsColor = color;
		
		System.out.println("wheelsColor = " + wheelsColor);
	}
}
