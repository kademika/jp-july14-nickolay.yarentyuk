package com.midgardabc.lesson_7Theory.task_7_11;

public class Address {

	private String city;
	private String street;
	private int house;
	
	public Address(String city, String street, int house) {
		if (city == null || street == null || house <= 0) {
			throw new IllegalStateException("Parameters should not contains null values and house should be > 0.");
		}
		
		this.city = city;
		this.street = street;
		this.house = house;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Address) {
			Address addr = (Address) obj;
			if (city.equals(addr.getCity()) && street.equals(addr.getStreet()) && house == addr.getHouse()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int result = 25;
		result = 37 * result + city.hashCode();
		result = 37 * result + street.hashCode();
		result = 37 * result + house;
		
		return result;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public int getHouse() {
		return house;
	}
}
