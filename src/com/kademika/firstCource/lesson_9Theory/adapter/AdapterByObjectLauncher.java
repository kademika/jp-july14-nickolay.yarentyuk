package com.midgardabc.lesson_9Theory.adapter;

public class AdapterByObjectLauncher {

	public static void main(String[] args) {
		
		Target target1 = new AdapterByObject();
		System.out.println(target1.newRequest());
	}

}
