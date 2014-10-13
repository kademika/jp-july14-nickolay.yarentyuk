package com.midgardabc.lesson_5Theory;

public class BT7 extends com.midgardabc.lesson_4Theory.Tank {
	
	public BT7() {
		
	}
	
	public BT7(String color, int crew, int maxSpeed) {
		super(color, crew, maxSpeed);
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("BT7 is moved.");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
//		return(super.toString() + ": BT7");
		return("Tank BT7: color = " + super.getColor() + ", crew = " + super.getCrew() + ", maxSpeed = " + super.getMaxSpeed() + ".");
	}
}
