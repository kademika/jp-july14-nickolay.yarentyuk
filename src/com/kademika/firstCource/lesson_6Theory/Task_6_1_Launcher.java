package com.midgardabc.lesson_6Theory;

public class Task_6_1_Launcher {

	public static void main(String[] args) {
		
//		System.out.println("123");
		
		try {
			System.out.println("123");
			throw new MyPersonalException();
			
		} catch (MyPersonalException e) {
			System.out.println("Error!");
			e.printError();
			
		} finally {
			System.out.println("4567");
		}
		
		System.out.println();
		
		double a = 1;
		double b = 2;
		
		try {
			Thread.currentThread().interrupt();
			System.out.println(a + b);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error!");
			
		} finally {
			System.out.println("123");
		}
	}
	
	
}
