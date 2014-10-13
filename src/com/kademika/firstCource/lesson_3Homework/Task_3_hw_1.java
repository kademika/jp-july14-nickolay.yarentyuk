package com.midgardabc.lesson_3Homework;

public class Task_3_hw_1 {

	public static void main(String[] args) {
		
		double[] data = {1, 2, 3};
		System.out.println(findElement(data, 3));
		System.out.println(findElement(new double[] {4, 5, 6, 7}, 7));
	}

	static int findElement(double[] numbers, double el) {
		
		if (numbers != null)
			for (int i = 0; i < numbers.length; i++) {
				if (numbers[i] == el)
					return i;
			}
		
		return -1;
	}
}
