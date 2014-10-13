package com.midgardabc.lesson_3Homework;


import java.util.Arrays;

public class Task_3_hw_7 {

	static String[][] birds = { // Тип, Количество, Цена, Продано
		{"Eagle", "2", "15", "1"},
		{"Duck", "30", "2", "3"},
		{"Chicken", "20", "1", "0"},
		{"Hummingbird", "2", "8", "20"},
	};
	
	public static void main(String[] args) {
		
		System.out.println(birdsSold() + " birds sold.");
		System.out.println(getBirdsCount("Duck") + " ducks");
		System.out.println("New delivery needed: " + Arrays.toString(needNewDelivery()));
	}

	static int birdsSold() { // Общее количество проданных птиц
		int result = 0;
		for (String[] arr : birds) {
			result += Integer.parseInt(arr[3]);
		}
		return result;
	}
	
	static int getBirdsCount(String type) { // Общее количество данных птиц
		for (String[] arr : birds) {
			if (type.equals(arr[0]))
				return Integer.parseInt(arr[1]);
		}
		return 0;
	}
	
	static String[] needNewDelivery() { // Нужна ли поставка
		String delivery = "";
		int count;
		for (String[] arr : birds) {
			count = Integer.parseInt(arr[1]);
			if (count < 3)
				delivery += arr[0] + ",";
		}
		return delivery.substring(0, delivery.length() - 1).split(",");
	}
}
