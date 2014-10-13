package com.midgardabc.lesson_5Theory;

//import lesson_4_theory.Tank;
//import lesson_5_theory.BT7;

public class Task_5_1_Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BT7 tank1 = new BT7();
		System.out.println(tank1.getColor());
		System.out.println(tank1.getCrew());
		System.out.println(tank1.getMaxSpeed());

		T34 tank2 = new T34();
		System.out.println(tank2.getColor());
		System.out.println(tank2.getCrew());
		System.out.println(tank2.getMaxSpeed());
		
		Tiger tank3 = new Tiger();
		System.out.println(tank3.getColor());
		System.out.println(tank3.getCrew());
		System.out.println(tank3.getMaxSpeed());
	}
}
