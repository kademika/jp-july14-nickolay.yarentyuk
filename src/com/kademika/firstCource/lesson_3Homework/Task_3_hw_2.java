package com.midgardabc.lesson_3Homework;


import java.util.Arrays;

public class Task_3_hw_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data1 = {1, 2};
		int[] data2 = {1, 2, 3, 4, 5, 6, 7};
		
		copyArray(data1, 0, data2, 3, 2);
		
		System.out.println(Arrays.toString(data2));
	}

	static void copyArray(int[] src, int srcPos, int[] dest, int destPos, int length) {
		
		for (int i = 0; i < length; i++) {
			dest[i + destPos] = src[i + srcPos];
		}
	}
}
