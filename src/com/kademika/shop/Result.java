package com.kademika.shop;

public class Result {

	int total;
	double cost;
	
	public Result() {
		
		total = 0;
		cost = 0;
	}

	public void addTotal(int total) {
		this.total += total;
	}
	
	public int getTotal() {
		return total;
	}

	public void addCost(double cost) {
		this.cost += cost;
	}

	public double getCost() {
		return cost;
	}
}
