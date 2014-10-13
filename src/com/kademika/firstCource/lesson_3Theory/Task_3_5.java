package com.midgardabc.lesson_3Theory;

public class Task_3_5 {

	public static void main(String[] args) {
		
		System.out.println(oddElementSum(new int[] {1, 2, 3, 4, 5}));
	}

	static long oddElementSum(int[] data) {
		if (data == null || data.length <= 1)
			return -1;
			
		long sum = 0;
		for (int i = 1; i < data.length; i += 2)
			sum += data[i];
		
		return sum;
	}
}
