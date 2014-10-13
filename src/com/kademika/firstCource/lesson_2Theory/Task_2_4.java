package com.midgardabc.lesson_2Theory;

public class Task_2_4 {

	public static void main(String[] args) {

		int valueInt = 3;
		double valueDouble = 3.5;
		
		System.out.println(square(valueInt));
		System.out.println(square(valueDouble));
		System.out.println(square(21d));

	}

static double square(double number) {
	
	System.out.println("double:"); // индикатор
	return number * number;
	
}

static int square(int number) {
	
	System.out.println("int:"); // индикатор
	return number * number;
	
}
	
}
