package com.midgardabc.lesson_7Theory.task_7_1;

public class Student {
	
	private String name;
	private String secondName;
	
	public Student() {
		
	}
	
	public Student(String name, String secondName) {
		this.name = name;
		this.secondName = secondName;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondName;
	}
	
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	@Override
	public String toString() {
		return name + " " + secondName;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Student) {
			Student s = (Student) obj;
			if (name != null && secondName != null && name.equals(s.getName()) && secondName == s.getSecondName()) {
				return true;
			}
		}
		return false;
	}
}
