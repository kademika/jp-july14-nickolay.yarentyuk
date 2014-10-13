package com.midgardabc.lesson_8Homework.frame_8Hw_3MagicSquare;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Launcher implements MouseListener, MouseMotionListener {
	
	public MagicSquare square;
	public JFrame frame1;
	
	final public static int x1 = 50;
	final public static int y1 = 50;
	final public static int width = 500;
	
	public static void main(String[] args) {
		
		Launcher p = new Launcher();
		p.square = new MagicSquare(x1, y1, width);
		p.square.addMouseListener(p);
		p.square.addMouseMotionListener(p);
		
		p.drawFrame();
	}
	
	private void drawFrame() {
		
		
		JFrame frame1 = new JFrame("Magic square");
		frame1.setLocation(300, 100);
		frame1.setMinimumSize(new Dimension(800, 650));
		
		frame1.getContentPane().add(square);
		
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.pack();
		
		frame1.setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getButton() == 1 && e.getX() >= x1 && e.getX() <= x1 + width && e.getY() >= y1 && e.getY() <= y1 + width) {
			square.repaint();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
