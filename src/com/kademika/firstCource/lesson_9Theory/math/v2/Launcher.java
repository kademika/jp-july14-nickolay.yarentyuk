package com.midgardabc.lesson_9Theory.math.v2;

import java.util.Random;

import com.midgardabc.lesson_9Theory.math.v2.calc.ArifmeticaCalculator;
import com.midgardabc.lesson_9Theory.math.v2.calc.Calculator;

public class Launcher {

	public static void main(String[] args) {

		Calculator calc = new ArifmeticaCalculator();
		//		Calculator calc = new DefaultCalculator();
		
		Operations o = new Operations();
		o.setCalc(calc);

		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			System.out.println(o.createSummaryReport(r.nextInt(100)));
		}
	}
}
