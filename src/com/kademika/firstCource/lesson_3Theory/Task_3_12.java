package com.midgardabc.lesson_3Theory;


import java.util.Arrays;

public class Task_3_12 {

	public static void main(String[] args) {
		
		int[] data = {5, 4, 3, 2, 1};
		
		sort(data);
		
		System.out.println(Arrays.toString(data));
	}

	static void sort(int[] data) {
		long time = System.currentTimeMillis();
		if (data != null && data.length > 1) {
			int activeLength = data.length - 1;
			int swapCount;
			for (int i = 0; i < data.length - 1; i++) {
				swapCount = 0;
				for (int j = 0; j < activeLength; j++) {
					swapCount += swap(data, j, j + 1);
				}
				
				if (swapCount == 0)
					break;
				
				activeLength--;
			}
		}
		System.out.println(System.currentTimeMillis() - time + " msec");
	}
	
	static int swap(int[] data, int i, int j) {
		
		int t;
		if (data[i] > data[j]) {
			t = data[j];
			data[j] = data[i];
			data[i] = t;
			
			return 1;
		}
		
		return 0;
	}
}
