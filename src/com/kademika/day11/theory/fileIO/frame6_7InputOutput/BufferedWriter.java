package com.kademika.day11.theory.fileIO.frame6_7InputOutput;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedWriter implements FileWriter {

    @Override
    public void write(String data, String fileName) {
        try (
//                FileOutputStream fos = new FileOutputStream(fileName);
//                BufferedOutputStream bos = new BufferedOutputStream(fos);
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
        ) {
            bos.write(data.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
