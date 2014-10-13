package com.kademika.day11.theory.fileIO.frame6_7InputOutput;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedReader implements FileReader {

    @Override
    public String read(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try (
//                FileInputStream fis = new FileInputStream(fileName);
//                BufferedInputStream bis = new BufferedInputStream(fis);
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
        ) {
            int i;
            while ((i = bis.read()) != -1) {
                stringBuilder.append((char) i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
