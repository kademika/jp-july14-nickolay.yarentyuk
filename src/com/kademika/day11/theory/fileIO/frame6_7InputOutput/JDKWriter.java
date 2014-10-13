package com.kademika.day11.theory.fileIO.frame6_7InputOutput;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JDKWriter implements FileWriter {

    @Override
    public void write(String data, String fileName) {
        try (
                FileOutputStream fos = new FileOutputStream(fileName);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos, StandardCharsets.ISO_8859_1)
//                java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(outputStreamWriter);
        ) {
            outputStreamWriter.write(data);
//            bufferedWriter.write(data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
