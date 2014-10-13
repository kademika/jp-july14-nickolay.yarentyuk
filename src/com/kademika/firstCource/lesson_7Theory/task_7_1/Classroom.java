package com.midgardabc.lesson_7Theory.task_7_1;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
	
	private List <Student> students;
	
	public Classroom() {

		students = new ArrayList <Student>();
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	public void deleteStudent(Student student) {
		students.remove(student);
	}
	
	public int getStudentCount() {
		return students.size();
	}
	
//	public boolean isPresent(String name, String secondName) {
//		for (int i = 0; i < getStudentCount(); i++) {
//			if (students.get(i).getName() == name && students.get(i).getSecondName() == secondName) {
//				return true;
//			}
//		}
//		return false;	
//	}
	
	public boolean isPresent(Student s) {
		return students.contains(s);
	}
	
	public void printStudentInfo() {
		if (students.size() == 0) {
			System.out.println("The classroom is empty.");
		} else {
			for (int i = 0; i < getStudentCount(); i++) {
				System.out.println(students.get(i).getName() + " " + students.get(i).getSecondName());
			}
		}
	}
	
	public List<Student> getStudents() {
		return new ArrayList<>(students);
//		return new ArrayList<Student>(students);
	}
	
	public Student accessToStudent(int n) {
		return students.get(n);
	}
}
