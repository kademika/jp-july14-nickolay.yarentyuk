package com.midgardabc.lesson_9Theory.frame_12SubscribeJdk;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Magazine extends Observable {

	private int code;	
	private String name;
	
	public Magazine(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public void notifySubscribers() {
		// TODO Auto-generated method stub
		setChanged();
		notifyObservers(name);
	}
}
