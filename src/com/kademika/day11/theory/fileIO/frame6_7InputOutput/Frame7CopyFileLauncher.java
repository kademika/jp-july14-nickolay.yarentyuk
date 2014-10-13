package com.kademika.day11.theory.fileIO.frame6_7InputOutput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Frame7CopyFileLauncher {

    public static void main(String[] args) {

        String fileName = "Data.txt";
        fileName.replace("/", File.separator);

        File originalFile = new File(fileName);

        copyFile(originalFile);
    }

//    public static void copyFile(File file) {
//        String sourceFileName = file.getAbsolutePath();
//        String newFileName = "";
//        int dotNumber;
//        String data;
//
//        newFileName = setNewFileName(sourceFileName);
//
//        FileReader reader = new DefaultFileReader();
//        data = reader.read(sourceFileName);
//
//        FileWriter writer = new DefaultFileWriter();
//        writer.write(data, newFileName);
//    }

    public static void copyFile(File file) {
        String sourceFileName = file.getAbsolutePath();
        String newFileName = "";

        newFileName = setNewFileName(sourceFileName);

        copyFile(sourceFileName, newFileName);
    }

    public static void copyFile(String sourceFileName, String newFileName) {
        StringBuilder data = new StringBuilder();

        try (
                FileInputStream fis = new FileInputStream(sourceFileName);
                FileOutputStream fos = new FileOutputStream(newFileName)
        ) {
            long i;
            while ((i = fis.read()) != -1) {
                data.append((char) i);
            }

            fos.write(data.toString().getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String setNewFileName(String sourceFileName) {
        StringBuilder newFileName = new StringBuilder();
        int dotNumber;

        for (dotNumber = sourceFileName.length() - 1; dotNumber >= 0; dotNumber--) {
            if (sourceFileName.charAt(dotNumber) == '.') {
                break;
            }
        }

        for (int i = 0; i < dotNumber; i++) {
            newFileName.append(sourceFileName.charAt(i));
        }
        newFileName.append("Copy");
        newFileName.append(sourceFileName.substring(dotNumber));

        return newFileName.toString();
    }
}
