package com.midgardabc.lesson_9Theory.frame_10Subscribe;

import java.util.ArrayList;
import java.util.List;

public class Magazine implements Publisher {

	private int code;	
	private String name;
	
	private List<Subscriber> subscribers;
	
	public Magazine(int code, String name) {
		this.code = code;
		this.name = name;
		
		subscribers = new ArrayList<>();
	}

	@Override
	public void addSubscriber(Subscriber s) {
		// TODO Auto-generated method stub
		subscribers.add(s);
	}
	
	@Override
	public void deleteSubscriber(Subscriber s) {
		// TODO Auto-generated method stub
		subscribers.remove(s);
	}
	
	@Override
	public void notifySubscribers() {
		// TODO Auto-generated method stub
		for (Subscriber s : subscribers) {
			s.update(name);
		}
	}
}
