package com.midgardabc.lesson_6Theory.shapes;

//import java.awt.Graphics;

public abstract class AbstractShape implements Drawable {
	
	int x, y, width, height, lineWidth;
	
	AbstractShape(int x, int y, int width, int height, int lineWidth) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.lineWidth = lineWidth;
	}
	
//	public abstract void draw(Graphics g);
}
