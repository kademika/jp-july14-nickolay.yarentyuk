package com.midgardabc.lesson_3Theory;


import java.util.Arrays;

public class Task_3_13 {

	public static void main(String[] args) {
		
		String country[][] = {
				{"China", "Peking", "1254040000"},
				{"India", "New Delhi", "1210569573"},
				{"USA", "Washington D.C.", "316305000"},
				{"Indonesia", "Jakarta", "237641326"},
				{"Brasil", "Brasilia", "193946886"},
				{"Pakistan", "Islamabad", "183748000"}
		};
		
		System.out.println(getPopulation(country));
	}

	static long getPopulation(String[][] data) {
		
		long sum = 0;
		
		for (int i = 0; i< data.length; i++) {
			sum += Long.parseLong(data[i][2]);
		}
		
		return sum;
	}
}
