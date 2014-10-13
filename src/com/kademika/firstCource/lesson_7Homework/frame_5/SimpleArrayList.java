package com.midgardabc.lesson_7Homework.frame_5;

import java.util.ArrayList;

import com.midgardabc.lesson_7Theory.task_7_1.Student;

public class SimpleArrayList {

	Object[] object = new Object[10];
	
	public void add(Object obj, int number) {
		if (number >= object.length) {
			Object[] t = object;
			object = new Object[number + 10];
			System.arraycopy(t, 0, object, 0, t.length);
		}
		
		object[number] = obj;
	}
	
	public void delete(int number) {
		if (number < object.length) {
			object[number] = null;
		}
	}
	
	public Object get(int number) {
		if (number >= object.length) {
			return null;
		} else {
			return object[number];
		}
	}
}
