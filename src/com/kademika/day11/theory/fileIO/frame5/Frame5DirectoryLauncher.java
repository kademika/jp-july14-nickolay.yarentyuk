package com.kademika.day11.theory.fileIO.frame5;

        import java.io.File;

public class Frame5DirectoryLauncher {

    public static void main(String[] args) {

//        String path = "src/com/kademika/day11/theory/files/";
        String path = "G:/1/Java/Files";
        path = path.replace("/", File.separator);

//        File file = new File(path, "File1.txt");
        File file = new File("File1.txt");
        System.setProperty("user.dir", path);

        System.out.println(System.getProperty("user.dir"));
        System.out.println(file.getAbsolutePath());

//        String path1 = "src/com/kademika/day11/theory/files/";
//        String path2 = "G:/1/Java/Files";
//        path1 = path1.replace("/", File.separator);
//        path2 = path2.replace("/", File.separator);
//
//        File file = new File(path1, "File1.txt");
//        System.out.println(file.getAbsolutePath());
//        file = new File(path2, "File1.txt");
//        System.out.println(file.getAbsolutePath());
//        file = new File(path1, "File1.txt");
//        System.out.println(file.getAbsolutePath());
    }
}
