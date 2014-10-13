package com.kademika.tanks.bf.tanks;

public class StrategyPoint {

	private int x;
	private int y;
	private char obj;
	private int accessLevel;
	private int pointCount;
	
	public StrategyPoint(int x, int y, char obj) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.obj = obj;
		this.accessLevel = 1000000;
		this.pointCount = 1000000;
	}
	
	public StrategyPoint(int x, int y, char obj, int accessLevel, int pointCount) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.obj = obj;
		this.accessLevel = accessLevel;
		this.pointCount = pointCount;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public char getObj() {
		return obj;
	}
	public void setObj(char obj) {
		this.obj = obj;
	}
	public int getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}
	public int getPointCount() {
		return pointCount;
	}
	public void setPointCount(int pointCount) {
		this.pointCount = pointCount;
	}
	
}
