package com.kademika.day11.theory.fileIO.frame6_7InputOutput;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class JDKReaderAuto implements FileReader {

    @Override
    public String read(String fileName) {
        String data = "";

        try (
            java.io.FileReader fileReader = new java.io.FileReader(fileName)
        ) {
//            data = fileReader.;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
