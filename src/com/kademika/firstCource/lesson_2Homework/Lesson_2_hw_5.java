package com.midgardabc.lesson_2Homework;

public class Lesson_2_hw_5 {

	public static void main(String[] args) {
		
		int n = 7;
		int i = 3;
		
		loop5(i, n);
	}

	static void loop5(int i, int n) {
		
		while (i < n) {
			n++;
			i += 2;
			
			System.out.println("i=" + i + ", n=" + n);
		}
	}
}
