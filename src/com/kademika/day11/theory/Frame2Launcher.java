package com.kademika.day11.theory;

public class Frame2Launcher {

    public static void main(String[] args) {

        print(0, 300);
    }

    public static void print(int first, int last) {
        for (int i = first; i <= last; i++) {
            System.out.println((byte) i);
        }
    }
}
