package com.midgardabc.lesson_7Homework.frame_5;

public class Launcher {

	public static void main(String[] args) {
		
		SimpleArrayList sll = new SimpleArrayList();
		sll.add("A", 0);
		sll.add("B", 100);
		sll.add("C", 101);
		
		sll.delete(100);
		
		System.out.println(sll.get(0));
		System.out.println(sll.get(100));
		System.out.println(sll.get(101));
	}

}
