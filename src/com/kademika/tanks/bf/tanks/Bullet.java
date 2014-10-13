package com.kademika.tanks.bf.tanks;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.Time;
import java.util.Date;

import com.kademika.tanks.Direction;
import com.kademika.tanks.bf.Destroyable;
import com.kademika.tanks.bf.Drawable;

public class Bullet implements Drawable, Destroyable {

	private int speed = 5;
	
	private int x;
	private int y;
	private Direction direction;

	private boolean destroyed;

    private static Date t = new Date();
    private static int bulletNo = 0;

	public Bullet(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.destroyed = false;

        Date newDate = new Date();
        System.out.println("Bullet " + ++bulletNo + " " + (newDate.getTime() - t.getTime()));
    }

	public void updateX(int x) {
		this.x += x;
	}

	public void updateY(int y) {
		this.y += y;
	}
	
	@Override
	public void draw(Graphics g) {
		if (!destroyed) {
			g.setColor(new Color(255, 255, 0));
			g.fillRect(this.x, this.y, 14, 14);
		}
	}
	
	public void destroy() {
		destroyed = true;
	}
	
	@Override
	public boolean isDestroyed() {
		return destroyed;
	}

	public int getSpeed() {
		return speed;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Direction getDirection() {
		return direction;
	}
}
