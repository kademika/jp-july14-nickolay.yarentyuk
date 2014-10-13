package com.kademika.tanks.bf.tanks;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import sun.print.resources.serviceui;

import com.kademika.tanks.Direction;
import com.kademika.tanks.bf.BattleField;
import com.kademika.tanks.bf.Brick;
import com.kademika.tanks.bf.Eagle;
import com.kademika.tanks.bf.Rock;

public class BT7 extends AbstractTank {
	
//	private int tankX;
//	private int tankY;
	
//	private int xEagle = -1;
//	private int yEagle = -1;
	
	private StrategyPoint[][] strategy;
	
	public BT7(BattleField bf) {
		super(bf);
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		movePath = 2;
		
//		setImages();
//		setEagleCoordinates();
//		makeTheStrategy();
	}
	
	public BT7(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction);
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		movePath = 2;
//		setImages();
//		setEagleCoordinates();
//		makeTheStrategy();
	}
	
	private void setImages() {
//		images = new Image[4];
//		try {
//			images[0] = ImageIO.read(new File("BT7 - Down.png").getAbsoluteFile());
//			images[1] = ImageIO.read(new File("BT7 - Up.png").getAbsoluteFile());
//			images[2] = ImageIO.read(new File("BT7 - Right.png").getAbsoluteFile());
//			images[3] = ImageIO.read(new File("BT7 - Left.png").getAbsoluteFile());
//		} catch (IOException e) {
//			throw new IllegalStateException("Can't find tank images.");
//		}
	}
	
//	private void setEagleCoordinates() {	//	Eagle coordinates
//		for (int i = 0; i < 9; i++) {
//			for (int j = 0; j < 9; j++) {
//				if (bf.scanQuadrant(j, i) instanceof Eagle) {
//					xEagle = i;
//					yEagle = j;
//					return;
//				}
//			}
//		}
//	}
	
	@Override
	public void setEnemy(Tank enemy) {
		
	};
	
	@Override
	public Action setUp() {

		return makeTheStrategy();
	}
	
	private Action makeTheStrategy() {
		int tankX = x / 64;
		int tankY = y / 64;
		StrategyPoint goalQuadrant;
		
		strategy = new StrategyPoint[9][9];
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (bf.scanQuadrant(i, j) instanceof Brick) {
					strategy[i][j] = new StrategyPoint(j, i, 'B');
				} else if (bf.scanQuadrant(i, j) instanceof Eagle) {
					strategy[i][j] = new StrategyPoint(j, i, 'E');
//					xEagle = j;
//					yEagle = i;
				} else if (bf.scanQuadrant(i, j) instanceof Rock) {
					strategy[i][j] = new StrategyPoint(j, i, 'R');
				} else {
					strategy[i][j] = new StrategyPoint(j, i, ' ');
				}
			}
		}
		
		strategy[tankY][tankX].setObj('T');
		strategy[tankY][tankX].setAccessLevel(0);
		strategy[tankY][tankX].setPointCount(0);
		
		
		int id = 1;
		goalQuadrant = scanAroundQuadrant(tankX, tankY, 0, 0);
		while (goalQuadrant == null) {
			goalQuadrant = scanAllQuadrants(id ++);
		}
		
//		printStrategy();
		
		if (goalQuadrant.getAccessLevel() == 1) {
			if (goalQuadrant.getX() == tankX) {
				if (goalQuadrant.getY() < tankY) {
					turn(Direction.UP);
				} else {
					turn(Direction.DOWN);
				}
				
			} else {
				if (goalQuadrant.getX() < tankX) {
					turn(Direction.LEFT);
				} else {
					turn(Direction.RIGHT);
				}
			}
			
			return Action.FIRE;
		
		} else {
			turn(findNextQuadrant(strategy[tankX][tankY], goalQuadrant));
			
			if (checkNextQuadrant(tankY, tankX) == 'B') {
				return Action.FIRE;
			} else {
				return Action.MOVE;
			}
		}
		
