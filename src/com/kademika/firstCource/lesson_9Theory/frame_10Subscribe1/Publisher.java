package com.midgardabc.lesson_9Theory.frame_10Subscribe1;

import java.util.ArrayList;

public class Publisher {

	private ArrayList <Newspaper> newspapers;
	private ArrayList <Magazine> magazines;
	
	public Publisher() {
		newspapers = new ArrayList<>();
		magazines = new ArrayList<>();
	}
	
	public void addNewspaper(Newspaper newspaper) {
		newspapers.add(newspaper);
	}
	
	public void deleteNewspaper(Newspaper newspaper) {
		newspapers.remove(newspaper);
	}
	
	public Newspaper getNewspaper(int n) {
		return newspapers.get(n);
	}
	
	public void printNespapers() {
		if (newspapers.isEmpty()) {
			System.out.println("There isn't any newspaper.");
		} else {
			System.out.println("Newspapers:");
			System.out.println();
			for (Newspaper newspaper : newspapers) {
				System.out.println(newspaper.getCode() + " " + newspaper.getName());
			}
		}
	}
	
	public void addMagazine(Magazine magazine) {
		magazines.add(magazine);
	}
	
	public void deleteMagazine(Magazine magazine) {
		magazines.remove(magazine);
	}
	
	public Magazine getMagazine(int n) {
		return magazines.get(n);
	}
	
	public void printMagazines() {
		if (magazines.size() == 0) {
			System.out.println("There isn't any magazine.");
		} else {
			System.out.println("Magazines:");
			System.out.println();
			for (Magazine magazine : magazines) {
				System.out.println(magazine.getCode() + " " + magazine.getName());
			}
		}
	}
	
	public void newSubscribe(Subscriber s, int code) {
		AnySubscribe newSubscribe = getSubscribtionObject(code);
		if(newSubscribe == null) {
			System.out.println("This code is wrong.");
		} else {
			newSubscribe.addSubscriber(s);
		}
	}
	
	public void deleteSubscribe(Subscriber s, int code) {
		AnySubscribe deleteSubscribe = getSubscribtionObject(code);
		if(deleteSubscribe == null) {
			System.out.println("This code is wrong.");
		} else {
			try {
				deleteSubscribe.deleteSubscriber(s);
			} catch (Exception e) {
				
			}
		}
	}
	
	public void updateNumber(int code, Object number) {
		AnySubscribe newUpdate = getSubscribtionObject(code);
		if(newUpdate == null) {
			System.out.println("This code is wrong.");
		} else {		
			newUpdate.update(number);
		}
	}
	
	private AnySubscribe getSubscribtionObject(int code) {
		
		for (Magazine magazine : magazines) {
			if (magazine.getCode() == code) {
				return magazine;
			}
		}
		
		for (Newspaper newspaper : newspapers) {
			if (newspaper.getCode() == code) {
				return newspaper;
			}
		}
		
		return null;
	}
}
