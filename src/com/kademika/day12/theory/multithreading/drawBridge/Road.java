package com.kademika.day12.theory.multithreading.drawBridge;

import java.awt.*;

public class Road {

    private int leftX;
    private int leftY;
    private int leftWidth;
    private int leftHeight;
    private int rightX;
    private int rightY;
    private int rightWidth;
    private int rightHeight;
    private Color color;

    public Road(int leftX, int leftY, int leftWidth, int leftHeight, int rightX, int rightY, int rightWidth,
                int rightHeight, Color color) {
        this.leftX = leftX;
        this.leftY = leftY;
        this.leftWidth = leftWidth;
        this.leftHeight = leftHeight;
        this.rightX = rightX;
        this.rightY = rightY;
        this.rightWidth = rightWidth;
        this.rightHeight = rightHeight;
        this.color = color;
    }

    public int getLeftX() {
        return leftX;
    }

    public int getLeftY() {
        return leftY;
    }

    public int getLeftWidth() {
        return leftWidth;
    }

    public int getLeftHeight() {
        return leftHeight;
    }

    public int getRightX() {
        return rightX;
    }

    public int getRightY() {
        return rightY;
    }

    public int getRightWidth() {
        return rightWidth;
    }

    public int getRightHeight() {
        return rightHeight;
    }

    public Color getColor() {
        return color;
    }
}
