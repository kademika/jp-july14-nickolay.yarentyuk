package com.midgardabc.lesson_3Homework;

public class Task_3_hw_5 {

	public static void main(String[] args) {
		
		String[][] data1 = {
				{"A", "123", "X"},
				{"B", "4567", "_"},
		};
		
		printArray(data1);
	}

	static void printArray(String[][] data) {
		
		for (String[] cell : data) {
			for (String s : cell) {
				if (s != null)
					System.out.print(s + " ");
			}
			System.out.println();
		}
		
//		if (data != null)
//			for (int i = 0; i < data.length; i++) {
//				if (data[i] != null) {
//					System.out.print(data[i][0]);
//					if (data[i].length >= 1)
//						for (int j = 1; j < data[i].length; i++) {
//							System.out.print(" " + data[i][j]);
//						}
//					System.out.println();
//				}
//			}
	}
}
