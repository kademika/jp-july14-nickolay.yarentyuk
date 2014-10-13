package com.kademika.tanks.bf;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Blank extends SimpleBFObject {
	
	public Blank(int x, int y, Pictures pictures) {
		super(x, y);
		color = new Color(180, 180, 180);
		image = pictures.getImageBlank();
	}
}
