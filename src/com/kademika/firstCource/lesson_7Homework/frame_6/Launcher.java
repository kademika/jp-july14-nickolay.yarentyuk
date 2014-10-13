package com.midgardabc.lesson_7Homework.frame_6;

public class Launcher {

	public static void main(String[] args) {
		
		Stack stack = new Stack();
		
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		System.out.println(stack.peak());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
