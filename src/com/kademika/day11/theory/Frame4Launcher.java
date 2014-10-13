package com.kademika.day11.theory;

import java.io.ByteArrayInputStream;

public class Frame4Launcher {

    public static void main(String[] args) {

        ByteArrayInputStream in = new ByteArrayInputStream(new byte[]{1, 2, 3});
        printStreamData(in);
    }

    public static void printStreamData(ByteArrayInputStream in) {
        int i;
        while ((i = in.read()) != -1) {
            System.out.print(i + " ");
        }
    }
}
