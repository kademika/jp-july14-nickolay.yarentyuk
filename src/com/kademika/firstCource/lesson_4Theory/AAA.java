package com.midgardabc.lesson_4Theory;

public enum AAA {
	A1(0), A2(1), A3(2);
	
	private int id;
	
	private AAA(int id) {
		this.id = id;
	}
	
	AAA getDefaultAAA(){
		return A1;
	}
}
