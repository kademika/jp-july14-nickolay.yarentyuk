package com.midgardabc.lesson_4Theory;

public class Task_4_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String color = "Green";
		int crew = 3;
		int maxSpeed = 70;
		
		Tank tank1 = new Tank();
		System.out.println("Tank: color = " + tank1.getColor() + ", crew = " + tank1.getCrew() + ", maxSpeed = " + tank1.getMaxSpeed());
		
		Tank tank2 = new Tank(color, crew, maxSpeed);
		System.out.println("Tank: color = " + tank2.getColor() + ", crew = " + tank2.getCrew() + ", maxSpeed = " + tank2.getMaxSpeed());
	}

}
