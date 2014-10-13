package com.midgardabc.lesson_7Theory.task_7_11;

import java.util.HashMap;
import java.util.Map;


public class Launcher {

	public static void main(String[] args) {
		
		Person[] personsArray = new Person[7];
		personsArray[0] = new Person("A", 20, "Kiev", "AAA", 1);
		personsArray[1] = new Person("B", 21, "Kiev", "AAA", 2);
		personsArray[2] = new Person("C", 22, "Kiev", "AAA", 3);
		personsArray[3] = new Person("D", 23, "Kiev", "AAA", 4);
		personsArray[4] = new Person("E", 30, "Kiev", "AAA", 5);
		personsArray[5] = new Person("F", 31, "Kiev", "AAA", 6);
		personsArray[6] = new Person("G", 32, "Kiev", "AAA", 7);
		
		Map<String, Person> persons = new HashMap<>();
		
		for (int i = 0; i < personsArray.length; i++) {
			persons.put(personsArray[i].getName(), personsArray[i]);
		}
		
		printPerson(persons.get("C"));
		
		
		
		
//		persons.put("1", null);
		
//		System.out.println(persons.get("1"));
	}
	
	public static void printPerson(Person person) {
		System.out.println();
		System.out.print(person.getName());
		System.out.print(", " + person.getAge());
		System.out.print(", " + person.getSalary());
		
		Address address = person.getAddress();
		System.out.print(", " + address.getCity());
		System.out.print(", " + address.getStreet());
		System.out.print(", " + address.getHouse());
	}
}
