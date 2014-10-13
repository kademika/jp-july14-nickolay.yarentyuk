package com.midgardabc.lesson_6Homework;

public class TaskHw_6_2 {

	public static void main(String[] args) {
		
		method();
	}

	public static void method() {
		
		try {
			throw new Exception();
		} catch(Exception e) {
			throw new IllegalStateException();
		} finally {
			System.out.println("I want to be execute!");
		}
	}
}
