package com.midgardabc.lesson_6Theory.statePattern;

public class TheaterLauncher {
	
	private Actor actor;
	
	public static void main(String[] args) {
		
		TheaterLauncher t = new TheaterLauncher();
		t.actor = new HeppyActor();
		t.actor.act();
		
		t.intermission();
		
		t.actor.act();
	}
	
	public void intermission() {
		getSallary();
	}
	
	public void getSallary() {
		actor = new SadActor();
	}
}
