package com.kademika.day10.theory.frame22_28;

@Service
public class Box {

    private int width;
    public Integer length;
    private Integer height;

    public Box() {
        width = -1;
        length = -2;
        height = -3;
    }

    public Box(Integer width, Integer length, Integer height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
