package com.midgardabc.lesson_5Theory;

public class Tiger extends com.midgardabc.lesson_4Theory.Tank {
	private int armor;

	public Tiger() {
		
	}
	
	public Tiger(String color, int crew, int maxSpeed, int armor) {
		super(color, crew, maxSpeed);
		this.armor = armor;
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("Tiger is moved.");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
//		return(super.toString() + ": Tiger");
		return("Tank Tiger: color = " + super.getColor() + ", crew = " + super.getCrew() + ", maxSpeed = " + super.getMaxSpeed() + ", armor: " + armor + ".");
	}
	
	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}
}
