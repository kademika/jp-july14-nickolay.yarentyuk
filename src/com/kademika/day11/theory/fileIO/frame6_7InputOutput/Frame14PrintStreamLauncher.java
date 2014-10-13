package com.kademika.day11.theory.fileIO.frame6_7InputOutput;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class Frame14PrintStreamLauncher {

    public static void main(String[] args) {

        File file = new File("Data.txt");

        try {
            PrintStream prinstr = System.out;

            file.createNewFile();
            PrintStream ps = new PrintStream(file);
            System.setOut(ps);

            System.out.println("Hello, guys. )))");
            System.out.print("How");
            System.setOut(prinstr);
            System.out.println(" are you?");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
