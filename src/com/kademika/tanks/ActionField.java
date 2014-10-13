package com.kademika.tanks;

import java.awt.Graphics;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.*;

import com.kademika.tanks.bf.*;
import com.kademika.tanks.bf.tanks.Action;
import com.kademika.tanks.bf.tanks.BT7;
import com.kademika.tanks.bf.tanks.Bullet;
import com.kademika.tanks.bf.tanks.T34;
import com.kademika.tanks.bf.tanks.Tank;
import com.kademika.tanks.bf.tanks.Tiger;

/**
 * Updated to object oriented style.
 * 
 * @version 3.0
 */
public class ActionField extends JPanel {

    private Pictures pictures;

    private MainFrame frame;

    private boolean gameIs;
    private boolean needToLoadResultPanel;

	private BattleField battleField;
	private Tank defender;
	private Tank aggressor;
//	private Bullet bullet1;
    private Queue<Bullet> bullets;
    private Action tankAction;

    private boolean defenderWon;

    private FileOutputStream fosTracks;

    public ActionField(MainFrame frame) throws Exception {

        pictures = new Pictures();

        this.frame = frame;
    }

    public void initialize(boolean isTankBT7Selected) {
        battleField = new BattleField(pictures);

        defender = new T34(battleField, 128, 512, Direction.UP);
        if (isTankBT7Selected) {
            aggressor = new BT7(battleField, 512, 64, Direction.LEFT);
        } else {
            aggressor = new Tiger(battleField, 128, 64, Direction.LEFT);
        }

//        bullet1 = new Bullet(-100, -100, Direction.NONE);
        bullets = new LinkedBlockingQueue<>();
    }

	public void runTheGame() throws Exception {
//		Action action;

        gameIs = true;
        needToLoadResultPanel = true;
        fosTracks = new FileOutputStream("Tracks.txt");

        aggressor.setEnemy(defender);
        defender.setEnemy(aggressor);

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (gameIs) {
                    try {
                        Thread.sleep(1000 / 60);
                        repaint();
                    } catch (InterruptedException e) {
                        // ignore
                    }
                    repaint();
                }

                if (needToLoadResultPanel) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // ignore
                    }
                    frame.loadResultPanel(defenderWon);
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (gameIs) {
                    tankAction = aggressor.setUp();
                    try {
                        processAction(tankAction, aggressor);
                    } catch (Exception e) { //  !
                        // ignore
                    }
                    writeToFile('A', aggressor.getDirection(), tankAction);
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (gameIs) {
                    tankAction = defender.setUp();
                    try {
                        processAction(tankAction, defender);
                    } catch (Exception e) { //  !
                        // ignore
                    }
                    writeToFile('D', defender.getDirection(), tankAction);
                }
            }
        }).start();

//        while (gameIs) {
//			if (!aggressor.isDestroyed() && !defender.isDestroyed()) {
//                aggressor.setEnemy(defender);
//                action = aggressor.setUp();
//				processAction(action, aggressor);
//                writeToFile('A', aggressor.getDirection(), action);
//			}
//			if (!aggressor.isDestroyed() && !defender.isDestroyed()) {
//                defender.setEnemy(aggressor);
//                action = defender.setUp();
//				processAction(action, defender);
//                writeToFile('D', defender.getDirection(), action);
//			}
//		}

//        if (needToLoadResultPanel) {
//            Thread.sleep(1000);
//            frame.loadResultPanel(defenderWon);
//        }
    }

