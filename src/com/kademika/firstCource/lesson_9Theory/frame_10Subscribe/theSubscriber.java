package com.midgardabc.lesson_9Theory.frame_10Subscribe;

public class theSubscriber implements Subscriber {

	private String firstName;
	private String lastName;
	
	public theSubscriber(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public void update(Object arg) {
		// TODO Auto-generated method stub
		System.out.println(firstName + " " + lastName + " notified by " + arg + ".");
	}
}
