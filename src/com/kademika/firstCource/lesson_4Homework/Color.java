package com.midgardabc.lesson_4Homework;

public enum Color {

	BLACK(0), WHITE(1), GREY(2), DARK_GREY(3), RED(4), GREEN(5), BLUE(6), BROWN(7), YELLOW(8), PINK(9), PURPLE(10), ORANGE(11), LIGHT_BLUE(12), LIGHT_GREEN(13), DARK_BLUE(14), DARK_GREEN(15);
	
	private int id;
	
	private Color(int id) {
		this.id = id;
	}
	
	Color getDefaultColor() {
		return BLACK;
	}
}
