package com.midgardabc.lesson_9Theory.frame_10Subscribe1;

public class Demo {

	Publisher publisher = new Publisher();
	
	public Demo() {
		
		publisher.addNewspaper(new Newspaper(10, "Facty"));
		publisher.addNewspaper(new Newspaper(11, "Grif"));
		
		publisher.addMagazine(new Magazine(20, "Chip"));
		
		String firstGrifNumber = "Grif 1-st number";	// New number of Facty was published but it was not published
		publisher.updateNumber(11, firstGrifNumber);
		
		Subscriber s1 = new Subscriber("Ivan", "Ivanov");	// First subscriber
		publisher.printNespapers();
		publisher.newSubscribe(s1, 10);	// subscribed to Facty
		System.out.println();
		
		publisher.printMagazines();
		publisher.newSubscribe(s1, 20);	// subscribed to Chip
		
		Subscriber s2 = new Subscriber("Petr", "Petrov");	// Second subscriber
		publisher.printNespapers();
		publisher.newSubscribe(s2, 10);	// subscribed to Facty
		System.out.println();
		
		String firstChipNumber = "Chip 1-st number";	// New number of Chip was published
		publisher.updateNumber(20, firstChipNumber);
		System.out.println();
		
		String firstFactyNumber = "Facty 1-st number";	// New number of Facty was published
		publisher.updateNumber(10, firstFactyNumber);
		System.out.println();
		
		publisher.deleteSubscribe(s1, 10);	// First subscriber canceled for subscribing Facty 
		
		String secondFactyNumber = "Facty 2-st number";	// New number of Facty was published
		publisher.updateNumber(10, secondFactyNumber);
	}
}
