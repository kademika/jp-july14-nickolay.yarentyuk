package com.midgardabc.lesson_6Theory.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.Polygon;

public class Triangle extends AbstractShape {
	
	public Triangle(int x, int y, int width, int height, int lineWidth) {
		
		super(x, y, width, height, lineWidth);
	}
	
	@Override
	public void draw(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(lineWidth));
		
		int a[] = {x, x + width / 2, x + width};
		int b[] = {y + height, y, y + height};
		
		g.setColor(new Color(0, 255, 0));
		g.fillPolygon(a, b, 3);
		
		g.setColor(new Color(255, 0, 0));
		g.drawPolygon(a, b, 3);
	}
}
