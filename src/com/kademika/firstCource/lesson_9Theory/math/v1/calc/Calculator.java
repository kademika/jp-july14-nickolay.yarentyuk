package com.midgardabc.lesson_9Theory.math.v1.calc;

import com.midgardabc.lesson_9Theory.math.Arifmetika;

public class Calculator {

	public int summa(int a, int b) {
		return Arifmetika.summa(new int[] {a, b});
//		return a + b;
	}

	public int multiply(int a, int b) {
		int result = 0;
		for (int i = 0; i < b; i++) {
			result = Arifmetika.summa(new int[] {result, a});
		}
		return result;
//		return a * b;
	}
}
