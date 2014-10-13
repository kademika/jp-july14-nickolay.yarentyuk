package com.kademika.day10.theory.frame2;

import com.kademika.day10.theory.frame22_28.InitService;
import com.kademika.day10.theory.frame22_28.Service;

import java.awt.*;

@Service
public class Phone extends Device {

    private int totalSim;
    private String os;

    public Phone() {

    }

    public Phone(long id, String producer, String model, Color color, double price, int totalSim, String os) {

        super(id, producer, model, color, price);
        this.totalSim = totalSim;
        this.os = os;
    }

    public int getTotalSim() {
        return totalSim;
    }

    public void setTotalSim(int totalSim) {
        this.totalSim = totalSim;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return super.toString() + " " + totalSim + " " + os;
    }

    @InitService
    private void printText1() {
        System.out.println("Text 1.");
    }

    @InitService
    private void printText2() {
        System.out.println("Text 2.");
    }
}
