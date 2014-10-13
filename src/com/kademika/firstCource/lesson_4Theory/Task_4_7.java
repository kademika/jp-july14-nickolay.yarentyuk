package com.midgardabc.lesson_4Theory;

public class Task_4_7 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tank[] tanks = new Tank[5];
		
		tanks[0] = new Tank("Green", 3, 70);
		tanks[1] = new Tank("Blue", 4, 80);
		tanks[2] = new Tank("Green", 3, 60);
		tanks[3] = new Tank("Red", 4, 120);
		tanks[4] = new Tank("Blue", 3, 110);
		
		printTankInfo(tanks);
	}

	static void printTankInfo(Tank[] tanks) {
		for (int i = 0; i < tanks.length; i++) {
			System.out.println("Tank: color = " + tanks[i].getColor() + ", crew = " + tanks[i].getCrew() + ", maxSpeed = "
					+ tanks[i].getMaxSpeed());
		}
	}
}
