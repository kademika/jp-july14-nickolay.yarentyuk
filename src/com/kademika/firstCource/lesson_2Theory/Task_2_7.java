package com.midgardabc.lesson_2Theory;

public class Task_2_7 {

	public static void main(String[] args) {

		int age = 30;
		
		System.out.println(oldEnough(age));

	}

	static boolean oldEnough(int age) {
		
		if (age >= 21)
			return true;
		return false;
			
	}
	
}
