package com.kademika.day10.theory.frame2;

import java.awt.*;

public class Tv extends Device {

    private int diagonal;
    private boolean func3d;

    public Tv() {

    }

    public Tv(long id, String producer, String model, Color color, double price, int diagonal, boolean func3d) {

        super(id, producer, model, color, price);
        this.diagonal = diagonal;
        this.func3d = func3d;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    public boolean isFunc3d() {
        return func3d;
    }

    public void setFunc3d(boolean func3d) {
        this.func3d = func3d;
    }

    @Override
    public String toString() {
        return super.toString() + " " + diagonal + " " + func3d;
    }
}
