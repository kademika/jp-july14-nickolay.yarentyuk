package com.kademika.day11.theory.fileIO.frame6_7InputOutput;

public class JDKWriterAuto implements FileWriter {

    @Override
    public void write(String data, String fileName) {
        try (java.io.FileWriter fileWriter = new java.io.FileWriter(fileName)) {
            fileWriter.write(data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
