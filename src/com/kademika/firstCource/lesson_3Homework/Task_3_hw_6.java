package com.midgardabc.lesson_3Homework;

public class Task_3_hw_6 {

	public static void main(String[] args) {
		
		printJournal();
	}
	
	static void printJournal() {
		
		for (int[] data : journal) {
			for(String s : subjects[data[0]]) {
				System.out.print(s + " ");
			}
		
			for (String s : students[data[1]]) {
				System.out.print(s + " ");
			}
		
			System.out.println(data[2]);
		}
	}
	
	static String[][] students = {
			{"Petr", "Ivanov"},
			{"Vasiliy", "Fyodorov"},
	};
	
	static String[][] subjects = {
			{"Maths", "100"},
			{"Phisics", "80"},
			{"Chemistry", "50"},
	};
	
	static int journal[][] = { // Subject, Student, mark
			{0, 0, 3},
			{0, 1, 4},
			{1, 0, 5},
			{1, 1, 3},
			{2, 0, 5},
			{2, 1, 4},
	};
}
