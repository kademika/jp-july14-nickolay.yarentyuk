package com.midgardabc.lesson_7Theory.task_7_11;

public class Person {

	private String name;
	private int age;
	private long salary;
	private Address address;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		salary = 1000;
	}
	
	public Person(String name, int age, String city, String street, int house) {
		this(name, age);
		address = new Address(city, street, house);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person p = (Person) obj;
			if (name != null && name.equals(p.name) && p.age == age && p.salary == salary) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int result = 25;
		result = 37 * result + name.hashCode();
		result = 37 * result + age;
		result = 37 * result + new Long(salary).hashCode();
		if (address != null) {
			result = 37 * result + address.hashCode();
		}
		
		//	fasty copy implementation
//		result = 37 * result + ((int) (value ^ (value >>> 32)));
		
		return result;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public long getSalary() {
		return salary;
	}
}
