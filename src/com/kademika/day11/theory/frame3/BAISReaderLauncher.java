package com.kademika.day11.theory.frame3;

import java.io.ByteArrayInputStream;

public class BAISReaderLauncher {

    public static void main(String[] args) {

        byte[] bytes = {-128, -100, -50, 0, 50, 100, 127};

        ByteArrayInputStream in = new ByteArrayInputStream(bytes);

        int i;
        while ((i = in.read()) != -1) {
            System.out.print((byte) i + " ");
        }

//        System.out.println(in.read());
//        System.out.println(in.read());
//        System.out.println(in.read());
//        System.out.println(in.read());
//        System.out.println(in.read());
//        System.out.println(in.read());
//        System.out.println(in.read());
    }
}
