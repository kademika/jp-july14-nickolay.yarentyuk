package com.midgardabc.lesson_5Theory;

public class Task_5_7_Launcher {

	public static void main(String[] args) {
		
		System.out.println(darkZone(100, 12, 1000000));
	}

	public static int darkZone(int monthlyPayment, int interest, int dreamSum) {
		// 1 - ежемес€чный взнос, 2 - готовый процент (по умолчанию - 12), 3 - ожидаемый результат
		
		int sum = 0;
		double monthPercent = interest / 12;
		int count = 0;
		
		while (sum < dreamSum) {
			sum += monthlyPayment;
			sum += monthPercent * sum / 100;
			count++;
		}
		
		return count /= 12;
	}
}
