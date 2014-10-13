package com.midgardabc.lesson_3Theory;


import java.util.Arrays;

public class Task_3_3 {

	public static void main(String[] args) {
		
		int data[] = {10, -3, 25, 4};
		int i = 1;
		int k = -5;
		
		swap(data, i, k);
		
		System.out.println(Arrays.toString(data));
		
//		int j = 0;
//		while (j < data.length) {
//			System.out.println(data[j]);
//			j++;
//		}
	}

	static void swap(int[] data, int i, int k) {
		
		int length = data.length;
		
		if (data == null || i < 0 || i >= length || k < 0 || k >= length || i == k)
			return;
		
		int t = data[i];
		data[i] = data[k];
		data[k] = t;
	}
}
