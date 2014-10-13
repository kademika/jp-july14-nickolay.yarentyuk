package com.kademika.day12.theory.multithreading.balls;

import java.awt.*;

public class Ball extends Thread {

    private int width;
    private int x;
    private int y;
    private int diameter;
    private Color color;
    private int speed;
    private  boolean directionRight;

    public Ball(int width, int y, Color color, int speed) {
        this.width = width;
        x = 0;
        this.y = y;
        diameter = 10;
        this.color = color;
        this.speed = speed;
        directionRight = true;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (directionRight) {
                    if (x + diameter <= width - 20) {
                        x++;
                    } else {
                        x--;
                        directionRight = false;
                    }
                } else {
                    if (x >= 0) {
                        x--;
                    } else {
                        x++;
                        directionRight = true;
                    }
                }
                Thread.sleep(speed);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public int getY() {
        return y;
    }

    public int getDiameter() {
        return diameter;
    }

    public Color getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }
}
