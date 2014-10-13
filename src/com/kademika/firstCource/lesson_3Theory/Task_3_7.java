package com.midgardabc.lesson_3Theory;


import java.util.Arrays;

public class Task_3_7 {

	public static void main(String[] args) {
		
		int[] data = {1, 2, 3, 4, 5};
		
		swap(data);
		
		System.out.println(Arrays.toString(data));
	}

	static void swap(int[] data) {
		
		if (data == null || data.length < 2)
			return;
		
		int t;
		for (int i = 1; i < data.length; i++) {
			t = data[i];
			data[i] = data[i-1];
			data[i-1] = t;
		}
	}
}
