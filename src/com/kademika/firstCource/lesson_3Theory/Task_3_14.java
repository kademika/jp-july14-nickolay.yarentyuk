package com.midgardabc.lesson_3Theory;


import java.util.Arrays;

public class Task_3_14 {

	public static void main(String[] args) {
		
		int[] data1 = {1, 2, 3};
		int[] data2 = {4, 5, 6, 7};
		
		System.out.println(Arrays.toString(union(data1, data2)));
	}

	static int[] union(int[] data1, int[] data2) {
		int[] result = new int[data1.length + data2.length];
		int i = 0;
		for (; i < data1.length; i++) {
			result[i] = data1[i];
		};
		
		for (int j = 0; j < data2.length; j++) {
			result[i++] = data2[j];
		};
		
		return result;
	}
}
