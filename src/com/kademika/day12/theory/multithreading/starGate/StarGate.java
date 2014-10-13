package com.kademika.day12.theory.multithreading.starGate;

import javax.swing.*;
import java.awt.*;

public class StarGate extends JPanel{

    public static void main(String[] args) {
        new StarGate();
    }

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private Ship ship;
    private Gates gates;

    public StarGate() {
        JFrame frame = new JFrame("StarGate");
        frame.setLocation(450, 150);
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

        ship = new Ship(10, 170, 5, Color.GREEN);
        gates = new Gates();

        turnOnGates();

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    moveShip();
                } catch (InterruptedException e) {
                    // ignore
                }
            }
        }).start();

        while (true) {
            repaint();
            sleep(1000 / 60);
        }
    }

    private void turnOnGates() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    synchronized (gates) {
                        System.out.println("Gates: Waiting for the ship.");
                        gates.wait();
                    }
                    while (!gates.isOpen()) {
                        animateGates();
                    }
                    synchronized (ship) {
                        ship.notify();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void animateGates() {
        if (!gates.isOpen()) {
            if (gates.topY > gates.topY) {
                gates.topY--;
            }
            if (gates.bottomY < gates.bottomY) {
                gates.bottomY++;
            }
            if (gates.topY == gates.openTopY) {
                gates.bottomY = gates.openBottomY;
                gates.setOpen(true);
                System.out.println("Ship: Gates opened, please come in.");

                synchronized (ship) {
                    ship.notify();
                }
            } else {
                sleep(15);
            }
        }
    }

    private boolean isShipInRange() {
        return ship.x > (gates.topX - 18) && ship.x < gates.topX;
    }

    private void moveShip() throws InterruptedException {
        while (ship.x <= WIDTH - ship.radius * 5) {
            if (!gates.isOpen() && isShipInRange()) {
                synchronized (gates) {
                    gates.notify();
                    System.out.print("Ship: Asked pormissions");
                }
                synchronized (ship) {
                    System.out.println(" and waiting gates to open.");
                    ship.wait();
                }
            }

            ship.x++;
            sleep(5);
        }
        System.out.println("Ship: Back home, waiting for other tasks.");
    }

    private void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            // ignore
        }
    }
}
