package com.midgardabc.lesson_7Theory.task_7_2;

import java.util.Iterator;

public class Launcher {

	public static void main(String[] args) {
		
		System.err.println("Test:");
		System.out.println();
		
		SimpleLinkedList list = new SimpleLinkedList();
		
		list.addFirst("1");
		list.addLast("2");
		list.addLast("3");
		list.addAfter("4", "3");
//		
//		list.printList();
//		
//		System.out.println();
		
//		for (Object obj : list) {
//			String s = (String) obj;
//			System.out.println(obj);
//		}
		
//		for (Iterator<Object> it = list.iterator(); it.hasNext();) {
//			Object obj = it.next();
//			System.out.println(obj);
//		}
		
		for (Iterator<Object> it = list.iterator(); it.hasNext();) {
			it.next();
			it.next();
			it.remove();
			break;
		}
		
		list.printList();
	}
}
