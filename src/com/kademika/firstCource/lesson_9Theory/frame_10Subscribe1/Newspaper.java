package com.midgardabc.lesson_9Theory.frame_10Subscribe1;

public class Newspaper extends AnySubscribe {

	private int code;
	private String name;
	
	public Newspaper(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
