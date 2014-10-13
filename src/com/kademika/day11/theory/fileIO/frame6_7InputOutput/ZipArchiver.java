package com.kademika.day11.theory.fileIO.frame6_7InputOutput;

import java.io.*;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipArchiver {

    public static void main(String[] args) {

        ZipArchiver zipArchiver = new ZipArchiver();
//        zip("d:/Blank.jpg", "d:/1.zip");
//        String name1 = "d:/Blank.jpg";
        String name1 = "e:/MyData/";
        name1 = name1.replace("/", File.separator);
//        String name2 = "d:/1.zip";
        String name2 = "e:/Aaa/1/2.zip";
        name2 = name2.replace("/", File.separator);

        zipArchiver.zip(name1, name2);

        zipArchiver.unZip(name2);
    }

    public void zip(String sourceName, String zipName) {

        try {
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipName));
            zos.setLevel(Deflater.BEST_COMPRESSION);

            int i;
            for (i = sourceName.length() - 2; i >= 0; i--) {
                if (sourceName.charAt(i) == File.separator.charAt(0)) {
                    break;
                }
            }
//            System.out.println(i);

            String sourcePath = sourceName.substring(0, i);
//            System.out.println(sourcePath);

            zipTheCatalog(sourcePath, sourceName, zos);

            zos.close();

            System.out.println("Done.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void zipTheCatalog(String sourcePath, String filePath, ZipOutputStream zos) throws /*FileNotFoundException, */IOException {
        File dir = new File(filePath);

        if (! dir.isDirectory()) {
            FileInputStream fis = new FileInputStream(dir);
            ZipEntry zipEntry = new ZipEntry(filePath);
            zipTheFile(fis, zos, zipEntry);

        } else {
            String[] files = dir.list();
            if (files.length == 0) {
                ZipEntry zipEntry = new ZipEntry(dir.getPath().substring(sourcePath.length()) + '/');
                zos.putNextEntry(zipEntry);

            } else {
                for (int i = 0; i < files.length; i++) {
                    File file = new File(dir, files[i]);
                    if (file.isDirectory()) {
                        zipTheCatalog(sourcePath, file.getAbsolutePath(), zos);
                    } else {

                        FileInputStream fis = new FileInputStream(file);
                        ZipEntry zipEntry = new ZipEntry(file.getPath().substring(sourcePath.length()));
                        zipTheFile(fis, zos, zipEntry);
                    }
                }
            }
        }
    }

    private void zipTheFile(FileInputStream fis, ZipOutputStream zos, ZipEntry zipEntry) throws /*FileNotFoundException, */IOException {
        zos.putNextEntry(zipEntry);

        byte[] byteBuffer = new byte[1024];
//        byte[] byteBuffer = new byte[2156];
        int bytes;
        while ((bytes = fis.read(byteBuffer)) != -1) {
            zos.write(byteBuffer, 0, bytes);
        }
    }

    public void unZip(String zipName) {
        try {
            FileInputStream fis = new FileInputStream(zipName);
            ZipInputStream zis = new ZipInputStream(fis);

            ZipEntry zipEntry;
            FileOutputStream fos;
            String cdName = zipName.substring(0, zipName.length() - 4);
//            System.out.println(cdName);
//            System.out.println();
            File dir = new File(cdName);
            dir.mkdir();

            while ((zipEntry = zis.getNextEntry()) != null) {
                String zipEntryName = zipEntry.getName();

                if (zipEntryName.charAt(zipEntryName.length() - 1) == '/' || zipEntryName.charAt(zipEntryName.length() - 1) == File.separator.charAt(0)) {
                    mkdirs(cdName, zipEntryName, zipEntryName.length() - 2);
                } else {
                    int length;
                    for (length = zipEntryName.length() - 1; length >= 0; length--) {
                        if (zipEntryName.charAt(length) == File.separator.charAt(0) || zipEntryName.charAt(length) == '/') {
                            break;
                        }
                    }

                    mkdirs(cdName, zipEntryName, length);

                    fos = new FileOutputStream(cdName + File.separator + zipEntry.getName());
//                    System.out.println(cdName + zipEntry.getName());

                    int currentByte;
                    while ((currentByte = zis.read()) != -1) {
                        fos.write(currentByte);
                    }
//                    zis.closeEntry();
                }
            }

            System.out.println("Done.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mkdirs(String cdName, String zipEntryName, int length) {
        int i = -1;
        StringBuilder path = new StringBuilder(cdName + File.separator);
        char symbol;

        while (i <= length) {

            i++;
            symbol = zipEntryName.charAt(i);

            if (symbol == File.separator.charAt(0) || symbol == '/') {
//                System.out.println(path.toString());
                File file = new File(path.toString());
                file.mkdir();
            }

            path.append(symbol);
        }
    }
}
