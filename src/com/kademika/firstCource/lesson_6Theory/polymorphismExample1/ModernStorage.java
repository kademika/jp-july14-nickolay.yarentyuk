package com.midgardabc.lesson_6Theory.polymorphismExample1;

public class ModernStorage extends Storage {
	
	public static final String PRODUCER = "Produucer ModernStorage";
	
	private String[] quotes;
	
	public ModernStorage() {
		quotes = new String[] {
				"Quote ModernStorage"
		};
	}
	
	public static String getProducer() {
		return PRODUCER;
	}
}
