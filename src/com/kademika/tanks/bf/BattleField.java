package com.kademika.tanks.bf;

import java.util.Random;
import java.awt.Graphics;

//import tanks.bf.BFObject;
//import tanks.bf.Brick;
//import tanks.bf.Drawable;
//import tanks.bf.Eagle;
//import tanks.bf.Rock;
//import tanks.bf.Water;

public class BattleField implements Drawable {
	
	public static final String BRICK = "B";
	public static final String EAGLE = "E";
	public static final String ROCK = "R";
	public static final String WATER = "W";
	
//	private int bfWidth = 592;
//	private int bfHeight = 592;
	
	public static int bfWidth = 592;
	public static int bfHeight = 592;

    private Pictures pictures;

    private String[][] battleFieldTemplate = {
            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", "E", " ", " ", " ", " "}
    };

//    private String[][] battleFieldTemplate = {
//			{"B", "B", "B", "B", "B", "B", "B", "B", "B"},
//			{"B", " ", " ", "R", "B", "W", " ", " ", "B"},
//			{"B", "B", "B", " ", "B", " ", "B", "B", "B"},
//			{"R", "R", "R", " ", " ", " ", "W", "W", "W"},
//			{"R", "R", "R", " ", "B", " ", "W", "W", "W"},
//			{"B", "B", " ", "B", "B", "B", " ", "B", "B"},
//			{"R", "W", " ", " ", " ", " ", " ", "R", "R"},
//			{"B", " ", " ", "B", "R", "R", " ", " ", "B"},
//			{"B", " ", " ", "B", "E", "B", " ", " ", "W"}
//		};
	
//	private String[][] battleFieldTemplate = {
//			{"B", "B", "B", "B", "B", "B", "B", "B", "B"},
//			{"R", "B", "R", "B", " ", "B", " ", " ", " "},
//			{"B", "B", "B", " ", " ", "B", " ", " ", "B"},
//			{"R", "R", "R", " ", " ", "R", "R", " ", "W"},
//			{" ", " ", " ", " ", "R", " ", " ", " ", "B"},
//			{"B", "B", " ", "R", " ", "R", "R", " ", "W"},
//			{"R", " ", " ", " ", " ", " ", " ", "R", "B"},
//			{"B", " ", " ", "B", " ", "R", " ", " ", " "},
//			{" ", " ", " ", "B", "E", "B", "W", "R", "R"}
//		};

//	private String[][] battleFieldTemplate = {
//			{" ", " ", "B", "B", "B", "B", "R", "R", "R"},
//			{" ", " ", "R", "B", " ", "B", "R", " ", " "},
//			{" ", "R", "B", "R", "R", "R", "R", " ", "R"},
//			{" ", "R", "B", "B", "B", "R", "R", " ", "R"},
//			{"W", "R", "W", "R", "B", "W", "W", "W", "R"},
//			{" ", "R", " ", "R", "R", "R", "R", "R", "R"},
//			{" ", "R", " ", " ", " ", "R", " ", "R", "B"},
//			{" ", "R", "B", "R", " ", "R", " ", " ", " "},
//			{" ", " ", " ", "R", "E", "R", "W", "R", "R"}
//		};
	
//	private String[][] battleFieldTemplate = {
//			{" ", " ", " ", " ", " ", " ", " ", " ", " "},
//			{" ", " ", " ", " ", " ", " ", " ", " ", " "},
//			{" ", " ", " ", " ", " ", " ", " ", " ", " "},
//			{"W", "W", "W", "W", "W", "W", "W", "W", "W"},
//			{"W", "W", "W", "W", "W", "W", "W", "W", "W"},
//			{" ", " ", " ", " ", " ", " ", " ", " ", " "},
//			{" ", " ", " ", " ", " ", " ", " ", " ", " "},
//			{" ", " ", " ", " ", " ", " ", " ", " ", " "},
//			{" ", " ", " ", " ", "E", " ", " ", " ", " "}
//		};

//    private String[][] battleFieldTemplate = {
//            {"B", "B", "B", "B", "B", "B", "B", "B", "B"},
//            {" ", "B", "B", "B", "B", "B", "B", "B", " "},
//            {"B", "B", "B", "B", "B", "B", "B", "B", "B"},
//            {"B", "B", "B", "B", "B", "B", "B", "B", "B"},
//            {"B", "B", "B", "B", "B", "B", "B", "B", "B"},
//            {"B", "B", "B", "B", "B", "B", "B", "B", "B"},
//            {"B", "B", "B", "B", "B", "B", "B", "B", "B"},
//            {"B", "B", "B", "B", "B", "B", "B", "B", "B"},
//            {"B", "B", " ", "B", "E", "B", "B", "B", "B"}
//    };

	private BFObject[][] battleField = new BFObject[9][9];

	public BattleField(Pictures pictures) {
		this.pictures = pictures;
        drawBattleField();
	}

	public BattleField(String[][] battleField, Pictures pictures) {
        this.pictures = pictures;
		this.battleFieldTemplate = battleField;
		drawBattleField();
	}
	
	private String getQuadrantXY(int v, int h) {
		return (v - 1) * 64 + "_" + (h - 1) * 64;
	}
	
	private void drawBattleField() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				String coordinates = getQuadrantXY(i + 1, j + 1);
				int separator = coordinates.indexOf("_");
				int y = Integer.parseInt(coordinates
						.substring(0, separator));
				int x = Integer.parseInt(coordinates
						.substring(separator + 1));

				String obj = battleFieldTemplate[i][j];
				BFObject bfObject;
				if (obj.equals(BRICK)) {
					bfObject = new Brick(x, y, pictures);
				} else if (obj.equals(ROCK)) {
					bfObject = new Rock(x, y, pictures);
				} else if (obj.equals(EAGLE)) {
					bfObject = new Eagle(x, y);
				} else if (obj.equals(WATER)) {
					bfObject = new Water(x, y, pictures);
				} else {
					bfObject = new Blank(x, y, pictures);
				}
				battleField[i][j] = bfObject;
			}
		}
	}
	
	@Override
	public void draw(Graphics g) {
		for (int j = 0; j < battleField.length; j++) {
			for (int k = 0; k < battleField.length; k++) {
				battleField[j][k].draw(g);
			}
		}
	}
	
	public void drawExceptWater(Graphics g) {
		for (int j = 0; j < battleField.length; j++) {
			for (int k = 0; k < battleField.length; k++) {
				if (!(battleField[j][k] instanceof Water)) {
					battleField[j][k].draw(g);
				}
			}
		}
	}
	
	public void drawWater(Graphics g) {
		for (int j = 0; j < battleField.length; j++) {
			for (int k = 0; k < battleField.length; k++) {
				if (battleField[j][k] instanceof Water) {
					battleField[j][k].draw(g);
				}
			}
		}
	}
	
	public void destroyObject(int v, int h) {
		battleField[v][h] = new Blank(h * 64, v * 64, pictures);
//		battleField[v][h].destroy();
	}

	public BFObject scanQuadrant(int v, int h) {
		return battleField[v][h];
	}

	public String getAggressorLocation() {
		Random r = new Random();
		int i = r.nextInt(3);
		
		if (i == 0) {
			return "64_0";
		} else if (i == 1) {
			return "64_512";
		} else {
			return "0_256";
		}
		
//		if (i == 0) {
//			return "64_128";
//		} else if (i == 1) {
//			return "64_64";
//		} else {
//			return "64_448";
//		}
		
//		return "64_128";
	}

	public int getBfWidth() {
		return bfWidth;
	}
	
	public int getBfHeight() {
		return bfHeight;
	}
}
