package com.midgardabc.lesson_3Theory;


import java.util.Arrays;

public class Task_3_10 {

	public static void main(String[] args) {
		
		int[] data = {5, 4, 3, 2, 1};
		
		sort(data);
		
		System.out.println(Arrays.toString(data));
	}

	static void sort(int[] data) {
		
		int i = 1;
		
		while (i < data.length) {
			swap(data);
			i++;
		}
	}
	
	static void swap(int[] data) {
		
		if (data == null || data.length < 2)
			return;
		
		int t;
		for (int i = 1; i < data.length; i++) {
			if (data[i-1] > data[i]) {
				t = data[i];
				data[i] = data[i-1];
				data[i-1] = t;
			}
		}
	}
}
