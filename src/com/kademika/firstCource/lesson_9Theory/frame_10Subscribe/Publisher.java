package com.midgardabc.lesson_9Theory.frame_10Subscribe;

public interface Publisher {

	public void addSubscriber(Subscriber s);
	public void deleteSubscriber(Subscriber s);
	public void notifySubscribers();
}
