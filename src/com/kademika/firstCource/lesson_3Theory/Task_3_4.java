package com.midgardabc.lesson_3Theory;


import java.util.Arrays;

public class Task_3_4 {

	public static void main(String[] args) {
		
		int data[] = {10, 2, -5, 40};
		printArray(data);
	}

	static void printArray(int[] data) {
		
		if (data != null)
			if (data.length == 0)
				System.out.println("[]");
			else {
				System.out.print("[");
				int i = 0;
				
				while (i != data.length-1) {
					System.out.print(data[i] + ", ");
					i++;
				}
				System.out.println(data[i] + "]");
			}
	}
}
