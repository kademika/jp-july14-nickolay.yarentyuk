package com.midgardabc.lesson_9Theory.adapter;

public class AdapterByObject implements Target {

	private Adaptee adaptee;
	
	public AdapterByObject() {
		adaptee = new Adaptee();
	}
	
	@Override
	public String newRequest() {
		return adaptee.oldRequest();
	}
}
