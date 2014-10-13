package com.midgardabc.lesson_4Theory;

public class Tank {
	private String color;
	private int crew;
	private int maxSpeed;
	
	public Tank() {}
	
	public Tank(String color, int crew, int maxSpeed) {
		this.color = color;
		this.crew = crew;
		this.maxSpeed = maxSpeed;
		
		System.out.println("Constructor with parametrs.");
	}
	
	public void move() {
		System.out.println("Tank is moved.");
	}
	
	@Override
	public String toString() {
		return("Tank: color = " + color + ", crew = " + crew + ", maxSpeed = " + maxSpeed + ".");
	}
	
	public String getColor() {
		return color;
	}

	public int getCrew() {
		return crew;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}
}
