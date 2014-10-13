package com.kademika.tanks.bf;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;


public abstract class SimpleBFObject implements BFObject {

	// current position on BF
	private int x;
	private int y;
	
	protected Color color;

	private boolean isDestroyed = false;
	
	Image image;
	
	public SimpleBFObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void destroy() {
		isDestroyed = true;
	}
	
	@Override
	public void draw(Graphics g) {
		if (!isDestroyed) {
			if (image != null) {
				g.drawImage(image, getX(), getY(), getX() + 64, getY() + 64, getX(), getY(), getX() + 64, getY() + 64, new ImageObserver() {
					
					@Override
					public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,
							int arg4, int arg5) {
						// TODO Auto-generated method stub
						return false;
					}
				});
			} else {
				
				g.setColor(this.color);
				g.fillRect(this.getX(), this.getY(), 64, 64);
			}
		}
	}
	
	public boolean isDestroyed() {
		return isDestroyed;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
