package com.midgardabc.lesson_2Theory;

public class Task_2_10 {

	public static void main(String[] args) {

		int monthNumber = 3;
		
		System.out.println(isSpring(monthNumber));

	}

	static int isSpring(int month) {
		
		if (month >= 3 && month <= 5)
			return 1;
			else
				if (month >= 1 && month <= 12)
					return 0;
					else
						return -1;
		
	}
	
}
