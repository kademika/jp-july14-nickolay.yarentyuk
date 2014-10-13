package com.midgardabc.lesson_9Theory.frame_10Subscribe;

public class Demo {
	
	public Demo() {
		
		Newspaper facty = new Newspaper(10, "Facty");
		Magazine chip = new Magazine(20, "Chip");
		
		theSubscriber s1 = new theSubscriber("Ivan", "Ivanov");	// First subscriber
		facty.addSubscriber(s1);	// subscribed to Facty
		
		chip.addSubscriber(s1);	// subscribed to Chip
		
		theSubscriber s2 = new theSubscriber("Petr", "Petrov");	// Second subscriber
		facty.addSubscriber(s2);	// subscribed to Facty
		
		chip.notifySubscribers();	// New number of Chip was published
		System.out.println();
		
		facty.notifySubscribers();	// New number of Facty was published
		System.out.println();
		
		facty.deleteSubscriber(s1);	// First subscriber canceled for subscribing Facty 
		
		facty.notifySubscribers();	// New number of Facty was published
	}
}
