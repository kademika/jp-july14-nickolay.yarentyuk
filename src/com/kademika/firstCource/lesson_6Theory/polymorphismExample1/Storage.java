package com.midgardabc.lesson_6Theory.polymorphismExample1;

public class Storage {
	
	public static final String PRODUCER = "Produucer Storage";
	
	public String[] quotes;
	
	public Storage() {
		
		quotes = new String[] {
			"Quote 1 (Storage)",
			"Quote 1 (Storage)"
		};
	}
		
	public void printQuotes() {
		for (String quote : quotes) {
			System.out.println(quote);
		}
	}
	
	public static String getProducer() {
		return PRODUCER;
	}
}
