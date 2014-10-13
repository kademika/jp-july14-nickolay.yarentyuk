package com.kademika.day11.theory.fileIO.frame6_7InputOutput;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ChangeFileEncoding {

    public static void main(String[] args) {

        File file = new File("Data.txt");
        String currentEncoding = "cp1251";
        String neededEncoding = "ISO_8859_1";

        changeFileEncoding(file, currentEncoding, neededEncoding);
    }

    public static void changeFileEncoding(File file, String currentEncoding, String neededEncoding) {
        String fileName = file.getPath();

        StringBuilder stringBuilder = new StringBuilder();

        try (
                FileInputStream fis = new FileInputStream(fileName);
                InputStreamReader isr = new InputStreamReader(fis, currentEncoding);
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(isr);
        ) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder.toString());

        try (
                FileOutputStream fos = new FileOutputStream(fileName);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos, neededEncoding)
        ) {
            outputStreamWriter.write(stringBuilder.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
