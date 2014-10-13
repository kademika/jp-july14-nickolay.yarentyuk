package com.kademika.day11.theory.fileIO.frame6_7InputOutput;

import java.io.*;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;

public class JDKReader implements FileReader {

    @Override
    public String read(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try (
            FileInputStream fis = new FileInputStream(fileName);
//            InputStreamReader isr = new InputStreamReader(fis);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.ISO_8859_1);
            java.io.BufferedReader bufferedReader = new BufferedReader(isr);
        ) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
