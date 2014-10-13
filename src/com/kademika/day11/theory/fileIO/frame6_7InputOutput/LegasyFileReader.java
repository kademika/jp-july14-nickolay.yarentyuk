package com.kademika.day11.theory.fileIO.frame6_7InputOutput;

import java.io.FileInputStream;
import java.io.IOException;

public class LegasyFileReader implements FileReader {

    @Override
    public String read(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(fileName);

            int i;
            while ((i = fis.read()) != -1) {
                stringBuilder.append((char) i);
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {

                }
            }
        }

        return stringBuilder.toString();
    }
}
