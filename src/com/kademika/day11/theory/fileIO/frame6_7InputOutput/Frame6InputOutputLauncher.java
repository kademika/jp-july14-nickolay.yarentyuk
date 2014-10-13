package com.kademika.day11.theory.fileIO.frame6_7InputOutput;

public class Frame6InputOutputLauncher {

    public static void main(String[] args) {

        String fileName = "Data.txt";

        FileWriter writer = new LegacyFileWriter();
        writer.write("LegacyFileWriter", fileName);

        FileReader reader = new LegasyFileReader();
        System.out.println(reader.read(fileName));

        writer = new DefaultFileWriter();
        writer.write("DefaultFileWriter", fileName);

        reader = new DefaultFileReader();
        System.out.println(reader.read(fileName));

        writer = new BufferedWriter();
        writer.write("BufferedWriter", fileName);

        reader = new BufferedReader();
        System.out.println(reader.read(fileName));

        writer = new JDKWriter();
        writer.write("JDKWriter", fileName);

        reader = new JDKReader();
        System.out.println(reader.read(fileName));

        writer = new JDKWriterAuto();
        writer.write("JDKWriterAuto", fileName);

        reader = new JDKReaderAuto();
        System.out.println(reader.read(fileName));
    }
}