//		return Action.MOVE;
	}
	
	private Direction findNextQuadrant(StrategyPoint tankQuadrant, StrategyPoint goalQuadrant) {
		StrategyPoint /*prevQuadrant, */currentQuadrant, nextQuadrant;
		
		int minAccessLevel;
		int minPointCount;
		int qX;
		int qY;
		
		currentQuadrant = goalQuadrant;
		nextQuadrant = goalQuadrant;
		qX = 1000000;
		qY = 1000000;
		
		while (nextQuadrant.getAccessLevel() != 0) {
			currentQuadrant = nextQuadrant;
			minAccessLevel = goalQuadrant.getAccessLevel();
			minPointCount = goalQuadrant.getPointCount();
			qX = currentQuadrant.getX();
			qY = currentQuadrant.getY();
			
			if (qX != 0) {
				if (strategy[qY][qX - 1].getAccessLevel() < minAccessLevel) {
					nextQuadrant = strategy[qY][qX - 1];
					minAccessLevel = strategy[qY][qX - 1].getAccessLevel();
					minPointCount = strategy[qY][qX - 1].getPointCount();
					
				} else if (strategy[qY][qX - 1].getAccessLevel() == minAccessLevel) {
					if (strategy[qY][qX - 1].getPointCount() < minPointCount) {
						nextQuadrant = strategy[qY][qX - 1];
						minAccessLevel = strategy[qY][qX - 1].getAccessLevel();
						minPointCount = strategy[qY][qX - 1].getPointCount();
					}
				}
			}
			
			if (qX != 8) {
				if (strategy[qY][qX + 1].getAccessLevel() < minAccessLevel) {
					nextQuadrant = strategy[qY][qX + 1];
					minAccessLevel = strategy[qY][qX + 1].getAccessLevel();
					minPointCount = strategy[qY][qX + 1].getPointCount();
					
				} else if (strategy[qY][qX + 1].getAccessLevel() == minAccessLevel) {
					if (strategy[qY][qX + 1].getPointCount() < minPointCount) {
						nextQuadrant = strategy[qY][qX + 1];
						minAccessLevel = strategy[qY][qX + 1].getAccessLevel();
						minPointCount = strategy[qY][qX + 1].getPointCount();
					}
				}
			}
			
			if (qY != 0) {
				if (strategy[qY - 1][qX].getAccessLevel() < minAccessLevel) {
					nextQuadrant = strategy[qY - 1][qX];
					minAccessLevel = strategy[qY - 1][qX].getAccessLevel();
					minPointCount = strategy[qY - 1][qX].getPointCount();
					
				} else if (strategy[qY - 1][qX].getAccessLevel() == minAccessLevel) {
					if (strategy[qY - 1][qX].getPointCount() < minPointCount) {
						nextQuadrant = strategy[qY - 1][qX];
						minAccessLevel = strategy[qY - 1][qX].getAccessLevel();
						minPointCount = strategy[qY - 1][qX].getPointCount();
					}
				}
			}
			
			if (qY != 8) {
				if (strategy[qY + 1][qX].getAccessLevel() < minAccessLevel) {
					nextQuadrant = strategy[qY + 1][qX];
					minAccessLevel = strategy[qY + 1][qX].getAccessLevel();
					minPointCount = strategy[qY + 1][qX].getPointCount();
					
				} else if (strategy[qY + 1][qX].getAccessLevel() == minAccessLevel) {
					if (strategy[qY + 1][qX].getPointCount() < minPointCount) {
						nextQuadrant = strategy[qY + 1][qX];
						minAccessLevel = strategy[qY + 1][qX].getAccessLevel();
						minPointCount = strategy[qY + 1][qX].getPointCount();
					}
				}
			}
		}
		
		if (currentQuadrant.getX() == nextQuadrant.getX()) {
			if (currentQuadrant.getY() < nextQuadrant.getY()) {
				return Direction.UP;
			} else {
				return Direction.DOWN;
			}
		} else {
			if (currentQuadrant.getX() < nextQuadrant.getX()) {
				return Direction.LEFT;
			} else {
				return Direction.RIGHT;
			}
		}
	}
	
	private char checkNextQuadrant(int tankY, int tankX) {
		if (super.getDirection() == Direction.LEFT) {
			return strategy[tankY][tankX - 1].getObj();
		} else if (super.getDirection() == Direction.RIGHT) {
			return strategy[tankY][tankX + 1].getObj();
		} else if (super.getDirection() == Direction.UP) {
			return strategy[tankY - 1][tankX].getObj();
		} else {
			return strategy[tankY + 1][tankX].getObj();
		}
	}
	
	private StrategyPoint scanAllQuadrants(int accessLevel) {
		StrategyPoint quadrant;
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (strategy[i][j].getAccessLevel() == accessLevel) {
					quadrant = scanAroundQuadrant(j, i, accessLevel, 1);
					if (quadrant != null && quadrant.getObj() == 'E') {
						return quadrant;
					}
				}
			}
		}
		
		return null;
	}
	
	private StrategyPoint scanAroundQuadrant(int qX, int qY, int accessLevel, int pointCount) {
		StrategyPoint confirm;
		
		if (qX != 0) {
			confirm = scanLine(qX, qY, Direction.LEFT, strategy[qY][qX].getAccessLevel(), strategy[qY][qX].getPointCount());
			if (confirm != null) {
				return confirm;
			}
		}
		
		if (qX != 8) {
			confirm = scanLine(qX, qY, Direction.RIGHT, strategy[qY][qX].getAccessLevel(), strategy[qY][qX].getPointCount());
			if (confirm != null) {
				return confirm;
			}
		}
		
		if (qY != 0) {
			confirm = scanLine(qX, qY, Direction.UP, strategy[qY][qX].getAccessLevel(), strategy[qY][qX].getPointCount());
			if (confirm != null) {
				return confirm;
			}
		}
		
		if (qY != 8) {
			confirm = scanLine(qX, qY, Direction.DOWN, strategy[qY][qX].getAccessLevel(), strategy[qY][qX].getPointCount());
			if (confirm != null) {
				return confirm;
			}
		}
		
		return null;
	}
	
	private StrategyPoint scanLine(int qX, int qY, Direction dir, int accessLevel, int pointCount) {
		accessLevel ++;
		
		if (dir == Direction.LEFT) {
			for (int i = qX - 1; i >= 0; i--) {
				if (strategy[qY][i].getAccessLevel() != 1000000) {
					return null;
				} else {
					strategy[qY][i].setPointCount(++ pointCount);
					if (strategy[qY][i].getObj() == ' ') {
						strategy[qY][i].setAccessLevel(accessLevel);
					} else if (strategy[qY][i].getObj() == 'B') {
						accessLevel ++;
						strategy[qY][i].setAccessLevel(accessLevel);
					} else if (strategy[qY][i].getObj() == 'E') {
						strategy[qY][i].setAccessLevel(accessLevel);
						return strategy[qY][i];
					} else {
						return null;
					}
				}
			}
			
		} else if (dir == Direction.RIGHT) {
			for (int i = qX + 1; i < 9; i++) {
				
				if (strategy[qY][i].getAccessLevel() != 1000000) {
					return null;
				} else {
					strategy[qY][i].setPointCount(++ pointCount);
					if (strategy[qY][i].getObj() == ' ') {
						strategy[qY][i].setAccessLevel(accessLevel);
					} else if (strategy[qY][i].getObj() == 'B') {
						accessLevel ++;
						strategy[qY][i].setAccessLevel(accessLevel);
					} else if (strategy[qY][i].getObj() == 'E') {
						strategy[qY][i].setAccessLevel(accessLevel);
						return strategy[qY][i];
					} else {
						return null;
					}
				}
			}
			
		} else if (dir == Direction.UP) {
			for (int i = qY - 1; i >= 0; i--) {
				if (strategy[i][qX].getAccessLevel() != 1000000) {
					return null;
				} else {
					strategy[i][qX].setPointCount(++ pointCount);
					if (strategy[i][qX].getObj() == ' ') {
						strategy[i][qX].setAccessLevel(accessLevel);
					} else if (strategy[i][qX].getObj() == 'B') {
						accessLevel ++;
						strategy[i][qX].setAccessLevel(accessLevel);
					} else if (strategy[i][qX].getObj() == 'E') {
						strategy[i][qX].setAccessLevel(accessLevel);
						return strategy[i][qX];
					} else {
						return null;
					}
				}
			}
			
		} else if (dir == Direction.DOWN) {
			for (int i = qY + 1; i < 9; i++) {
				if (strategy[i][qX].getAccessLevel() != 1000000) {
					return null;
				} else {
					strategy[i][qX].setPointCount(++ pointCount);
					if (strategy[i][qX].getObj() == ' ') {
						strategy[i][qX].setAccessLevel(accessLevel);
					} else if (strategy[i][qX].getObj() == 'B') {
						accessLevel ++;
						strategy[i][qX].setAccessLevel(accessLevel);
					} else if (strategy[i][qX].getObj() == 'E') {
						strategy[i][qX].setAccessLevel(accessLevel);
						return strategy[i][qX];
					} else {
						return null;
					}
				}
			}
		}
		
		return null;
	}
	
	private void printStrategy() {
		System.out.println();
		for (int i = 0; i < 9; i++) {
			System.out.println();
			for (int j = 0; j < 9; j++) {
				System.out.print(" " + strategy[i][j].getObj());
			}
		}
		
		System.out.println();
		for (int i = 0; i < 9; i++) {
			System.out.println();
			for (int j = 0; j < 9; j++) {
				System.out.print(" " + strategy[i][j].getAccessLevel());
			}
		}
		
		System.out.println();
		for (int i = 0; i < 9; i++) {
			System.out.println();
			for (int j = 0; j < 9; j++) {
				System.out.print(" " + strategy[i][j].getPointCount());
			}
		}
		
		System.out.println();
		System.out.println();
//		System.out.print("Eagle (" + xEagle + ", ");
//		System.out.println(yEagle + ")");
		
//		this.destroy();
	}
	
