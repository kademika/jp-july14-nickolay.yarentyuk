package com.kademika.tanks.bf.tanks;

import com.kademika.tanks.Direction;
import com.kademika.tanks.bf.Destroyable;
import com.kademika.tanks.bf.Drawable;

public interface Tank extends Drawable, Destroyable {
	
	public void setEnemy(Tank enemy);
	
	public Action setUp();

	public void move();

	public Bullet fire();

	public int getX();

	public int getY();
	
	public Direction getDirection();

    public void setDirection(Direction direction);
	
	public void updateX(int x);

	public void updateY(int y);
	
	public int getSpeed();
	
	public int getMovePath();

}
