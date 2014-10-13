package com.midgardabc.lesson_3Theory;


import java.util.Arrays;

public class Task_3_9_out {

	public static void main(String[] args) {
		
		int[] data = {0, 15, -3, 2};
		
		sort(data);
		
		System.out.println(Arrays.toString(data));
	}

	static void sort(int[] data) {
		
		if (data == null || data.length < 2)
			return;
		
		int t;
		for (int i = 0; i < data.length; i++) {
			for (int j = 1; j < data.length - i; j++) {
				if (data[j-1] > data[j]) {
					t = data[j];
				data[j] = data[j-1];
				data[j-1] = t;
				}
			}
		}
	}
}
