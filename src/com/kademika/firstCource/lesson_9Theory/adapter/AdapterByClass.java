package com.midgardabc.lesson_9Theory.adapter;

public class AdapterByClass extends Adaptee implements Target {
	
	@Override
	public String newRequest() {
		return oldRequest();
	}
}
