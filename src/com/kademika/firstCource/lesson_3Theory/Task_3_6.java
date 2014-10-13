package com.midgardabc.lesson_3Theory;

public class Task_3_6 {

	public static void main(String[] args) {
		
		int[] data = {1, 2, 3, 4, 5};
		
		System.out.println(avarage(data));
	}

	static double avarage (int[] data) {
		
		if (data == null || data.length == 0)
			return -1;
		
		int sum = 0;
		for (int i : data)
			sum += i;
		
		return sum / data.length;
	}
}
