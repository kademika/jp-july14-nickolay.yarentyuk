package com.midgardabc.lesson_9Theory.frame_12SubscribeJdk;

import java.util.Observable;
import java.util.Observer;

public class theSubscriber implements Observer {

	private String firstName;
	private String lastName;
	
	public theSubscriber(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println(firstName + " " + lastName + " notified by " + arg.toString() + ".");
	}
}
