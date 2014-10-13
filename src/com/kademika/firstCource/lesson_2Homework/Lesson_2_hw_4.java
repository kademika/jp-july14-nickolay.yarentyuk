package com.midgardabc.lesson_2Homework;

public class Lesson_2_hw_4 {

	public static void main(String[] args) {
		
		int total = 3;
		start(total);
	}

	static void start(int number) {
		
		if (number < 0)
			System.out.println("Start failed!");
			else {
					while (number >= 0) {
					System.out.println(number--);
				}
				
				System.out.println("Go!");
			}
	}
	
}
