package com.midgardabc.lesson_6Theory.polymorphismExample2;

public class NullGlyph extends Glyph {
	
	String name = "Abc";
	
	@Override
	public void draw() {

		System.out.println(name.length());
	}
}