//    private void loadResultPanel() throws InterruptedException {
//        if (needToLoadResultPanel) {
//            Thread.sleep(1000);
//            frame.loadResultPanel(defenderWon);
//        }
//    }

    public void replayTheGame() throws Exception {
        String data = readFile();
        String current;
        Tank tank;
        Direction direction;
        Action action;

        for (int i = 1; i < data.length(); i += 4) {
            current = data.substring(i, i + 3);

            if (current.charAt(0) == 'A') {
                tank = aggressor;
            } else /*if (current.charAt(0) == 'D') */{
                tank = defender;
            }

            direction = Direction.NONE;
            if (current.charAt(1) == 'U') {
                direction = Direction.UP;
            } else if (current.charAt(1) == 'D') {
                direction = Direction.DOWN;
            } else if (current.charAt(1) == 'L') {
                direction = Direction.LEFT;
            } else if (current.charAt(1) == 'R') {
                direction = Direction.RIGHT;
            }
            tank.setDirection(direction);

            action = Action.NONE;
            if (current.charAt(2) == 'M') {
                action = Action.MOVE;
            } else if (current.charAt(2) == 'F') {
                action = Action.FIRE;
            }

            processAction(action, tank);

            System.out.println(current);
        }
    }

    private void writeToFile(char tankSymbol, Direction direction, Action action) {
        try {
            fosTracks.write((" " + tankSymbol + direction.toString().charAt(0) + action.toString().charAt(0)).getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFile() {
        StringBuilder sb = new StringBuilder();

        try (FileInputStream fisTracks = new FileInputStream("Tracks.txt")) {
            int i;
            while ((i = fisTracks.read()) != -1) {
                sb.append((char) i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

	private void processAction(Action a, final Tank tank) throws Exception {
		if (a == Action.MOVE) {
			processTurn(/*tank*/);
			processMove(tank);
		} else if (a == Action.FIRE) {
			processTurn(/*tank*/);
//			new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
                        processFire(tank.fire());
//                    } catch (Exception e) {
//                        // ignore
//                    }
//                }
//            }).start();
		}
	}

	private void processTurn(/*Tank tank*/) {
//		repaint();
	}

	private void processMove(Tank tank) throws Exception {
		processTurn(/*tank*/);
		Direction direction = tank.getDirection();
		int step = 1;
		
		for (int i = 0; i < tank.getMovePath(); i++) {
			int covered = 0;

			String tankQuadrant = getQuadrant(tank.getX(), tank.getY());
			int v = Integer.parseInt(tankQuadrant.split("_")[0]);
			int h = Integer.parseInt(tankQuadrant.split("_")[1]);

			// check limits x: 0, 513; y: 0, 513
			if ((direction == Direction.UP && tank.getY() == 0) || (direction == Direction.DOWN && tank.getY() >= 512)
					|| (direction == Direction.LEFT && tank.getX() == 0) || (direction == Direction.RIGHT && tank.getX() >= 512)) {
				System.out.println("[illegal move] direction: " + direction
						+ " tankX: " + tank.getX() + ", tankY: " + tank.getY());
				return;
			}
			
			// check next quadrant before move
			if (direction == Direction.UP) {
				v--;
			} else if (direction == Direction.DOWN) {
				v++;
			} else if (direction == Direction.RIGHT) {
				h++;
			} else if (direction == Direction.LEFT) {
				h--;
			}
			BFObject bfobject = battleField.scanQuadrant(v, h);
			if (!(bfobject instanceof Blank) && !bfobject.isDestroyed() && !(bfobject instanceof Water)) {
				System.out.println("[illegal move] direction: " + direction
						+ " tankX: " + tank.getX() + ", tankY: " + tank.getY());
				return;
			}
	

			// process move
	
			while (covered < 64) {
				if (direction == Direction.UP) {
					tank.updateY(-step);
	//				System.out.println("[move up] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
				} else if (direction == Direction.DOWN) {
					tank.updateY(step);
	//				System.out.println("[move down] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
				} else if (direction == Direction.LEFT) {
					tank.updateX(-step);
	//				System.out.println("[move left] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
				} else {
					tank.updateX(step);
	//				System.out.println("[move right] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
				}
				covered += step;
	
//				repaint();
				Thread.sleep(tank.getSpeed());
			}
		}
	}

	private void processFire(final Bullet bullet) throws Exception {
		new Thread(new Runnable() {

            @Override
            public void run() {
                bullets.add(bullet);
                int step = 1;
                while ((bullet.getX() > -14 && bullet.getX() < 590)
                        && (bullet.getY() > -14 && bullet.getY() < 590)) {
                    if (bullet.getDirection() == Direction.UP) {
                        bullet.updateY(-step);
                    } else if (bullet.getDirection() == Direction.DOWN) {
                        bullet.updateY(step);
                    } else if (bullet.getDirection() == Direction.LEFT) {
                        bullet.updateX(-step);
                    } else {
                        bullet.updateX(step);
                    }
                    try {
                        Thread.sleep(bullet.getSpeed());
                    } catch (InterruptedException e) {
                        // ignore
                    }
                    if (processInterception(bullet)) {
//				bullet.destroy();
                        bullets.remove(bullet);
                        break;
                    }
//			repaint();
//			if (bullet.isDestroyed()) {
//				break;
//			}
                }
            }
        }).start();

	}

	private boolean processInterception(Bullet bullet) {
		String coordinates = getQuadrant(bullet.getX(), bullet.getY());
		int y = Integer.parseInt(coordinates.split("_")[0]);
		int x = Integer.parseInt(coordinates.split("_")[1]);

		if (y >= 0 && y < 9 && x >= 0 && x < 9) {
			BFObject bfObject = battleField.scanQuadrant(y, x);
			if (!bfObject.isDestroyed() && !(bfObject instanceof Blank) && !(bfObject instanceof Water)) {
				if (!(bfObject instanceof Rock)) {
					battleField.destroyObject(y, x);
                    if (bfObject instanceof Eagle) {
                        defenderWon = false;
                        gameIs = false;
                    }
				}
				return true;
			}

			// check aggressor
			if (!aggressor.isDestroyed() && checkInterception(getQuadrant(aggressor.getX(), aggressor.getY()), coordinates)) {
				aggressor.destroy();
                defenderWon = true;
                gameIs = false;
				return true;
			}

			// check aggressor
			if (!defender.isDestroyed() && checkInterception(getQuadrant(defender.getX(), defender.getY()), coordinates)) {
				defender.destroy();
                defenderWon = false;
                gameIs = false;
				return true;
			}
		}
		return false;
	}

//    private void processFire(Bullet bullet1) throws Exception {
//        this.bullet1 = bullet1;
//        int step = 1;
//        while ((bullet1.getX() > -14 && bullet1.getX() < 590)
//                && (bullet1.getY() > -14 && bullet1.getY() < 590)) {
//            if (bullet1.getDirection() == Direction.UP) {
//                bullet1.updateY(-step);
//            } else if (bullet1.getDirection() == Direction.DOWN) {
//                bullet1.updateY(step);
//            } else if (bullet1.getDirection() == Direction.LEFT) {
//                bullet1.updateX(-step);
//            } else {
//                bullet1.updateX(step);
//            }
//            if (processInterception()) {
//                bullet1.destroy();
//            }
////			repaint();
//            Thread.sleep(bullet1.getSpeed());
//            if (bullet1.isDestroyed()) {
//                break;
//            }
//        }
//    }
//
//    private boolean processInterception() {
//        String coordinates = getQuadrant(bullet1.getX(), bullet1.getY());
//        int y = Integer.parseInt(coordinates.split("_")[0]);
//        int x = Integer.parseInt(coordinates.split("_")[1]);
//
//        if (y >= 0 && y < 9 && x >= 0 && x < 9) {
//            BFObject bfObject = battleField.scanQuadrant(y, x);
//            if (!bfObject.isDestroyed() && !(bfObject instanceof Blank) && !(bfObject instanceof Water)) {
//                if (!(bfObject instanceof Rock)) {
//                    battleField.destroyObject(y, x);
//                    if (bfObject instanceof Eagle) {
//                        defenderWon = false;
//                        gameIs = false;
//                    }
//                }
//                return true;
//            }
//
//            // check aggressor
//            if (!aggressor.isDestroyed() && checkInterception(getQuadrant(aggressor.getX(), aggressor.getY()), coordinates)) {
//                aggressor.destroy();
//                defenderWon = true;
//                gameIs = false;
//                return true;
//            }
//
//            // check aggressor
//            if (!defender.isDestroyed() && checkInterception(getQuadrant(defender.getX(), defender.getY()), coordinates)) {
//                defender.destroy();
//                defenderWon = false;
//                gameIs = false;
//                return true;
//            }
//        }
//        return false;
//    }

	private boolean checkInterception(String object, String quadrant) {
		int oy = Integer.parseInt(object.split("_")[0]);
		int ox = Integer.parseInt(object.split("_")[1]);

		int qy = Integer.parseInt(quadrant.split("_")[0]);
		int qx = Integer.parseInt(quadrant.split("_")[1]);

		if (oy >= 0 && oy < 9 && ox >= 0 && ox < 9) {
			if (oy == qy && ox == qx) {
				return true;
			}
		}
		return false;
	}

	public String getQuadrant(int x, int y) {
		// input data should be correct
		return y / 64 + "_" + x / 64;
	}

    public void StopGame() {
        needToLoadResultPanel = false;
        gameIs = false;
    }

	@Override
	protected void paintComponent(Graphics g) {

		battleField.drawExceptWater(g);
		
		defender.draw(g);
		aggressor.draw(g);
		
		battleField.drawWater(g);
		
//		bullet1.draw(g);
        for (Bullet bullet : bullets) {
            bullet.draw(g);
        }
    }
}