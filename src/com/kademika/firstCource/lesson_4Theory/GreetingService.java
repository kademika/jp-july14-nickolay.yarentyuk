package com.midgardabc.lesson_4Theory;

public class GreetingService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args.length == 0)
			System.out.println("Enter your name: ");

		else
			System.out.println("Hello " + args[0]);
	}

}
