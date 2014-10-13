package com.midgardabc.lesson_7Homework.frame_6;

public class Stack {

	Node current = null;
	
	Stack() {
//		current.prev = null;
	}
	
	private class Node {
		Object obj;
		Node prev;
		
		Node(Object obj) {
			this.obj = obj;
		}
	}
	
	public void push(Object obj) {
		Node t = new Node(obj);
		if (current != null) {
			t.prev = current;
		}
		current = t;
	}
	
	public Object pop() {
		if (current == null) {
			return null;
		}
		
		Node t = current;
		current = current.prev;
		
		if (t == null) {
			return null;
		}
		return t.obj;
	}
	
	public Object peak() {
		if (current == null) {
			return null;
		}
		return current.obj;
	}
}
