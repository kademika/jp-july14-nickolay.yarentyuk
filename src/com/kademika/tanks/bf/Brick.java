package com.kademika.tanks.bf;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Brick extends SimpleBFObject {

	public Brick(int x, int y, Pictures pictures) {
		super(x, y);
		color = new Color(255, 200, 0);
        image = pictures.getImageBrick();
	}
}
