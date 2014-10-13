package com.midgardabc.lesson_3Theory;


import java.util.Arrays;

public class Task_3_11 {

	public static void main(String[] args) {
		
		int[] data = {5, 4, 3, 2, 1};
		
		sort(data);
		
		System.out.println(Arrays.toString(data));
	}

	static void sort(int[] data) {
		long time = System.currentTimeMillis();
		if (data != null && data.length > 1) {
			int activeLength = data.length - 1;
			for (int i = 0; i < data.length - 1; i++) {
				for (int j = 0; j < activeLength; j++) {
					swap(data, j, j + 1);
				}
				activeLength--;
			}
		}
		System.out.println(System.currentTimeMillis() - time + " msec");
	}
	
	static void swap(int[] data, int i, int j) {
		
		int t;
		if (data[i] > data[j]) {
			t = data[j];
			data[j] = data[i];
			data[i] = t;
		}
	}
}
