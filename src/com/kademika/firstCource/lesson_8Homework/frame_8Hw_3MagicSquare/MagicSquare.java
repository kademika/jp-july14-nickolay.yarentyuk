package com.midgardabc.lesson_8Homework.frame_8Hw_3MagicSquare;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class MagicSquare extends JPanel {

	public int x1 = 100;
	public int y1 = 100;
	public int width = 100;
	public int yHeight = 100;
	
	public MagicSquare(int x1, int y1, int width) {
		this.x1 = x1;
		this.y1 = x1;
		this.width = width;
	}
	
	@Override
	public void paint(Graphics g) {
		Random rand = new Random();
		int red = rand.nextInt(256);
		int green = rand.nextInt(256);
		int blue = rand.nextInt(256);
		
		g.setColor(new Color(red, green, blue));
		g.fillRect(x1, y1, width, width);
	}
}
