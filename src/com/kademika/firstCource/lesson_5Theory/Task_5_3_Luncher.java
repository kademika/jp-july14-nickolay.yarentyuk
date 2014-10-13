package com.midgardabc.lesson_5Theory;

import com.midgardabc.lesson_4Theory.Tank;

public class Task_5_3_Luncher {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tank tank = new Tank("Green", 3, 70);
		tank.move();
		System.out.println(tank.toString());
		
		System.out.println();
		
		BT7 tank1 = new BT7("Blue", 4, 80);
		tank1.move();
		System.out.println(tank1.toString());
		
		System.out.println();
		
		T34 tank2 = new T34("Green", 3, 60);
		tank2.move();
		System.out.println(tank2.toString());
		
		System.out.println();
		
		Tiger tank3 = new Tiger("Red", 4, 120, 3);
		tank3.move();
		System.out.println(tank3.toString());
	}
}
