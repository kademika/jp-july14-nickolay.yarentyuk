package com.midgardabc.lesson_7Theory.task_7_1;

public class Task_7_1 {

	public static void main(String[] args) {
		
		Classroom classroom = new Classroom();
		
		Student student;
		
		student = new Student();
		student.setName("Petr1");
		student.setSecondName("Ivanov");
		classroom.addStudent(student);
		
		student = new Student();
		student.setName("Petr2");
		student.setSecondName("Ivanov");
		classroom.addStudent(student);
		
		student = new Student();
		student.setName("Petr3");
		student.setSecondName("Ivanov");
		classroom.addStudent(student);
		
		System.out.println(classroom.isPresent(new Student("Petr1", "Ivanov")));
		
		classroom.deleteStudent(classroom.accessToStudent(1));
		
		System.out.println(classroom.getStudentCount());
		classroom.printStudentInfo();
		
		String a = "1";
		String b = "2";
	}
}
