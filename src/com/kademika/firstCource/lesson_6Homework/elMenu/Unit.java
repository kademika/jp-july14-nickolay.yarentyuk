package com.midgardabc.lesson_6Homework.elMenu;

public enum Unit {
	
	MILLILITER(0), LITER(1), MILLIGRAM(2), GRAM(3), KILOGRAM(4);
	
	int id;
	
	private Unit(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
