package com.kademika.day12.theory.multithreading.drawBridge;

import java.awt.*;

public class River {

    private int x;
    private int y;
    private int width;
    private int depth;
    private Color color;

    public River(int x, int y, int width, int depth, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
        this.color = color;
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

    public int getDepth() {
        return depth;
    }

    public Color getColor() {
        return color;
    }
}
