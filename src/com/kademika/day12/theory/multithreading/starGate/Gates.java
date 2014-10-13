package com.kademika.day12.theory.multithreading.starGate;

public class Gates {

    public int topX;
    public int topY;
    public int bottomX;
    public int bottomY;
    public int openTopX;
    public int openTopY;
    public int openBottomX;
    public int openBottomY;
    private boolean open;

    public Gates() {
        open = false;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
