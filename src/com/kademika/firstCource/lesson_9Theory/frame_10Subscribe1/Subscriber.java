package com.midgardabc.lesson_9Theory.frame_10Subscribe1;

import java.util.ArrayList;

public class Subscriber {

	private String firstName;
	private String lastName;
	
	private ArrayList<Object> mailbox = new ArrayList<>();
	
	public Subscriber(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void newMail(Object mail) {
		mailbox.add(mail);
		System.out.println("Subscriber " + firstName + " " + lastName + " got " + mail.toString());
	}
	
	public void takeAllMail() {
		System.out.println("There are mails: " + mailbox.toString());
		System.out.println();
		for(Object mail : mailbox) {
			mail.toString();
		}
		mailbox = new ArrayList<>();
	}
}
