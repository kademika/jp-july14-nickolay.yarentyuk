package com.midgardabc.lesson_8Theory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame_8_11 extends JPanel {

	private final static String IMAGE_NAME = "AAA.png";
	private Image image1;
	
	public Frame_8_11() {
		try {
			System.out.println(new File("AAA.png").getAbsolutePath());
			image1 = ImageIO.read(new File("AAA.png"));
		} catch (IOException e) {
			System.err.println("Can't find image:" + IMAGE_NAME);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, 800, 600);
		
		g.setColor(new Color(255, 0, 0));
		g.fillRect(400, 100, 50, 50);
		
		g.setColor(new Color(0, 255, 0));
		g.fill3DRect(400, 200, 50, 50, true);
		
		g.setColor(new Color(0, 0, 255));
		g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 32));
		g.drawString("Hello!!!", 20, 50);
		
		g.drawImage(image1, 100, 100, new ImageObserver() {
			
			@Override
			public boolean imageUpdate(Image arg0, int arg1, int arg2,
					int arg3, int arg4, int arg5) {
				// TODO Auto-generated method stub
				return false;
			}
		});
	}
	
	public static void main(String[] args) {
		JFrame frame1 = new JFrame("Frame_8_11");
		frame1.setLocation(300, 100);
		frame1.setMinimumSize(new Dimension(800, 600));		
		
		frame1.getContentPane().add(new Frame_8_11());
		
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.pack();
		
		frame1.setVisible(true);
	}

}
