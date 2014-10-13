package com.midgardabc.lesson_9Theory.adapter;

public class AdapterByClassLauncher {

	public static void main(String[] args) {
		
		Target target2 = new AdapterByClass();
		System.out.println(target2.newRequest());
	}

}
