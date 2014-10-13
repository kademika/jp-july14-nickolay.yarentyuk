package com.kademika.day11.theory.frame3;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class BAISWriterLauncher {

    public static void main(String[] args) {

        byte[] bytes = {-128, -100, -50, 0, 50, 100, 127};

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        for (int i = 0; i < bytes.length; i++) {
            out.write(bytes[i]);
        }

        System.out.println(Arrays.toString(out.toByteArray()));
    }
}
