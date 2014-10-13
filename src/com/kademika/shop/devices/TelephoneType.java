package com.kademika.shop.devices;

public enum TelephoneType {
	
	STANDARD(0), SMARTPHONE(1), COMUNICATOR(2);
	
	int id;
	
	private TelephoneType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