//	private void makeTheStrategy() {
//		cX = x / 64;
//		cY = y / 64;
//		
//		strategy = new int[9][9];
//		
//		for (int i = 0; i < 9; i++) {
//			for (int j = 0; j < 9; j++) {
//				if (bf.scanQuadrant(i, j) instanceof Brick) {
//					strategy[i][j] = -3;
//				} else if (bf.scanQuadrant(i, j) instanceof Eagle) {
//					strategy[i][j] = -2;
//				} else if (bf.scanQuadrant(i, j) instanceof Rock) {
//					strategy[i][j] = -1;
//				} else {
//					strategy[i][j] = -4;
//				}
//			}
//		}
//		
//		scanAroundQuadrant(cX, cY);
//		
//		printStrategy();
//	}
//	
//	private void scanAroundQuadrant(int qX, int qY) {
//		if (qX != 0) {
//			scanLine(qX, qY, Direction.LEFT, 0);
//		} if (qX != 8) {
//			scanLine(qX, qY, Direction.RIGHT, 0);
//		} if (qY != 0) {
//			scanLine(qX, qY, Direction.UP, 0);
//		} if (qY != 8) {
//			scanLine(qX, qY, Direction.DOWN, 0);
//		}
//	}
//	
//	private void scanLine(int qX, int qY, Direction dir, int measure) {
//		int currentMeasure = measure + 1;
//		
//		if (dir == Direction.LEFT) {
//			for (int i = qX - 1; i >= 0; i--) {
//				if (strategy[qY][i] == -4) {
//					strategy[qY][i] = currentMeasure;
//				} else if (strategy[qY][i] == -3) {
//					currentMeasure ++;
//					strategy[qY][i] = currentMeasure;
//				} else {
//					return;
//				}
//			}
//			
//		} else if (dir == Direction.RIGHT) {
//			for (int i = qX + 1; i < 9; i++) {
//				if (strategy[qY][i] == -4) {
//					strategy[qY][i] = currentMeasure;
//				} else if (strategy[qY][i] == -3) {
//					currentMeasure ++;
//					strategy[qY][i] = currentMeasure;
//				} else {
//					return;
//				}
//			}
//			
//		} else if (dir == Direction.UP) {
//			for (int i = qY - 1; i >= 0; i--) {
//				if (strategy[i][qX] == -4) {
//					strategy[i][qX] = currentMeasure;
//				} else if (strategy[i][qX] == -3) {
//					currentMeasure ++;
//					strategy[i][qX] = currentMeasure;
//				} else {
//					return;
//				}
//			}
//			
//		} else {
//			for (int i = qY + 1; i < 9; i++) {
//				if (strategy[i][qX] == -4) {
//					strategy[i][qX] = currentMeasure;
//				} else if (strategy[i][qX] == -3) {
//					currentMeasure ++;
//					strategy[i][qX] = currentMeasure;
//				} else {
//					return;
//				}
//			}
//			
//		}
//	}
//	
//	private void checkTheNeighbors(int qX, int qY, Direction dir) {
//		if (dir == Direction.LEFT && qY != 0) {
//			
//		} else {
//			
//		}
//	}
//	
//	private void printStrategy() {
//		System.out.println();
//		for (int i = 0; i < 9; i++) {
//			System.out.println();
//			for (int j = 0; j < 9; j++) {
//				System.out.print(" " + strategy[i][j]);
//			}
//		}
//		this.destroy();
//	}
	
//	@Override
//	public Action setUp() {
//		if (step >= actoins.length) {
//			step = 0;
//		}
//		if (!(actoins[step] instanceof Action)) {
//			turn((Direction) actoins[step++]);
//		}
//		if (step >= actoins.length) {
//			step = 0;
//			return Action.NONE;
//			
//		}
//		return (Action) actoins[step++];
//	}
}
