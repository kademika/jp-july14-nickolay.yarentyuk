package com.kademika.tanks.bf.tanks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import com.kademika.tanks.Direction;
import com.kademika.tanks.bf.BattleField;

public abstract class AbstractTank implements Tank {
	
	private int speed = 10;
	protected int movePath = 1;

	// 1 - up, 2 - down, 3 - left, 4 - right
	private Direction direction;

	// current position on BF
	protected int x;
	protected int y;
	
	private boolean destroyed;
	
	protected BattleField bf;
	
	protected Color tankColor;
	protected Color towerColor;
	
	protected Image[] images;
	
	public AbstractTank(BattleField bf) {
		this(bf, 128, 512, Direction.UP);
	}
	
	public AbstractTank(BattleField bf, int x, int y, Direction direction) {
		this.bf = bf;
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.destroyed = false;
	}

	public void turn(Direction direction) {
		this.direction = direction;
	}

	public void move() {
		
	}
	
	public Bullet fire() {
		int bulletX = -100;
		int bulletY = -100;
		if (direction == Direction.UP) {
			bulletX = x + 25;
			bulletY = y - 13;
		} else if (direction == Direction.DOWN) {
			bulletX = x + 25;
			bulletY = y + 63;
		} else if (direction == Direction.LEFT) {
			bulletX = x - 13;
			bulletY = y + 25;
		} else if (direction == Direction.RIGHT) {
			bulletX = x + 63;
			bulletY = y + 25;
		}
		return new Bullet(bulletX, bulletY, direction);
	}
	
	public void draw(Graphics g) {
		if (!destroyed) {
//			g.drawImage(images[getDirection().getId()], getX(), getY(),
//					new ImageObserver() {
//						
//						@Override
//						public boolean imageUpdate(Image img, int infoflags, int x, int y,
//								int width, int height) {
//							// TODO Auto-generated method stub
//							return false;
//						}
//					});
			
			g.setColor(tankColor);
			g.fillRect(this.getX(), this.getY(), 64, 64);
	
			g.setColor(towerColor);
			if (this.getDirection() == Direction.UP) {
				g.fillRect(this.getX() + 20, this.getY(), 24, 34);
			} else if (this.getDirection() == Direction.DOWN) {
				g.fillRect(this.getX() + 20, this.getY() + 30, 24, 34);
			} else if (this.getDirection() == Direction.LEFT) {
				g.fillRect(this.getX(), this.getY() + 20, 34, 24);
			} else {
				g.fillRect(this.getX() + 30, this.getY() + 20, 34, 24);
			}
		}
	}
	
	@Override
	public boolean isDestroyed() {
		return destroyed;
	}

	public void destroy() {
		destroyed = true;
	}
	
	public boolean moveToQuadrant(int v, int h) throws Exception {
		int x = v * 64;
		int y = h * 64;
		
		if (this.x > x) {
			turn(Direction.LEFT);
		} else if (this.x < x) {
			turn(Direction.RIGHT);
		}; if (this.y > y) {
			turn(Direction.UP);
		} else if (this.y < y) {
			turn(Direction.DOWN);
		} else {
			return true;
		}
		return false;
	}
	
	public void moveRandom() throws Exception {
		Random r = new Random();
		int i = r.nextInt(4);
		
		if (i == 0) {
			turn(Direction.UP);
		} else if (i == 1) {
			turn(Direction.DOWN); 
		} else if (i == 2) {
			turn(Direction.LEFT); 
		} else {
			turn(Direction.RIGHT);
		}
	}

	public void clean() throws Exception {
	}

	public void updateX(int x) {
		this.x += x;
	}

	public void updateY(int y) {
		this.y += y;
	}
	
//	protected boolean isOpenLine(int v1, int h1, int v2, int h2) {
//		for (int i = h1; i <= h2; i++) {
//			for (int j = v1; j <= v2; j++) {
//				if (bf.scanQuadrant(i, j) instanceof Brick || bf.scanQuadrant(i, j) instanceof Rock) {
//					return false;
//				}
//			}
//		}
//		return true;
//	}
	
//	protected char checkWay(int v, int h) {
//		int x = this.x / 64;
//		int y = this.y / 64;
//		
//		if (v < x) {
//			for (int i = x - 1; i >= v; i--) {
//				if (bf.scanQuadrant(y, i) instanceof Brick) {
//					return 'B';
//				} else if (bf.scanQuadrant(y, i) instanceof Rock) {
//					return 'R';
//				} else if (bf.scanQuadrant(y, i) instanceof Eagle) {
//					return 'E';
//				}
//			}
//		} else if (v > x) {
//			for (int i = x + 1; i <= v; i++) {
//				if (bf.scanQuadrant(y, i) instanceof Brick) {
//					return 'B';
//				} else if (bf.scanQuadrant(y, i) instanceof Rock) {
//					return 'R';
//				} else if (bf.scanQuadrant(y, i) instanceof Eagle) {
//					return 'E';
//				}
//			}
//		} else if (h < y) {
//			for (int i = y - 1; i >= h; i--) {
//				if (bf.scanQuadrant(i, x) instanceof Brick) {
//					return 'B';
//				} else if (bf.scanQuadrant(i, x) instanceof Rock) {
//					return 'R';
//				} else if (bf.scanQuadrant(i, x) instanceof Eagle) {
//					return 'E';
//				}
//			}
//		} else {
//			for (int i = y + 1; i <= h; i++) {
//				if (bf.scanQuadrant(i, x) instanceof Brick) {
//					return 'B';
//				} else if (bf.scanQuadrant(i, x) instanceof Rock) {
//					return 'R';
//				} else if (bf.scanQuadrant(i, x) instanceof Eagle) {
//					return 'E';
//				}
//			}
//		}
//		
//		return  ' ';
//	}
	
//	protected char nextObject(Direction direction) {
//		int x = this.x / 64;
//		int y = this.y / 64;
//		
//		if (direction == Direction.LEFT) {
//			
//		} else if (direction == Direction.RIGHT) {
//			
//		} else if (direction == Direction.UP) {
//			
//		} else if (direction == Direction.DOWN) {
//			
//		}
//		
//		return ' ';
//	}

	public Direction getDirection() {
		return direction;
	}

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getSpeed() {
		return speed / movePath;
	}
	
	@Override
	public int getMovePath() {
		return movePath;
	}
}
