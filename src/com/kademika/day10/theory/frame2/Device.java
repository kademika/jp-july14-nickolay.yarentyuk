package com.kademika.day10.theory.frame2;

import java.awt.*;

public abstract class Device {

    protected long id;
    protected String producer;
    protected String model;
    protected Color color;
    protected double price;

    public Device() {

    }

    public Device(long id, String producer, String model, Color color, double price) {

        this.id = id;
        this.producer = producer;
        this.model = model;
        this.color = color;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.id + " " + this.producer + " " + this.model + " " + this.price;
    }
}
