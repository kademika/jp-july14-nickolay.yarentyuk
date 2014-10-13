package com.midgardabc.lesson_8Theory;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame_8_4 {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("Hello!");
		f.setLocation(300, 100);
		f.setMinimumSize(new Dimension(800, 600));
		
//		JPanel p = new JPanel();
//		f.getContentPane().add(p);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		
		f.setVisible(true);
	}

}
