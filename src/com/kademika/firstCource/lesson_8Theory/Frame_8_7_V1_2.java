package com.midgardabc.lesson_8Theory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame_8_7_V1_2 extends JPanel {

	public Frame_8_7_V1_2() {
		JFrame frame1 = new JFrame("Frame_8_7");
		frame1.setLocation(300, 100);
		frame1.setMinimumSize(new Dimension(800, 600));	
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame1.getContentPane().add(this);
		
		frame1.pack();
		
		frame1.setVisible(true);
	}
	
	public static void main(String[] args) /*throws Exception */{
		
		new Frame_8_7_V1_2();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 800, 600);
	}
}
