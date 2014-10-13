package com.midgardabc.lesson_9Theory.frame_10Subscribe1;

import java.util.LinkedList;

public abstract class AnySubscribe {

	private LinkedList<Subscriber> subscribers = new LinkedList<Subscriber>();
	
	public void addSubscriber(Subscriber s) {
		subscribers.add(s);
	}
	
	public void deleteSubscriber(Subscriber s) {
		subscribers.remove(s);
	}
	
	public void update(Object newNumber) {
		if (!subscribers.isEmpty()) {
			for (Subscriber s : subscribers) {
				s.newMail(newNumber);
			}
		}
	};
}
