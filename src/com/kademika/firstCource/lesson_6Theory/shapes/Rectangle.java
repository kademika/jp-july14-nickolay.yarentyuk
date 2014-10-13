package com.midgardabc.lesson_6Theory.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangle extends AbstractShape {
	
	public Rectangle(int x, int y, int width, int height, int lineWidth) {
		
		super(x, y, width, height, lineWidth);
	}
	
	@Override
	public void draw(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(lineWidth));
		
		g.setColor(new Color(0, 255, 0));
		g.fillRect(x, y, width, height);
		
		g.setColor(new Color(255, 0, 0));
		g.drawRect(x, y, width, height);
	}
}
