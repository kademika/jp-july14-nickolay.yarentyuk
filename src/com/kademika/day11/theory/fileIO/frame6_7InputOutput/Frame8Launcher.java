package com.kademika.day11.theory.fileIO.frame6_7InputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Frame8Launcher {

    public static void main(String[] args) throws Exception {

        File file = new File("Data.txt");
        file.createNewFile();
        InputStream inputStream = new FileInputStream(file);
    }

    public static void printStreamData(InputStream in) {
        try {
            int i;
            while ((i = in.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
