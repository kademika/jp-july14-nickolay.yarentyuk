package com.kademika.day12.theory.multithreading.drawBridge;

import java.awt.*;

public class Bridge {

    private int x;
    private int y;
    private int yMin;
    private int yMax;
    private int width;
    private int height;
    private int zoneBegin;
    private int zoneEnd;
    private boolean open;
    private Color color;

    public Bridge(int x, int yMin, int yMax, int width, int height, Color color) {
        this.x = x;
        this.yMin = yMin;
        this.yMax = yMax;
        y = yMin;
        this.width = width;
        this.height = height;
        zoneBegin = this.x - 10;
        zoneEnd = this.x + this.width + 10;
        open = false;
        this.color = color;
    }

    public void addY() {
        y++;
        if (y == yMax) {
            open = true;
        }
    }

    public void subY() {
        y--;
        open = false;
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

    public boolean isOpen() {
        return open;
    }

    public boolean isClosed() {
        if (y == yMin) {
            return true;
        }
        return false;
    }

    public boolean isZone(int carBegin, int carEnd) {
        if (carBegin >= zoneBegin) {
            if (carBegin <= zoneEnd) {
                return true;
            }
        } else if (carEnd > zoneEnd) {
            return true;
        } else if (carEnd >= zoneBegin) {
            return true;
        }
        return false;
    }

    public Color getColor() {
        return color;
    }
}
