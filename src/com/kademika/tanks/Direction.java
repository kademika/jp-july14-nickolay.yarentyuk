package com.kademika.tanks;

public enum Direction {
//	NONE, UP, DOWN, LEFT, RIGHT;
	NONE(0), UP(1), DOWN(2), LEFT(3), RIGHT(4);
	
	private int id;
	
	private Direction(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
