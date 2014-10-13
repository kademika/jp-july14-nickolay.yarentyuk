package com.kademika.tanks.bf;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rock extends SimpleBFObject {
	
	public Rock(int x, int y, Pictures pictures) {
		super(x, y);
		color = new Color(100, 200, 100);
        image = pictures.getImageRock();
	}
}
