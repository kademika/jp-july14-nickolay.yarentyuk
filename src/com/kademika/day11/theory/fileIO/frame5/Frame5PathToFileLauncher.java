package com.kademika.day11.theory.fileIO.frame5;

import java.io.File;

public class Frame5PathToFileLauncher {

    public static void main(String[] args) {

        File file = new File("file1.txt");

        System.out.println("User directory:");
        System.out.println(System.getProperty("user.dir"));

        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
        System.out.println();

        for (File f : File.listRoots()) {
            System.out.println(f.getAbsolutePath());
        }
        System.out.println();

        System.out.println(getRelativeFileDir());
        System.out.println(getFilePath());
    }

    public static String getRelativeFileDir() {
        String path = "src/com/kademika/day11/theory";
        return path.replace("/", File.separator);
    }

    public static String getFilePath() {
        String path = "src/com/kademika/day11/theory";
        path = path.replace("/", File.separator);

        File thisFile = new File(path, Frame5PathToFileLauncher.class.getSimpleName() + ".java");
        return thisFile.getAbsolutePath();
    }
}
