package com.midgardabc.lesson_9Theory.math.v2.calc;

import com.midgardabc.lesson_9Theory.math.Arifmetika;

public class ArifmeticaCalculator implements Calculator {

	@Override
	public int summa(int a, int b) {
		return Arifmetika.summa(new int[] {a, b});
	}
	
	@Override
	public int multiply(int a, int b) {
		int result = a;
		for (int i = 0; i < b; i++) {
			result = Arifmetika.summa(new int[] {result, a});
		}
		return result;
	}
}
