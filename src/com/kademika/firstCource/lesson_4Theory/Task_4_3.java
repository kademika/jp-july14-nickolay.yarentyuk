package com.midgardabc.lesson_4Theory;

public class Task_4_3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printTankInfo();
	}

	static void printTankInfo() {
		Tank tank = new Tank();
		
		System.out.println(tank.getColor());
		System.out.println(tank.getCrew());
		System.out.println(tank.getMaxSpeed());
	}
	
}
