package com.midgardabc.lesson_6Homework;

public class TaskHw_6_1 {

	public static void main(String[] args) {
		
		method();
	}

	public static void method() {
		
		try {
			return;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("I want to be execute!");
		}
	}
}
