package com.kademika.day12.theory.multithreading.drawBridge;

import java.awt.*;

public class Car {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Car(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void addX() {
        x++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }
}
