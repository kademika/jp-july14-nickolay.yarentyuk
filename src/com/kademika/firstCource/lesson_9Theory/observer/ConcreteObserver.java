package com.midgardabc.lesson_9Theory.observer;

public class ConcreteObserver implements Observer {
	
	@Override
	public void update() {
		System.out.println(this.toString() + " notified.");
	}
	
}
