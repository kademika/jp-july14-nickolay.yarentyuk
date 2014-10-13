package com.midgardabc.lesson_2Theory;

public class Task_2_9 {

	public static void main(String[] args) {

		int a = 50;
		int b = 100;
		int c = 37;
		
		System.out.println(min(a, b, c));

	}

	static int min(int a, int b, int c) {
		
		int minT = a;
		if (b < minT)
			minT=b;
			else if (c < minT)
					minT = c;
		return minT;
		
	}
	
}
