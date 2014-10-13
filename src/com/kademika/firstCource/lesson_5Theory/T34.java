package com.midgardabc.lesson_5Theory;

public class T34 extends com.midgardabc.lesson_4Theory.Tank {

	public T34() {
		
	}
	
	public T34(String color, int crew, int maxSpeed) {
		super(color, crew, maxSpeed);
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("T34 is moved.");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
//		return(super.toString() + ": T34");
		return("Tank T34: color = " + super.getColor() + ", crew = " + super.getCrew() + ", maxSpeed = " + super.getMaxSpeed() + ".");
	}
}
