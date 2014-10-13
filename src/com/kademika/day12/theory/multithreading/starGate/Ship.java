package com.kademika.day12.theory.multithreading.starGate;

import java.awt.*;

public class Ship {

    public int x;
    public int y;
    public int radius;
    private Color color;

    public Ship(int x, int y, int diameter, Color color) {
        this.x = x;
        this.y = y;
        this.radius = diameter;
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }
}
