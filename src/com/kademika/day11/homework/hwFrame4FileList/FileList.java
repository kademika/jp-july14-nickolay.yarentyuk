package com.kademika.day11.homework.hwFrame4FileList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileList {

    private File file;
    public List<String> list;

    public FileList(String fileName) {
        file = new File(fileName);
        try {
            if (! file.exists()) {
                file.createNewFile();
            } else {
                readFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(String newStr) {
        boolean isSpace = false;
        int i = -1;

        for (String s : list) {
            i++;
            if (s.length() == 0) {
                isSpace = true;
                break;
            }
        }
            if (isSpace == false) {
                list.add(newStr);
            } else {
                list.set(i, newStr);
            }

        writeToFile();
    }

    public String get(int index) {
        if (index < list.size()) {
            return list.get(index);
        }
        return "";
    }

    public int getIndex(String data) {
        int i = -1;
        for (String s : list) {
            i++;
            if (s.compareTo(data) == 0) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(String s) {
        int i = getIndex(s);
        if (i != -1) {
            remove(i);
        }

        writeToFile();

        return false;
    }

    public boolean remove(int index) {
        if ((index >= 0) && index < list.size()) {
            if (index == list.size() - 1) {
                list.remove(index);
            } else {
                list.set(index, "");
            }
            writeToFile();
            return true;
        }

        return false;
    }

    private void readFile() {
        list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        try(FileInputStream fis = new FileInputStream(file)) {
            int i;
            while ((i = fis.read()) != -1) {

                if ((char) i != '\n') {
                    sb.append((char) i);
                } else {
                    list.add(sb.toString());
                    sb = new StringBuilder("");
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile() {
        try(FileOutputStream fos = new FileOutputStream(file)) {
            for (String s : list) {
                fos.write((s + '\n').getBytes());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
