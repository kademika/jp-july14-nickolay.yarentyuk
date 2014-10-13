package com.kademika.tanks.bf;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Water extends SimpleBFObject {
	
	public Water(int x, int y, Pictures pictures) {
		super(x, y);
		color = new Color(0, 200, 255);
        image = pictures.getImageWater();
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2D = (Graphics2D) g;
		Composite org = g2D.getComposite();
		Composite translucent = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
		g2D.setComposite(translucent);
		g.drawImage(image, getX(), getY(), getX() + 64, getY() + 64, getX(), getY(), getX() + 64, getY() + 64, new ImageObserver() {

			@Override
			public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,
					int arg4, int arg5) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		g2D.setComposite(org);
	}
}
