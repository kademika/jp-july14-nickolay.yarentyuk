package com.midgardabc.lesson_3Homework;

public class Task_3_hw_4 {

	public static void main(String[] args) {
		
		System.out.println(factorial(10));
	}

	static long factorial(int i) {
		if (i == 0)
			return 1;
		else {
			long f = 1;
			for (int j = 1; j <= i; j++) {
				f *= j;
			}
			return f;
		}
	}
}
