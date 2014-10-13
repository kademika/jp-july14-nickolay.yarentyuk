package com.kademika.day11.theory.fileIO.frame6_7InputOutput;

import java.io.*;

public class Frame10BufferedCopyFileLauncher {

    public static void main(String[] args) {

        String fileName = "1.png";
        fileName.replace("/", File.separator);

        File originalFile = new File(fileName);

        copyFile(originalFile);
    }

    public static void copyFile(File file) {
        String sourceFileName = file.getAbsolutePath();
        String newFileName = "";

        newFileName = setNewFileName(sourceFileName);

        copyFile(sourceFileName, newFileName);
    }

    public static void copyFile(String sourceFileName, String newFileName) {
        StringBuilder data = new StringBuilder();

        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFileName));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFileName))
        ) {
            long i;
            while ((i = bis.read()) != -1) {
                bos.write((byte) i);
            }

            bos.flush();
            bos.close();

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
