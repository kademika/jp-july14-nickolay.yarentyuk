package com.midgardabc.lesson_3Homework;

public class Task_3_hw_3 {

	public static void main(String[] args) {
		
		System.out.println(inverse("Abcdefghi"));
	}

	static String inverse(String str) {
		
		if (str == null)
			return null;
		else
		{
			char[] Symbols = str.toCharArray();
		
			char t;
			for (int i = 0; i < Symbols.length / 2; i++) {
				t = Symbols[i];
				Symbols[i] = Symbols[Symbols.length - i - 1];
				Symbols[Symbols.length - i - 1] = t;
			}
			return (new String(Symbols));
		}
	}
}
